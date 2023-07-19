package com.bawangbai.elastic.search.service;

import com.bawangbai.elastic.search.pojo.entity.SettlementDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface SettlementDetailService extends IService<SettlementDetail> {

    void moveData();


    void saveDataName();

    void queryName();

    void testCount();

    void saveBatchData();
}
