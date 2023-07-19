package com.bawangbai.elastic.search.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bawangbai.elastic.search.esMapper.ProductDao;
import com.bawangbai.elastic.search.esMapper.SystemLogRepository;
import com.bawangbai.elastic.search.pojo.es.Product;
import com.bawangbai.elastic.search.pojo.es.SystemLogDO;
import com.bawangbai.elastic.search.util.EsPageInfoUtils;
import com.bawangbai.elastic.search.util.SnowflakeConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("system_log")
@Api(tags = "ES系统日志")
public class SystemLogController {

    @Autowired
    private SystemLogRepository repository;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private SnowflakeConfig snowflakeConfig;

    @Autowired
    private ElasticsearchRestTemplate restTemplate;

    @GetMapping("time")
    public void saveTime(){
        Random random = new Random();
        List<SystemLogDO> list = new ArrayList<>();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        log.info("开始时间:{}",dateTime.format(formatter));
        for (int i = 0; i < 10000000; i++) {
            SystemLogDO systemLogDO = new SystemLogDO();
            systemLogDO.setId(snowflakeConfig.snowflakeId());
            systemLogDO.setGenerateTime(LocalDateTime.now());
            systemLogDO.setMerchantNo(Long.valueOf(random.nextInt(10000)));
            systemLogDO.setDetails("hehe"+i);
            String s = UUID.randomUUID().toString();
            systemLogDO.setMerchantOrderNumber(s);
            systemLogDO.setOriTxnId(snowflakeConfig.snowflakeId());
            systemLogDO.setThreadId(s + ":" + Thread.currentThread().getName());
            systemLogDO.setTxnId(snowflakeConfig.snowflakeId());
//            repository.save(systemLogDO);
            restTemplate.save(systemLogDO);
            log.info("systemLogDO success save data:{}，i:{}",systemLogDO,i);
        }
        dateTime = LocalDateTime.now();
        log.info("结束时间:{}",dateTime.format(formatter));
    }

    @GetMapping("save")
    @ApiOperation(value = "保存数据")
    public void save(){
        Random random = new Random();
        List<SystemLogDO> list = new ArrayList<>();
        for (int i = 0; i < 1500000; i++) {
            SystemLogDO systemLogDO = new SystemLogDO();
            systemLogDO.setId(snowflakeConfig.snowflakeId());
            systemLogDO.setGenerateTime(LocalDateTime.now());
            systemLogDO.setMerchantNo(Long.valueOf(random.nextInt(10000)));
            systemLogDO.setDetails("hehe"+i);
            String s = UUID.randomUUID().toString();
            systemLogDO.setMerchantOrderNumber(s);
            systemLogDO.setOriTxnId(snowflakeConfig.snowflakeId());
            systemLogDO.setThreadId(s + ":" + Thread.currentThread().getName());
            systemLogDO.setTxnId(snowflakeConfig.snowflakeId());
            list.add(systemLogDO);
            if (i%50000 ==0) {
                repository.saveAll(list);
                list.clear();
                log.info("insert data count:{}",i);
            }
        }
        if(CollectionUtil.isNotEmpty(list)){
            repository.saveAll(list);
            list.clear();
        }

    }

    @GetMapping("/querySystem")
    public void querySystem(SystemLogDO systemLogReq){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.matchQuery("merchantOrderNumber", systemLogReq.getMerchantOrderNumber()));
        NativeSearchQuery build = nativeSearchQueryBuilder.withQuery(boolQueryBuilder).build();
        SearchHits<SystemLogDO> search = restTemplate.search(build, SystemLogDO.class);
        List<SearchHit<SystemLogDO>> searchHits = search.getSearchHits();
        List<SystemLogDO> collect = searchHits.stream().map(systemLogDOSearchHit -> systemLogDOSearchHit.getContent()).collect(Collectors.toList());
        
        System.out.println(search);
        System.out.println(collect);
    }

    @GetMapping("savePro")
    @ApiOperation(value = "批量新增")
    public void savePro(){
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Product product = new Product();
            product.setId(Long.valueOf(i));
            product.setTitle("hehe:" + i);
            product.setPrice(Double.valueOf(i));
            product.setCategory("haha:" + i);
            list.add(product);
        }
        if(CollectionUtil.isNotEmpty(list)){
            productDao.saveAll(list);
            list.clear();
        }

    }


    @GetMapping("spPage")
    public Page spPage() throws IOException {
        //当前页数->按前端送的为准
        //每页显示多少页->按前端送的为准
        /*
            private long size = 10L;
            private long current = 1L;
            private String column = "create_time";
            private boolean asc = false;
         */
        Page<Product> page = new Page(1,10);
        page.setCurrent(1);
        //总条数->可以取出来
        //总页数->
        Pageable pageable = PageRequest.of(0,10);
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .build();

        SearchHits<Product> search = restTemplate.search(searchQuery, Product.class);
        long totalHits = search.getTotalHits();
        page.setTotal(totalHits);
        System.out.println("方式1总条数："+totalHits);
        long ceil = totalHits % 10 == 0 ? totalHits / 10 : (totalHits / 10 + 1);
        page.setPages(ceil);
        System.out.println("方式1总页数："+ceil);
        List<Product> collect = search.getSearchHits().stream()
                .map(productSearchHit -> productSearchHit.getContent())
                .collect(Collectors.toList());
        page.setRecords(collect);
        Page<Product> productPage = EsPageInfoUtils.esPageToDbPage(1, 10, totalHits, collect);
        return productPage;
    }

    @GetMapping("spPageOne")
    public Page spPageOne() {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(PageRequest.of(0,10))
                .build();
        SearchHits<Product> search = restTemplate.search(searchQuery, Product.class);
        List<Product> collect = search.getSearchHits().stream()
                .map(productSearchHit -> productSearchHit.getContent())
                .collect(Collectors.toList());
        Page<Product> productPage = EsPageInfoUtils.esPageToDbPage(1, 10, search.getTotalHits(), collect);
        return productPage;
    }

    @GetMapping("count")
    @ApiOperation(value = "查询计数")
    public long getCount(){
        long count = repository.count();
        log.info("count:{}",count);
        return count;
    }

    @GetMapping("query")
    @ApiOperation(value = "根据条件查询")
    public void test(){
        /**
            private Long id;
            private Long txnId;
            private String merchantOrderNumber;
            private String threadId;
            private Long merchantNo;
            private Long oriTxnId;
            private LocalDateTime generateTime;
            private String details;
         */


//        NativeSearchQuery build = new NativeSearchQueryBuilder()
//                .withPageable(PageRequest.of(0, 10))
//                .
//                .withQuery(QueryBuilders.rangeQuery())
//                .withSorts(Sort)
//                .build();

//
//
//        restTemplate.search(build,SystemLogDO.class);

    }

}
