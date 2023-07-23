package com.example.principles.DependencyInversion.after.impl;

import com.example.principles.DependencyInversion.after.Disk;

public class XiJieHardDisk implements Disk {

    public void save(String data) {
        System.out.println("保存数据：" + data);
    }

    public void get(){
        System.out.println("获取数据");
    }

}
