package com.jdbc.springdemo.subassembly.a47;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
public class A47_2 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(A47_2.class);
        DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> 1. 数组类型");
        testArray(beanFactory);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> 2. List类型");
        testList(beanFactory);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> 3. 特殊类型");
        testApplicationContext(beanFactory);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> 4. 常规类型");
        testGeneric(beanFactory);
    }

    private static void testArray(DefaultListableBeanFactory beanFactory) throws NoSuchFieldException {
        DependencyDescriptor serviceArray = new DependencyDescriptor(Target.class.getDeclaredField("serviceArray"),false);
        if (serviceArray.getDependencyType().isArray()) {
            Class<?> componentType = serviceArray.getDependencyType().getComponentType();
            System.out.println(componentType);
            String[] names = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(beanFactory, componentType);
            List beans = new ArrayList<>();
            for (String name : names) {
                System.out.println(name);
                Object bean = serviceArray.resolveCandidate(name, componentType, beanFactory);
                beans.add(bean);
            }
            Object array = beanFactory.getTypeConverter().convertIfNecessary(beans, serviceArray.getDependencyType());
            System.out.println(array);

        }
    }

    private static void testList(DefaultListableBeanFactory beanFactory) throws NoSuchFieldException {
        DependencyDescriptor serviceList = new DependencyDescriptor(Target.class.getDeclaredField("serviceList"),false);
        if (serviceList.getDependencyType() == List.class) {
            Class<?> resolve = serviceList.getResolvableType().getGeneric().resolve();
            System.out.println(resolve);
            String[] names = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(beanFactory, resolve);
            List<Object> list = new ArrayList<>();
            for (String name : names) {
                Object bean = serviceList.resolveCandidate(name, resolve, beanFactory);
                list.add(bean);
                System.out.println(bean);
            }
            System.out.println(list);
        }
    }

    private static void testApplicationContext(DefaultListableBeanFactory beanFactory) throws NoSuchFieldException, IllegalAccessException {
        DependencyDescriptor descriptor = new DependencyDescriptor(Target.class.getDeclaredField("applicationContext"), true);
        Field field = DefaultListableBeanFactory.class.getDeclaredField("resolvableDependencies");
        field.setAccessible(true);
        //获取所有beanFactory的depend
        Map<Class<?>, Object> dependencies = (Map<Class<?>, Object>) field.get(beanFactory);

        for (Map.Entry<Class<?>, Object> entry : dependencies.entrySet()) {
            if (entry.getKey().isAssignableFrom(descriptor.getDependencyType())) {
                System.out.println(entry.getValue());
                break;
            }
        }

    }

    private static void testGeneric(DefaultListableBeanFactory beanFactory) throws NoSuchFieldException {
        DependencyDescriptor descriptor = new DependencyDescriptor(Target.class.getDeclaredField("dao"), true);
        Class<?> dependencyType = descriptor.getDependencyType();
        ContextAnnotationAutowireCandidateResolver resolver = new ContextAnnotationAutowireCandidateResolver();
        resolver.setBeanFactory(beanFactory);
        for (String name : BeanFactoryUtils.beanNamesForTypeIncludingAncestors(beanFactory, dependencyType)) {
            BeanDefinition bd = beanFactory.getMergedBeanDefinition(name);
            if (resolver.isAutowireCandidate(new BeanDefinitionHolder(bd,name),descriptor)) {
                System.out.println(name);
                System.out.println(descriptor.resolveCandidate(name,dependencyType,beanFactory));
            }
        }
    }

    static class Target {
        @Autowired
        private Service[] serviceArray;
        @Autowired
        private List<Service> serviceList;
        @Autowired
        private ConfigurableApplicationContext applicationContext;
        @Autowired
        private Dao<Teacher> dao;
        @Autowired
        @Qualifier("service2")
        private Service service;
    }

    interface Dao<T> {

    }

    @Component("dao1")
    static class Dao1 implements Dao<Student> {
    }

    @Component("dao2")
    static class Dao2 implements Dao<Teacher> {
    }

    static class Student {

    }

    static class Teacher {

    }

    interface Service {

    }

    @Component("service1")
    static class Service1 implements Service {

    }

    @Component("service2")
    static class Service2 implements Service {

    }

    @Component("service3")
    static class Service3 implements Service {

    }

}
