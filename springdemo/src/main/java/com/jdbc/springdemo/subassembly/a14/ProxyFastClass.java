package com.jdbc.springdemo.subassembly.a14;

import org.springframework.cglib.core.Signature;

public class ProxyFastClass {

    static Signature s0 = new Signature("saveSuper", "()V");
    static Signature s1 = new Signature("saveSuper", "(I)V");
    static Signature s2 = new Signature("saveSuper", "(J)V");

    public int getIndex(Signature signature) {
        if (signature.equals(s0)) {
            return 0;
        } else if (signature.equals(s1)) {
            return 1;
        } else if (signature.equals(s2)) {
            return 2;
        } else {
            return -1;
        }
    }

    public Object invoke(int index, Object target, Object[] args) {
        if (index == 0) {
            ((Proxy) target).saveSuper();
        } else if (index == 1) {
            ((Proxy) target).saveSuper((int) args[0]);
        } else if (index == 2) {
            ((Proxy) target).saveSuper((long) args[0]);
        } else {
            throw new RuntimeException("无此方法");
        }
        return null;
    }

    public static void main(String[] args) {
        ProxyFastClass targetFastClass = new ProxyFastClass();
        int saveIndex = targetFastClass.getIndex(new Signature("saveSuper", "(I)V"));
        System.out.println(saveIndex);
        targetFastClass.invoke(saveIndex, new Proxy(), new Object[]{1});
    }

}
