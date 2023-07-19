package com.example.elastic.search.company.log.service;


import com.example.elastic.search.company.entity.SystemLog;
import com.example.elastic.search.company.entity.SystemLogReq;
import com.example.elastic.search.company.entity.SystemLogSaveReq;
import org.springframework.data.domain.Page;

public interface SystemLogService {

    /**
     * 接收日志
     * @param systemLogSaveReq
     */
    void saveLog(SystemLogSaveReq systemLogSaveReq);

    /**
     * 查询日志
     * @param systemLogReq
     * @return
     */
    void queryLog(SystemLogReq systemLogReq);

}
