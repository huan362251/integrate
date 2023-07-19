package com.bawangbai.elastic.search.controller;

import cn.hutool.core.util.IdUtil;
import com.bawangbai.elastic.search.pojo.entity.ProductInfo;
import com.bawangbai.elastic.search.pojo.es.Product;
import com.bawangbai.elastic.search.service.ProductService;
import lombok.extern.slf4j.Slf4j;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.util.IdGenerator;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("productLog")
public class ProductLogController {


    @Autowired
    private ProductService productService;

    @PostMapping("insert")
    public void moveDataDetail(@RequestBody ProductInfo product) {
        Product product1 = new Product();
        BeanUtils.copyProperties(product,product1);
        if(StringUtils.isEmpty(product.getFlag())){
            product1.setGenerateTime(LocalDateTime.now());
        } else {
            product1.setGenerateDateTime(LocalDateTime.now());
        }
        productService.insert(product1);
        log.info("success");
    }

    @PostMapping("insertBatch")
    public void insertBatch(){
        LocalDateTime now = LocalDateTime.now();
        for (int i = 0; i < 100; i++) {
            Product product1 = new Product();
            product1.setCategory("手机");
            product1.setGenerateTime(now.plusDays(i));
            product1.setId(i+10L);
            product1.setGenerateDateTime(now.plusDays(i));
            product1.setPrice(Double.valueOf(i));
            productService.insert(product1);
        }
    }

    @GetMapping("queryOrderTime")
    public void queryOrderTime(){
        productService.queryOrderTime();
    }

    @Autowired
    private ElasticsearchRestTemplate template;

    @GetMapping("testAutoCreate")
    public void testAutoCreate(){
        Product product1 = new Product();
        product1.setCategory("手机");
        product1.setGenerateTime(LocalDateTime.now());
        product1.setId(212L);
        product1.setGenerateDateTime(LocalDateTime.now().plusMonths(1));
        product1.setPrice(Double.valueOf(1000));
        productService.insert(product1);
        template.save(product1, IndexCoordinates.of("product_log-202306"));
    }


}
