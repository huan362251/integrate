package com.example.principles.DependencyInversion.after.impl;

import com.example.principles.DependencyInversion.after.Cpu;

public class InterCpu implements Cpu {

    public void run(){
        System.out.println("inter开始执行计算");
    }

}
