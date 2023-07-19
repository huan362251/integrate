package com.bawangbai.elastic.search.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bawangbai.elastic.search.pojo.entity.SettlementDetail;
import com.bawangbai.elastic.search.pojo.es.Product;

/**
 *
 */
public interface ProductService {

    public void insert(Product product);

    void queryOrderTime();
}
