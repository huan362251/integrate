package com.example.principles.DependencyInversion.before;

public class Computer {

    private InterCpu interCpu ;

    private KingstonMemory kingstonMemory ;

    private XiJieHardDisk xiJieHardDisk ;

    public InterCpu getInterCpu() {
        return interCpu;
    }

    public void setInterCpu(InterCpu interCpu) {
        this.interCpu = interCpu;
    }

    public KingstonMemory getKingstonMemory() {
        return kingstonMemory;
    }

    public void setKingstonMemory(KingstonMemory kingstonMemory) {
        this.kingstonMemory = kingstonMemory;
    }

    public XiJieHardDisk getXiJieHardDisk() {
        return xiJieHardDisk;
    }

    public void setXiJieHardDisk(XiJieHardDisk xiJieHardDisk) {
        this.xiJieHardDisk = xiJieHardDisk;
    }

    public void run(){
        interCpu.run();
        xiJieHardDisk.get();
        kingstonMemory.save();
        xiJieHardDisk.save("abc");
    }

}
