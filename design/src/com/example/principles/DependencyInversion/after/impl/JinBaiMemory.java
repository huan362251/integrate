package com.example.principles.DependencyInversion.after.impl;

import com.example.principles.DependencyInversion.after.Memory;

public class JinBaiMemory implements Memory {

    public void save(){
        System.out.println("JinBai 加载数据到内存");
    }

}
