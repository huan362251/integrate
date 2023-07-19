package com.bawangbai.elastic.search.esMapper;

import com.bawangbai.elastic.search.pojo.es.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends ElasticsearchRepository<Product,Long> {

}
