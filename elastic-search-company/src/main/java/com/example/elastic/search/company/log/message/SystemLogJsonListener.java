package com.example.elastic.search.company.log.message;

import cn.hutool.core.bean.BeanUtil;
import com.example.elastic.search.company.entity.SystemLogSaveJsonReq;
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
public class SystemLogJsonListener {

    private final SystemLogService systemLogService;

//    @RabbitListener(queuesToDeclare = @Queue("pacypay.stl.system.log.json.receive"))
    public void process(@RequestBody String request) {
        try {
            log.info("SystemLogJsonListener request info:{}",request);
//            SystemLogSaveJsonReq systemLogReq = JsonTransformUtil.readValue(request, SystemLogSaveJsonReq.class);
            SystemLogSaveJsonReq systemLogReq = new SystemLogSaveJsonReq();
            SystemLogSaveReq systemLogSaveReq = new SystemLogSaveReq();
            String systemSourceValue = systemLogReq.getSystemSource();
            String sourceValue = systemLogReq.getSource();
            systemLogReq.setSystemSource(null);
            systemLogReq.setSource(null);
            BeanUtil.copyProperties(systemLogReq,systemLogSaveReq);
            systemLogSaveReq.setSystemSourceValue(systemSourceValue);
            systemLogSaveReq.setSourceValue(sourceValue);
            log.info("SystemLogJsonListener convert info:{}",systemLogSaveReq);
            systemLogService.saveLog(systemLogSaveReq);
        } catch (Exception ex) {
            log.error("接收日志请求失败，request：{}，exception：{}", request, ex);
        }
    }

}
