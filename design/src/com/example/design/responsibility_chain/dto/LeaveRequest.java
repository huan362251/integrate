package com.example.design.responsibility_chain.dto;


import lombok.Data;

@Data
public class LeaveRequest {

    /**
     * 请假天数
     */
    private int leaveNum;

    /**
     * 请假内容
     */
    private String leaveContent;



}
