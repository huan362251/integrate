package com.example.elastic.search8.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.Refresh;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch.cat.aliases.AliasesRecord;
import co.elastic.clients.elasticsearch.core.CreateRequest;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.SearchTemplateResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.elastic.search8.entity.OperationLogDO;
import com.example.elastic.search8.entity.OperationLogInfo;
import com.example.elastic.search8.entity.OperationLogQueryReq;
import com.example.elastic.search8.entity.OperationLogReq;
import com.example.elastic.search8.service.OperationLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Date 2022/10/24 11:17
 * @Author by liu.huan
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OperationLogServiceImpl implements OperationLogService {

//    private final OperationLogRepository operationLogRepository;

//    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    private final ElasticsearchClient elasticsearchClient;

    @Override
    public Long saveLog(OperationLogReq operationLogReq) {
        try {
            OperationLogDO operationLogDO = new OperationLogDO();
            operationLogReq.setGenerateTime(LocalDateTime.now());
            BeanUtils.copyProperties(operationLogReq, operationLogDO);
            long next = IdUtil.createSnowflake(1,1).nextId();
            System.out.println("下一 Long id:"+next);
            System.out.println("下一 String id:"+String.valueOf(next));
            operationLogDO.setId(next);
//            elasticsearchClient.create(CreateRequest.of(r->r.routing("operation_log_alias").index("operation_log_05").id(String.valueOf(next)).document(operationLogDO)));

            elasticsearchClient.create(CreateRequest.of(r->r.index("operation_log_06").id(String.valueOf(next)).document(operationLogDO).refresh(Refresh.True)));
            return operationLogDO.getId();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Page<OperationLogInfo> getOperationLog(OperationLogQueryReq operationLogQueryReq) {
        if ((ObjectUtil.isEmpty(operationLogQueryReq.getGenerateTimeBegin()) && ObjectUtil.isNotEmpty(operationLogQueryReq.getGenerateTimeEnd()))
                || (ObjectUtil.isNotEmpty(operationLogQueryReq.getGenerateTimeBegin()) && ObjectUtil.isEmpty(operationLogQueryReq.getGenerateTimeEnd()))
        ) {
            log.info("date param error,start:{},end:{}", operationLogQueryReq.getGenerateTimeBegin(), operationLogQueryReq.getGenerateTimeEnd());
            return null;
        }

        try {
            //        List<OperationLogDO> logs = search.getSearchHits().stream().map(req -> req.getContent()).collect(Collectors.toList());
            SearchResponse<OperationLogDO> response = elasticsearchClient.search(buildQuery(operationLogQueryReq), OperationLogDO.class);
//            SearchResponse<OperationLogDO> response = elasticsearchClient.search(r->r.routing("operation_log_alias"),OperationLogDO.class);
//            SearchTemplateResponse<OperationLogDO> response = elasticsearchClient.searchTemplate(r -> r.id("operation_log_alias"), OperationLogDO.class);
//            SearchResponse<OperationLogDO> response = elasticsearchClient.search(r->r.index("operation_log_alias"),OperationLogDO.class);
            log.info("response:{}",response);
            for (Hit<OperationLogDO> hit : response.hits().hits()) {
                log.info("id：{},source:{}",hit.id(),hit.source());
            }
//            List<OperationLogDO> logs = response.hits().hits().stream().map(Hit::source).collect(Collectors.toList());
//            List<OperationLogInfo> operationLogs = new ArrayList<>();
//            if (CollectionUtil.isNotEmpty(logs)) {
//                operationLogs = logs.stream().map(operationLogDO -> {
//                    OperationLogInfo operationLog = new OperationLogInfo();
//                    BeanUtils.copyProperties(operationLogDO, operationLog);
//                    return operationLog;
//                }).collect(Collectors.toList());
//            }
//            for (OperationLogInfo operationLog : operationLogs) {
//                System.out.println(operationLog);
//            }
//            return Result.success(EsPageInfoUtils.esPageToDbPage(operationLogQueryReq.getCurrent(), operationLogQueryReq.getSize(), response.hits().total().value(), operationLogs));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * 构建查询
     *
     * @param operationLogQueryReq
     * @return
     */
    private SearchRequest buildQuery(OperationLogQueryReq operationLogQueryReq) {
        SearchRequest.Builder builder = new SearchRequest.Builder();
        BoolQuery.Builder boolBuilder = new BoolQuery.Builder();
        if (ObjectUtil.isNotEmpty(operationLogQueryReq.getMerchantNo())) {
            boolBuilder.must(t->t.term(r->r.field("merchantNo").value(operationLogQueryReq.getMerchantNo())));
        }
        if (StringUtils.isNotBlank(operationLogQueryReq.getOwSource())) {
            boolBuilder.must(t->t.term(r->r.field("owSource").value(operationLogQueryReq.getOwSource())));
        }
        if(StringUtils.isNotBlank(operationLogQueryReq.getDescribe())){
            boolBuilder.must(t->t.wildcard(r->r.field("describe.keyword").value("*" + operationLogQueryReq.getDescribe() + "*")));
        }
        if(StringUtils.isNotBlank(operationLogQueryReq.getIp())){
            boolBuilder.must(t->t.term(r->r.field("ip").value(operationLogQueryReq.getIp())));
        }
        if (ObjectUtil.isNotEmpty(operationLogQueryReq.getGenerateTimeBegin())) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            String beginTime = operationLogQueryReq.getGenerateTimeBegin().format(dateTimeFormatter);
            String endTime = operationLogQueryReq.getGenerateTimeEnd().format(dateTimeFormatter);
            boolBuilder.must(t->t.range(g->g.field("generateTime").from(beginTime).to(endTime)));
        }
        if (ObjectUtil.isNotEmpty(operationLogQueryReq.getOperationId())) {
            boolBuilder.must(t->t.term(q->q.field("operationId").value(operationLogQueryReq.getOperationId())));
        }
        builder.index("operation_log_alias").query(r->r.bool(boolBuilder.build()));
//        builder.index("operation_log_04").query(r->r.bool(boolBuilder.build()));
        //分页
        builder.from( 0).size(100);
        builder.sort(s->s.field(t->t.field("generateTime").order(SortOrder.Desc)))
                .sort(s->s.field(t->t.field("id").order(SortOrder.Desc)));
        //构建
        return builder.build();
    }

}
