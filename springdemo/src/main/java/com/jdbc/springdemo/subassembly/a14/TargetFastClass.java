package com.jdbc.springdemo.subassembly.a14;

import org.springframework.cglib.core.Signature;

import java.lang.reflect.InvocationTargetException;

public class TargetFastClass {

    static Signature s0 = new Signature("save", "()V");
    static Signature s1 = new Signature("save", "(I)V");
    static Signature s2 = new Signature("save", "(J)V");

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
            ((Target) target).save();
        } else if (index == 1) {
            ((Target) target).save((int) args[0]);
        } else if (index == 2) {
            ((Target) target).save((long) args[0]);
        } else {
            throw new RuntimeException("无此方法");
        }
        return null;
    }

    public static void main(String[] args) {
        Target target = new Target();
        TargetFastClass targetFastClass = new TargetFastClass();
        int saveIndex = targetFastClass.getIndex(new Signature("save", "(J)V"));
        System.out.println(saveIndex);
        targetFastClass.invoke(saveIndex, target, new Object[]{1L});
    }

}
