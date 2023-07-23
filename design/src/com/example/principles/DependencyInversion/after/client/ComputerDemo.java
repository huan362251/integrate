package com.example.principles.DependencyInversion.after.client;

import com.example.principles.DependencyInversion.after.impl.AmdCpu;
import com.example.principles.DependencyInversion.after.impl.JinBaiMemory;
import com.example.principles.DependencyInversion.after.impl.KingstonMemory;
import com.example.principles.DependencyInversion.after.impl.ZhiTaiHardDisk;

public class ComputerDemo {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setCpu(new AmdCpu());
        computer.setDisk(new ZhiTaiHardDisk());
        computer.setMemory(new JinBaiMemory());
        computer.run();
    }

}
