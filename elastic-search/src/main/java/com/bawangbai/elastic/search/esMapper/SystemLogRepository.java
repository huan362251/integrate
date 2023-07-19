package com.bawangbai.elastic.search.esMapper;

import com.bawangbai.elastic.search.pojo.es.SystemLogDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SystemLogRepository extends ElasticsearchRepository<SystemLogDO,Long> {

}
