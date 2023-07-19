package com.jdbc.springdemo.subassembly.a39;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

public class Step3 {

    public static void main(String[] args) throws IOException {
        StandardEnvironment environment = new StandardEnvironment();
        environment.getPropertySources().addLast(new ResourcePropertySource("step4",new ClassPathResource("step4.properties")));
//        User user = Binder.get(environment).bind("user", User.class).get();
//        System.out.println(user);
        User user = new User();
        Binder.get(environment).bind("user", Bindable.ofInstance(user));
        System.out.println(user);

    }


    static class User{
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

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
