package com.example.elastic.search.company.log.message;

import com.example.elastic.search.company.entity.SystemLogSaveReq;
import com.example.elastic.search.company.log.service.SystemLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class SystemLogListener {

    private final SystemLogService systemLogService;

//    @RabbitListener(queuesToDeclare = @Queue("pacypay.stl.system.log.receive"))
    public void process(@RequestBody SystemLogSaveReq request) {
        try {
            systemLogService.saveLog(request);
        } catch (Exception ex) {
            log.error("接收日志请求失败，request：{}，exception：{}", request, ex);
        }
    }


}
