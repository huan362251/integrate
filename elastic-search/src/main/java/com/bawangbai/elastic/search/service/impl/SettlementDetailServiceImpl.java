package com.bawangbai.elastic.search.service.impl;

import cn.hutool.core.collection.CollectionUtil;
//import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.elasticsearch.core.CreateResponse;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bawangbai.elastic.search.esMapper.NameDao;
import com.bawangbai.elastic.search.esMapper.SettlementDetailRepository;
import com.bawangbai.elastic.search.mapper.SettlementDetailMapper;
import com.bawangbai.elastic.search.pojo.entity.SettlementDetail;
import com.bawangbai.elastic.search.pojo.es.NameDO;
import com.bawangbai.elastic.search.pojo.es.SettlementDetailESDO;
import com.bawangbai.elastic.search.service.SettlementDetailService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 *
 */
@Slf4j
@Service
public class SettlementDetailServiceImpl extends ServiceImpl<SettlementDetailMapper, SettlementDetail>
        implements SettlementDetailService {

    @Autowired
    private SettlementDetailRepository detailRepository;

    @Autowired
    private NameDao nameDao;

    @Autowired
    private ElasticsearchRestTemplate restTemplate;

    /**
     * 把db数据搬到es里去
     */
    @Override
    public void moveData() {
//        List<SettlementDetail> settlementDetails = this.baseMapper.selectList(null);
        List<SettlementDetail> settlementDetails = this.baseMapper.selectList(new LambdaQueryWrapper<SettlementDetail>()
                .last(" limit 10000 ")
        );
        for (int i = 0; i < 10; i++) {
            SettlementDetailESDO settlementDetailESDO = new SettlementDetailESDO();
            settlementDetailESDO.setId(Long.valueOf(i));
            settlementDetailESDO.setServiceId(Long.valueOf(i));
            long start = System.currentTimeMillis();
            restTemplate.save(settlementDetailESDO);
            long end = System.currentTimeMillis();
//            log.info("花费时间毫秒:{}",end-start);

            List<SettlementDetailESDO> list = new ArrayList<>();
            for (SettlementDetail settlementDetail : settlementDetails) {
                SettlementDetailESDO esdo = new SettlementDetailESDO();
                BeanUtils.copyProperties(settlementDetail,esdo);
                list.add(esdo);
                if (list.size() % 10000 == 0) {
                    restTemplate.save(list);
                    list.clear();
                }
            }
            if (CollectionUtil.isNotEmpty(list)) {
                restTemplate.save(list);
            }
        }
    }

    @Override
    public void saveDataName() {

        String[] aaa = {"aaa","aab","aac","aad"};
        Random random = new Random();

//        for (int i = 0; i < 100; i++) {
//            NameDO nameDO = new NameDO();
//            nameDO.setId(Long.valueOf(i));
//            nameDO.setNameZn("花木成畦手自栽"+i);
//            nameDO.setNameEn(aaa[random.nextInt(aaa.length)]);
//            List<String> list = new ArrayList<>();
//            list.add(UUID.randomUUID().toString().replace("-",""));
//            list.add(UUID.randomUUID().toString().replace("-",""));
//            list.add(UUID.randomUUID().toString().replace("-",""));
//            nameDO.setNoList(list);
//            nameDao.save(nameDO);
//        }

        NameDO nameDO = new NameDO();
        nameDO.setId(1000L);
        nameDO.setNameZn("3abc");
        nameDO.setNameEn("3abc");
        List<String> list = new ArrayList<>();
        list.add("3abc");
        nameDO.setNoList(list);
        nameDao.save(nameDO);

    }

    @Override
    public void queryName() {
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();

//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("nomi","3a"));//3abc
//        boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("name_en","3a"));
//        boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("name_zh","3a"));

        BoolQueryBuilder should = new BoolQueryBuilder()
                .should(QueryBuilders.matchPhraseQuery("nomi", "3a"))
                .should(QueryBuilders.matchPhrasePrefixQuery("name_en", "3a"))
                .should(QueryBuilders.matchPhraseQuery("name_zh", "3a"));

        NativeSearchQuery build = nativeSearchQueryBuilder.withQuery(should).build();

        SearchHits<NameDO> search = restTemplate.search(build, NameDO.class);
        System.out.println(search);
        System.out.println(search.getSearchHits());
        for (SearchHit<NameDO> searchHit : search.getSearchHits()) {
            System.out.println(searchHit);
        }
    }

    @Override
    public void testCount() {
        long count =  detailRepository.count();
//        log.info("count:{}",count);
    }

//    @Autowired
//    private ElasticsearchClient client;

    public void saveBatchData(){
//        List<SettlementDetail> settlementDetails = this.baseMapper.selectList(new LambdaQueryWrapper<SettlementDetail>()
//                .last(" limit 1 ")
//        );
//        try {
//            SettlementDetail settlementD·etail1 = settlementDetails.get(0);
//            SettlementDetailESDO esdo = new SettlementDetailESDO();
//            BeanUtils.copyProperties(settlementDetail1,esdo);

//            CreateResponse settlementDetail = client.create(request -> request.index("settlement_detail")
//                    .id(String.valueOf(settlementDetail1.getId()))
//
//                    .document(settlementDetail1));
//
//            log.info("settle:{}",settlementDetail);

//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


    }

}




