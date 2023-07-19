package com.example.elastic.search8.service.impl;

import cn.hutool.core.util.IdUtil;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.Refresh;
import co.elastic.clients.elasticsearch.core.CreateRequest;
import co.elastic.clients.elasticsearch.core.CreateResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.indices.Alias;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.sql.QueryRequest;
import co.elastic.clients.util.ObjectBuilder;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.elastic.search8.entity.SettlementDetail;
import com.example.elastic.search8.entity.SettlementDetailEsDO;
import com.example.elastic.search8.entity.SystemLogDO;
import com.example.elastic.search8.mapper.SettlementDetailMapper;
import com.example.elastic.search8.service.SettlementDetailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 */
@Slf4j
@Service
public class SettlementDetailServiceImpl extends ServiceImpl<SettlementDetailMapper, SettlementDetail>
        implements SettlementDetailService {

    @Autowired
    private ElasticsearchClient client;

    @Autowired
    private ThreadPoolExecutor poolExecutor;

    @Override
    public void test() throws IOException {
        SettlementDetailEsDO detail = new SettlementDetailEsDO();
        detail.setTxnTime(LocalDateTime.now());
        detail.setOrderTime(LocalDateTime.now());
        detail.setCreateTime(LocalDateTime.now());
        client.create(request -> request.index("settlement_detail_"+"08")
                .id("908")
                .document(detail)
        );
    }

    @Override
    public void insertDetail() {
        List<SettlementDetail> settlementDetails =
                this.baseMapper.selectList(new LambdaQueryWrapper<SettlementDetail>().last(" limit 1"));
//        for (int i = 0; i < 120; i++) {
//            CompletableFuture.runAsync(() -> extracted(settlementDetails), poolExecutor);
        extracted(settlementDetails);
//        }
    }

    private void extracted(List<SettlementDetail> settlementDetails) {
        List<BulkOperation> list = new ArrayList<>();
        for (SettlementDetail settlementDetail : settlementDetails) {
            SettlementDetailEsDO settlementDetailEsDO = new SettlementDetailEsDO();
            BeanUtils.copyProperties(settlementDetail, settlementDetailEsDO);
            LocalDateTime createTime = settlementDetail.getCreateTime();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMM");
            String localTime = df.format(createTime);
            log.info("detail info:{}",settlementDetailEsDO);
            CreateRequest<Object> createRequest = CreateRequest.of(request -> request
                    .index("settlement_detail_"+ localTime)
                    .id(String.valueOf(settlementDetailEsDO.getId()))
                    .document(settlementDetailEsDO));
            //            BulkOperation.of(request->request.index("settlement_detail").id(String.valueOf(settlementDetail.getId())).document(settlementDetail));
            try {
                client.create(createRequest);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            BulkOperation of = BulkOperation.of(request -> request.index(createRequest -> createRequest.id(IdUtil.fastUUID()).document(settlementDetail)));
//            list.add(of);
        }
//        try {
//            long start = System.currentTimeMillis();
//            log.info("begin:{}", start);
//
//            client.bulk(blukRequest -> blukRequest.index("settlement_detail_01").operations(list).refresh(Refresh.True));
//            long end = System.currentTimeMillis();
//            log.info("end:{}", end);
//            log.info("suceess:{}", end - start);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void queryTest() throws IOException {
//                        .query(q -> q.term(t -> t.field("acntType").value(v->v.stringValue("OP_CUST"))))
        SearchResponse<SettlementDetailEsDO> search = client.search(s ->
                        s.index("settlement_detail")
                                .query(v -> v.match(m -> m.query("OP_CUST").field("acntType")))
                , SettlementDetailEsDO.class);

        System.out.println("长度：" + search.hits().hits().size());
    }

    @Override
    public void aliasTest() throws IOException {
//        CreateIndexResponse createIndexResponse = client.indices().create(
//                new CreateIndexRequest.Builder()
//                        .index("my_index")
//                        .aliases("foo", new Alias.Builder().isWriteIndex(true).build()).build()
//        );
        CreateIndexResponse createIndexResponse = client.indices()
                .create(request -> request
                        .index("my_index1")
                        .aliases("foo1", alias -> alias.isWriteIndex(false)));
        CreateIndexResponse createIndexResponse1 = client.indices()
                .create(request -> request
                        .index("my_index2")
                        .aliases("foo1", alias -> alias.isWriteIndex(false)));
        System.out.println("创建结果：" + createIndexResponse.acknowledged());
        System.out.println("创建结果：" + createIndexResponse1.acknowledged());

    }

    @Override
    public void addSettle() {
        SettlementDetailEsDO systemLogDO = new SettlementDetailEsDO();
        systemLogDO.setAppId(123L);
        systemLogDO.setDirection("happy");
        try {
            IndexResponse response = client.index(q -> q.index("my_index2").id("123").document(systemLogDO));
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
