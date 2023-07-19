package com.example.design.AdapterPattern.client;


import com.example.design.AdapterPattern.adaptee.impl.Adaptee;
import com.example.design.AdapterPattern.target.Target;
import com.example.design.AdapterPattern.target.impl.ClassAdaptor;
import com.example.design.AdapterPattern.target.impl.ObjectAdaptor;

/**
 * @Description
 * @Date 2022/11/15 14:19
 * @Author by liu.huan
 */
public class Client {

    public static void main(String[] args) {
        Target objectAdaptor = new ObjectAdaptor(new Adaptee());
        objectAdaptor.showPersonalInfo("James", "Gosling", 66);
        System.out.println("=================");
        Target classAdaptor = new ClassAdaptor();
        classAdaptor.showLastNameAndAge("Gosling", 66);
    }

}
