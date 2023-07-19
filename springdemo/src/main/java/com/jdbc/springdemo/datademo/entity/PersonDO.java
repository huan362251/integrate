package com.jdbc.springdemo.datademo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("person")
public class PersonDO implements Serializable {

    @TableId
    private long id;

    private String name;

    private int age;

    private LocalDate curDate;

    private LocalDateTime curTime;

}
