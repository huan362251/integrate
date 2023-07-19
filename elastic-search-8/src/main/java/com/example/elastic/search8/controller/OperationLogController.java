package com.example.elastic.search8.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.elastic.search8.entity.OperationLogInfo;
import com.example.elastic.search8.entity.OperationLogQueryReq;
import com.example.elastic.search8.entity.OperationLogReq;
import com.example.elastic.search8.service.OperationLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("operation")
public class OperationLogController {

    @Autowired
    private OperationLogService operationLogService;

    /**
     * 新增操作日志
     *
     * @param operationLogReq
     * @return
     */
    @GetMapping("saveLog")
    public Long saveLog(OperationLogReq operationLogReq) {
        return operationLogService.saveLog(operationLogReq);
    }

    /**
     * 查询操作日志
     *
     * @param operationLogQueryReq
     * @return
     */
    @GetMapping("getOperationLog")
    public Page<OperationLogInfo> getOperationLog(OperationLogQueryReq operationLogQueryReq) {
        return operationLogService.getOperationLog(operationLogQueryReq);
    }
}
