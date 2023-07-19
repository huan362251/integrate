package com.example.design.mementoPattern.white_box;

public class Memento {

    //攻击
    private int atk;

    //血量
    private int vit;

    //防御
    private int def;

    public Memento() {
    }

    public Memento(int atk, int vit, int def) {
        this.atk = atk;
        this.vit = vit;
        this.def = def;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
