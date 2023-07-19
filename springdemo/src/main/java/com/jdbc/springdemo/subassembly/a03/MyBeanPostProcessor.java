package com.jdbc.springdemo.subassembly.a03;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if(beanName.equalsIgnoreCase("LifeCycleBean")){
            log.info("销毁前执行，@PreDestroy前");
        }
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(beanName.equalsIgnoreCase("LifeCycleBean")){
            log.info("实例化前执行，此处返回的对象会替换掉bean");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(beanName.equalsIgnoreCase("LifeCycleBean")){
            log.info("实例化后执行，此处返回的false,会跳过依赖注入阶段");
        }
        //正常来说不会跳过
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if(beanName.equalsIgnoreCase("LifeCycleBean")){
            log.info("依赖注入阶段执行，例如@Autowired/@Value等");
        }
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equalsIgnoreCase("LifeCycleBean")){
            log.info("初始化之前执行，这里返回的对象会替换掉原始的bean,如@PostConstruct");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equalsIgnoreCase("LifeCycleBean")){
            log.info("初始化之后执行，这里返回的对象会替换掉原始的bean,如代理增强");
        }
        return null;
    }
}
