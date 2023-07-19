package com.example.design.StatePattern.client;

import com.example.design.StatePattern.context.Context;

/**
 * @Description
 * @Date 2022/11/3 19:01
 * @Author by liu.huan
 */
public class FileClient {

    public static void main(String[] args) {
        String fileName = "t_spt_账户凭证规则表.sql";
        Context context = new Context();
        context.createFile(fileName);
        context.parseFile(fileName);
        context.deleteFile(fileName);
        context.parseFile(fileName);
    }

}
