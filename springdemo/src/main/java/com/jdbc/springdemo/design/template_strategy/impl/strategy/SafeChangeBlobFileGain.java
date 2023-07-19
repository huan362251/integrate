package com.jdbc.springdemo.design.template_strategy.impl.strategy;

import com.jdbc.springdemo.design.template_strategy.abstra.FileGain;
import com.jdbc.springdemo.design.template_strategy.util.BlobUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SafeChangeBlobFileGain implements FileGain {

    @Autowired
    private BlobUtil blobUtil;

    @Override
    public void fileGainStrategy() {
        log.info("safe change blob get file");
        blobUtil.getBlob();
    }

}
