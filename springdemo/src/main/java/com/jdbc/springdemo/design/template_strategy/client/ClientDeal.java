package com.jdbc.springdemo.design.template_strategy.client;

import com.jdbc.springdemo.design.template_strategy.entity.ParseEntity;
import com.jdbc.springdemo.design.template_strategy.impl.template.CheckOutParseFile;
import com.jdbc.springdemo.design.template_strategy.impl.template.SafeChangeParseFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("client")
public class ClientDeal {

    @Autowired
    private SafeChangeParseFile safeChangeParseFile;

    @Autowired
    private CheckOutParseFile checkOutParseFile;

    @PostMapping("deal/{type}")
    public void deal(@PathVariable("type") String type,@RequestBody ParseEntity parseEntity) {
        if ("safeChange".equals(type)) {
            safeChangeParseFile.parseData(parseEntity);
        } else if ("checkOut".equals(type)) {
            checkOutParseFile.parseData(parseEntity);
        } else {
            log.info("deal date type not found");
        }
    }

}
