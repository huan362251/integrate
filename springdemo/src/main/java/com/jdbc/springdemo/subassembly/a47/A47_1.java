package com.jdbc.springdemo.subassembly.a47;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Optional;

@Configuration
public class A47_1 {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(A47_1.class);
        DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();
        //对字段描述
        DependencyDescriptor bean2 = new DependencyDescriptor(Bean1.class.getDeclaredField("bean2"), false);
        //通过工厂解析bean1里依的bean2对象
        System.out.println(beanFactory.doResolveDependency(bean2, "bean1", null, null));

        Method setBean2 = Bean1.class.getDeclaredMethod("setBean2", Bean2.class);
        DependencyDescriptor descriptor = new DependencyDescriptor(new MethodParameter(setBean2, 0), false);
        System.out.println(beanFactory.doResolveDependency(descriptor, "bean1", null, null));

        //3、Optional<Bean2>
        DependencyDescriptor dd3 = new DependencyDescriptor(Bean1.class.getDeclaredField("bean3"), false);
        if (dd3.getDependencyType() == Optional.class) {
            //进入嵌套
            dd3.increaseNestingLevel();
            System.out.println(beanFactory.doResolveDependency(dd3, "bean1", null, null));
        }
        //ObjectFactory<Bean2> bean4
        DependencyDescriptor dd4 = new DependencyDescriptor(Bean1.class.getDeclaredField("bean4"), false);
        if (dd4.getDependencyType() == ObjectFactory.class) {
            dd4.increaseNestingLevel();
            //需要懒加载，使用的时候再注入就行了
            ObjectFactory factory = new ObjectFactory() {
                @Override
                public Object getObject() throws BeansException {
                    return beanFactory.doResolveDependency(dd4,"bean1", null, null);
                }
            };
            System.out.println("factory:" + factory.getObject());
        }
        System.out.println("》》》》》》》》》》》》》》》》》》");
        DependencyDescriptor dd5 = new DependencyDescriptor(Bean1.class.getDeclaredField("bean2"), false);
        ContextAnnotationAutowireCandidateResolver resolver = new ContextAnnotationAutowireCandidateResolver();
        resolver.setBeanFactory(beanFactory);
        Object proxy = resolver.getLazyResolutionProxyIfNecessary(dd5, "bean1");
        System.out.println(proxy);
        System.out.println(proxy.getClass());
    }

    static class Bean1 {

        @Autowired @Lazy
        private Bean2 bean2;

        @Autowired
        public void setBean2(Bean2 bean2) {
            this.bean2 = bean2;
        }

        @Autowired
        private Optional<Bean2> bean3;

        @Autowired
        private ObjectFactory<Bean2> bean4;

    }

    @Component("bean2")
    public class Bean2 {

    }

}
