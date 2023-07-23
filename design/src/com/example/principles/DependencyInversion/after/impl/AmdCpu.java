package com.example.principles.DependencyInversion.after.impl;

import com.example.principles.DependencyInversion.after.Cpu;

public class AmdCpu implements Cpu {

    public void run(){
        System.out.println("amd开始执行计算");
    }

}
