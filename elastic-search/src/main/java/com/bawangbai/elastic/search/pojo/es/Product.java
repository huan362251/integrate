package com.bawangbai.elastic.search.pojo.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDateTime;

@Data
//@Document(indexName = "product",shards = 3,replicas = 2)
public class Product {

    @Id
    private Long id;

//    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Keyword)
    private String category;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Keyword,index = false)
    private String images;

    /**
     * 日志生成时间
     */
    @Field(type=FieldType.Date,format = DateFormat.date_hour_minute_second)
    private LocalDateTime generateTime;

    /**
     * 日志生成时间
     */
    @Field(type=FieldType.Date,format = DateFormat.date_hour_minute_second_millis)
    private LocalDateTime generateDateTime;

}
