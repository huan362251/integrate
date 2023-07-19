package com.bawangbai.elastic.search.esMapper;

import com.bawangbai.elastic.search.pojo.es.SettlementDetailESDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SettlementDetailRepository extends ElasticsearchRepository<SettlementDetailESDO, Long> {

}