package com.bawangbai.elastic.search.controller;

import com.bawangbai.elastic.search.service.SettlementDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("detail")
@Api(tags = "结算明细")
public class SettlementDetailController {

    @Autowired
    private SettlementDetailService settlementDetailService;

    @GetMapping("moveDataDetail")
    @ApiOperation(value = "转移结算明细数据")
    public void moveDataDetail(){
        settlementDetailService.moveData();
    }

    @GetMapping("count")
    public void testCount(){
        settlementDetailService.testCount();
    }

    @GetMapping("saveList")
    public void saveList(){
        settlementDetailService.saveDataName();
    }

    @GetMapping("queryName")
    public void query(){
        settlementDetailService.queryName();
    }

    @GetMapping("saveBatchData")
    public void saveBatchData(){
        settlementDetailService.saveBatchData();
    }
}
