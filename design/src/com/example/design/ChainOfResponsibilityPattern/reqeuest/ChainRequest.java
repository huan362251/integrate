package com.example.design.ChainOfResponsibilityPattern.reqeuest;

import lombok.Data;

/**
 * @Description
 * @Date 2022/10/31 16:03
 * @Author by liu.huan
 */
@Data
public class ChainRequest {

    /**
     * 请假天数
     */
    private int num;

    /**
     * 请假内容
     */
    private String content;

}
