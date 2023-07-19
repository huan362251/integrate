package com.example.elastic.search.company.log.service.impl;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.IdcardUtil;
import com.example.elastic.search.company.entity.SystemLog;
import com.example.elastic.search.company.entity.SystemLogDO;
import com.example.elastic.search.company.entity.SystemLogReq;
import com.example.elastic.search.company.entity.SystemLogSaveReq;
import com.example.elastic.search.company.log.service.SystemLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SystemLogServiceImpl implements SystemLogService {

    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public void saveLog(SystemLogSaveReq systemLogSaveReq) {
        SystemLogDO systemLogDO = new SystemLogDO();
        BeanUtils.copyProperties(systemLogSaveReq, systemLogDO);
        systemLogDO.setGenerateDateTime(systemLogSaveReq.getGenerateTime());
        long next = 1L;
        systemLogDO.setId(next);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMM");
        String format = now.format(dateTimeFormatter);
        elasticsearchRestTemplate.save(systemLogDO, IndexCoordinates.of("system_log_" + format));
    }

    @Override
    public void queryLog(SystemLogReq systemLogReq) {
        boolean flag = (StringUtils.isNotBlank(systemLogReq.getOriServiceId()) && StringUtils.isBlank(systemLogReq.getThreadId()))
                || StringUtils.isNotBlank(systemLogReq.getServiceId());
        List<String> threadIds = new ArrayList<>();
        if (flag) {
            SearchHits<SystemLogDO> search = elasticsearchRestTemplate.search(buildQueryServiceToThreadId(systemLogReq), SystemLogDO.class, IndexCoordinates.of("system_log_alias"));
            if (search.hasAggregations()) {
                Aggregations aggregations = search.getAggregations();
                ParsedStringTerms parsedStringTerms = aggregations.get("distinct");
                List<? extends Terms.Bucket> buckets = parsedStringTerms.getBuckets();
                for (Terms.Bucket bucket : buckets) {
                    String keyAsString = bucket.getKeyAsString();
                    if (StringUtils.isNotBlank(keyAsString)) {
                        threadIds.add(keyAsString);
                    }
                    log.info("info:{}", keyAsString);
                }
            }
        }
        if (CollectionUtil.isNotEmpty(threadIds)) {
            systemLogReq.setServiceId(null);
            systemLogReq.setOriServiceId(null);
        }
        SearchHits<SystemLogDO> search = elasticsearchRestTemplate.search(buildQuery(systemLogReq, threadIds), SystemLogDO.class, IndexCoordinates.of("system_log_alias"));

        log.info("hits:{}", search.getSearchHits());
        List<SystemLogDO> logs = search.getSearchHits().stream().map(req -> req.getContent()).collect(Collectors.toList());
        List<SystemLog> systemLogs = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(logs)) {
            systemLogs = logs.stream().map(systemLogDO -> {
                SystemLog systemLog = new SystemLog();
                BeanUtils.copyProperties(systemLogDO, systemLog);
                return systemLog;
            }).collect(Collectors.toList());
        }

    }

    /**
     * 根据serviceId查询线程id
     *
     * @param systemLogReq
     * @return
     */
    private Query buildQueryServiceToThreadId(SystemLogReq systemLogReq) {
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = getBoolQueryBuilder(systemLogReq, null);

        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("distinct").field("threadId")
                .subAggregation(AggregationBuilders.topHits("category_top").size(1));
        nativeSearchQueryBuilder = nativeSearchQueryBuilder.addAggregation(termsAggregationBuilder);
        nativeSearchQueryBuilder = nativeSearchQueryBuilder.withQuery(boolQueryBuilder);
        nativeSearchQueryBuilder = nativeSearchQueryBuilder.withPageable(PageRequest.of(0, 1));
        return nativeSearchQueryBuilder.build();
    }

    /**
     * @param systemLogReq 入参
     * @return
     */
    private Query buildQuery(SystemLogReq systemLogReq, List<String> threadIds) {
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = getBoolQueryBuilder(systemLogReq, threadIds);
        //分页
        Pageable pageable = PageRequest.of((int) 1, 10);
        nativeSearchQueryBuilder = nativeSearchQueryBuilder.withPageable(pageable);
        //排序
        nativeSearchQueryBuilder = nativeSearchQueryBuilder
                .withSort(SortBuilders.fieldSort("generateDateTime").order(SortOrder.DESC))
                .withSort(SortBuilders.fieldSort("generateTime").order(SortOrder.DESC))
                .withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC))
        ;
        //构建
        return nativeSearchQueryBuilder.withQuery(boolQueryBuilder).build();
    }

    private static BoolQueryBuilder getBoolQueryBuilder(SystemLogReq systemLogReq, List<String> threadIds) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        if (StringUtils.isNotBlank(systemLogReq.getMerchantOrderNumber())) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("merchantOrderNumber", systemLogReq.getMerchantOrderNumber()));
        }
        if (StringUtils.isNotBlank(systemLogReq.getThreadId())) {
            boolQueryBuilder.must(QueryBuilders.wildcardQuery("threadId", "*" + systemLogReq.getThreadId().toLowerCase() + "*"));
        }
        if (StringUtils.isBlank(systemLogReq.getThreadId()) && CollectionUtil.isNotEmpty(threadIds)) {
            boolQueryBuilder.must(QueryBuilders.termsQuery("threadId", threadIds));
        }

        String shop = systemLogReq.getShop();
        if (StringUtils.isNotEmpty(shop)) {
            //要求仅输入店铺名时模糊查询，输入全域名时精确匹配
            if (shop.contains(".")) {
                //精确查询
                boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("shop", shop));
            } else {
                //模糊查询
                boolQueryBuilder.must(QueryBuilders.wildcardQuery("shop", "*" + systemLogReq.getShop().toLowerCase() + "*"));
            }
        }
        if (StringUtils.isNotEmpty(systemLogReq.getPaymentID())) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("paymentID", systemLogReq.getPaymentID()));
        }

        return boolQueryBuilder;
    }

}
