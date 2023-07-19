package com.jdbc.springdemo.design.template_strategy.entity;

import lombok.Data;

@Data
public class ParseEntity {

    /**
     * 解析文件样式
     */
    private String fileGainType;

    /**
     * 文件解析方式
     */
    private String parseType;
}
