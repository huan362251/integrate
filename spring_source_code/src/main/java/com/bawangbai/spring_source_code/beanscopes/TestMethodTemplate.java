package com.bawangbai.spring_source_code.beanscopes;

import java.util.ArrayList;
import java.util.List;

public class TestMethodTemplate {

    public static void main(String[] args) {
        MyBeanFactory myBeanFactory = new MyBeanFactory();
        myBeanFactory.getBean();
        System.out.println("------未注入后置处理器--------");
        myBeanFactory.addBeanPostProcess(bean -> System.out.println("autowired 方式注入"));
        myBeanFactory.addBeanPostProcess(bean -> System.out.println("resources 方式注入"));
        myBeanFactory.getBean();
    }

    static class MyBeanFactory {

        public Object getBean() {
            Object object = new Object();
            System.out.println("构造：" + object);
            System.out.println("依赖注入：" + object);
            for (BeanPostProcess process : processes) {
                process.inject(object);
            }
            System.out.println("初始化：" + object);
            return object;
        }

        public List<BeanPostProcess> processes = new ArrayList<>();

        public void addBeanPostProcess(BeanPostProcess beanPostProcess){
            processes.add(beanPostProcess);
        }

    }

    static interface BeanPostProcess {
        public void inject(Object bean);
    }

}
