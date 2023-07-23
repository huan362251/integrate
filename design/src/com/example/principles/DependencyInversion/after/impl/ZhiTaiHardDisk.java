package com.example.principles.DependencyInversion.after.impl;

import com.example.principles.DependencyInversion.after.Disk;

public class ZhiTaiHardDisk implements Disk {

    public void save(String data) {
        System.out.println("致态保存数据：" + data);
    }

    public void get(){
        System.out.println("致态获取数据");
    }

}
