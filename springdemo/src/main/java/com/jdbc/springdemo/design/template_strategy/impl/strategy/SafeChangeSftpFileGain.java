package com.jdbc.springdemo.design.template_strategy.impl.strategy;

import com.jdbc.springdemo.design.template_strategy.abstra.FileGain;
import com.jdbc.springdemo.design.template_strategy.util.SftpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SafeChangeSftpFileGain implements FileGain {

    @Autowired
    private SftpUtil sftpUtil;

    @Override
    public void fileGainStrategy() {
        sftpUtil.getFileByIdentity();
        log.info("safe change sftp get file");
    }

}
