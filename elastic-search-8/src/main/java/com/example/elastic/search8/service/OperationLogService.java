package com.example.elastic.search8.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.elastic.search8.entity.OperationLogInfo;
import com.example.elastic.search8.entity.OperationLogQueryReq;
import com.example.elastic.search8.entity.OperationLogReq;

public interface OperationLogService {

    /**
     * 新增操作日志
     * @param operationLogReq
     * @return
     */
    Long saveLog(OperationLogReq operationLogReq);

    /**
     * 查询操作日志
     * @param operationLogQueryReq
     * @return
     */
    Page<OperationLogInfo> getOperationLog(OperationLogQueryReq operationLogQueryReq);
}
