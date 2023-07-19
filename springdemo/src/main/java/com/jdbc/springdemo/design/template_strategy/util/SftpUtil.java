package com.jdbc.springdemo.design.template_strategy.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SftpUtil {

    public void getFileByPassword(){
        log.info("get file sftp by password");
    }

    public void getFileByIdentity(){
        log.info("get file sftp by identity");
    }

}
