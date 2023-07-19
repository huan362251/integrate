package com.jdbc.springdemo.subassembly.a14;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Proxy extends Target{

    static Method save;
    static Method save1;
    static Method save2;
    static MethodProxy saveProxy;
    static MethodProxy saveProxy1;
    static MethodProxy saveProxy2;
    static {
        try {
            save = Target.class.getMethod("save");
            save1 = Target.class.getMethod("save", int.class);
            save2 = Target.class.getMethod("save", long.class);
            saveProxy = MethodProxy.create(Target.class,Proxy.class,"()V","save","saveSuper");
            saveProxy1 = MethodProxy.create(Target.class,Proxy.class,"(I)V","save","saveSuper");
            saveProxy2 = MethodProxy.create(Target.class,Proxy.class,"(J)V","save","saveSuper");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private MethodInterceptor methodInterceptor;

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public void saveSuper(){
        super.save();
    }

    public void saveSuper(int i){
        super.save(i);
    }

    public void saveSuper(long j){
        super.save(j);
    }

    @Override
    public void save() {
        try {
            methodInterceptor.intercept(this,save,new Object[0],saveProxy);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void save(int i) {
        try {
            methodInterceptor.intercept(this,save1,new Object[]{i},saveProxy1);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void save(long j) {
        try {
            methodInterceptor.intercept(this,save2,new Object[]{j},saveProxy2);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
