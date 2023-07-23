package com.example.principles.DependencyInversion.before;

public class ComputeDemo {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setInterCpu(new InterCpu());
        computer.setKingstonMemory(new KingstonMemory());
        computer.setXiJieHardDisk(new XiJieHardDisk());
        computer.run();
    }

}
