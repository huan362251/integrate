package com.example.principles.DependencyInversion.before;

public class XiJieHardDisk {

    public void save(String data) {
        System.out.println("保存数据：" + data);
    }

    public void get(){
        System.out.println("获取数据");
    }

}
