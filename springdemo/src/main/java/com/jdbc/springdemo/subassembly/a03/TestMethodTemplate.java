package com.jdbc.springdemo.subassembly.a03;

import java.util.ArrayList;
import java.util.List;

public class TestMethodTemplate {

    public static void main(String[] args) {
        MyBeanFactory beanFactory = new MyBeanFactory();
        beanFactory.addBeanPostProcessor(bean -> System.out.println("注入@Autowired"));
        beanFactory.addBeanPostProcessor(bean -> System.out.println("注入@Resources"));
        beanFactory.getBean();
    }

    static class MyBeanFactory {
        public Object getBean() {
            Object bean = new Object();
            System.out.println("构造：" + bean);
//            System.out.println("依赖注入：" + bean);
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                beanPostProcessor.inject(bean);
            }
            System.out.println("初始化：" + bean);
            return bean;
        }

        private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

        public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
            beanPostProcessors.add(beanPostProcessor);
        }

    }

    static interface BeanPostProcessor {
        public void inject(Object object);
    }
}
