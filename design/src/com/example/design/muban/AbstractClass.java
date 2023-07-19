package com.example.design.muban;

public abstract class AbstractClass {

    public final void process(){
        pouroil();
        heatoil();
        pourVegetable();
        pourSauce();
        fry();
    }

    public void pouroil() {
        System.out.println("加油");
    }

    public void heatoil() {
        System.out.println("热油");
    }

    //放菜
    public abstract void pourVegetable();

    //放调料
    public abstract void pourSauce();

    public void fry() {
        System.out.println("翻炒");
    }

}
