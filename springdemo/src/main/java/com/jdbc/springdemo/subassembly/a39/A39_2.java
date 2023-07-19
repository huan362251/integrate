package com.jdbc.springdemo.subassembly.a39;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

public class A39_2 {

    public static void main(String[] args) {
        //添加监听器
        SpringApplication application = new SpringApplication(A39_2.class);
        application.addListeners(e->{
            System.out.println("事件："+e.getClass());
        });
        // 获取事件发送器实现类名
        List<String> list = SpringFactoriesLoader.loadFactoryNames(SpringApplicationRunListener.class, A39_2.class.getClassLoader());
        for (String s : list) {
            System.out.println(s);
        }

    }
}
