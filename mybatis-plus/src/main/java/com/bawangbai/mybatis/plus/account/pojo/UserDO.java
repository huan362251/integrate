package com.bawangbai.mybatis.plus.account.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("user")
public class UserDO {

    private Long id;

    @TableField
    private String name;

    private Integer age;

    private String email;

}
