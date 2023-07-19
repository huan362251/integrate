package com.example.elastic.search8.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.elastic.search8.entity.SettlementDetail;

import java.io.IOException;

/**
 *
 */
public interface SettlementDetailService extends IService<SettlementDetail> {


    void insertDetail();

    void test() throws IOException;

    void queryTest() throws IOException;

    void aliasTest() throws IOException;

    void addSettle();
}
