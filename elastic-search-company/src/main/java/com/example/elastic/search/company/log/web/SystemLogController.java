package com.example.elastic.search.company.log.web;


import com.example.elastic.search.company.entity.SystemLogReq;
import com.example.elastic.search.company.entity.SystemLogSaveReq;
import com.example.elastic.search.company.log.service.SystemLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("system/log")
public class SystemLogController {

    private final SystemLogService systemLogService;

    @GetMapping("queryLog")
    public void queryLog(SystemLogReq systemLogReq){
        log.info("SystemLogController queryLog method param:{}",systemLogReq);
        systemLogService.queryLog(systemLogReq);
        log.info("SystemLogController queryLog method param:{}");
    }

    @PostMapping("saveLog")
    public void saveLog(@RequestBody SystemLogSaveReq systemLogSaveReq)  {
        systemLogService.saveLog(systemLogSaveReq);
    }

}
