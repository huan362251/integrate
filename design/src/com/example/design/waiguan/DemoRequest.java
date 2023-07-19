package com.example.design.waiguan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@RestController
@RequestMapping("/demo")
public class DemoRequest {

    @GetMapping("/test")
    public void test(ServletRequest request, ServletResponse response){
        System.out.println("request:"+request.getClass());
        System.out.println("response:"+response.getClass());
        Integer.valueOf(3);
    }
}
