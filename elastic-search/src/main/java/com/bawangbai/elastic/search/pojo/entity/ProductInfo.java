package com.bawangbai.elastic.search.pojo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Data
public class ProductInfo {

    private Long id;

    private String title;

    private String category;

    private Double price;

    private String images;

    private String flag;
}
