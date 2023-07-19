package com.jdbc.springdemo.subassembly.a20;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class Controller1 {

    @GetMapping("test")
    public ModelAndView test(){
        log.info("test");
        return null;
    }

    @GetMapping("test1")
    public ModelAndView test1(@RequestParam("name") String name){
        log.info("test1:{}",name);
        return null;
    }


    @GetMapping("test2")
    public ModelAndView test2(){
        log.info("test2");
        return null;
    }

    @GetMapping("test3")
    public ModelAndView test3(@Token String token){
        log.info("token:{}",token);
        return null;
    }

    @GetMapping("test4")
    @Yml
    public User test4(){
        log.info("test4");
        return new User("张三",20);
    }

    public class User {
        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private String name;

        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
