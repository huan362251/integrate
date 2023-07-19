package com.jdbc.springdemo.web;

import com.jdbc.springdemo.datademo.entity.PersonDO;
import com.jdbc.springdemo.entity.CheckItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequestMapping("/test")
public class DemoWeb {


    @GetMapping("/checkItem")
    public Object checkItem(CheckItem checkItem){
        log.info("check item info:{}",checkItem);
        ModelAndView check = new ModelAndView("a");
        check.addObject("check",checkItem.getName());
        return check;
    }

    @PostMapping("/test")
    public void demo(@RequestBody PersonDO personDO, @RequestParam String abc){
        System.out.println(abc);
    }


}
