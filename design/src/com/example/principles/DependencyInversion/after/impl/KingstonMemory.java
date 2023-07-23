package com.example.principles.DependencyInversion.after.impl;

import com.example.principles.DependencyInversion.after.Memory;

public class KingstonMemory implements Memory {

    public void save(){
        System.out.println("金士顿加载数据到内存");
    }

}
