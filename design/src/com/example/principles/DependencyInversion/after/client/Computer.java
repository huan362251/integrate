package com.example.principles.DependencyInversion.after.client;

import com.example.principles.DependencyInversion.after.Cpu;
import com.example.principles.DependencyInversion.after.Disk;
import com.example.principles.DependencyInversion.after.Memory;
import com.example.principles.DependencyInversion.before.InterCpu;
import com.example.principles.DependencyInversion.before.KingstonMemory;
import com.example.principles.DependencyInversion.before.XiJieHardDisk;

public class Computer {

    private Cpu cpu ;

    private Memory memory ;

    private Disk disk ;

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public void run(){
        cpu.run();
        disk.get();
        memory.save();
        disk.save("abc");
    }

}
