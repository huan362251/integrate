package com.example.design.mementoPattern.white_box;

public class GameRole {

    //攻击
    private int atk;

    //血量
    private int vit;

    //防御
    private int def;

    public GameRole() {
    }

    public GameRole(int atk, int vit, int def) {
        this.atk = atk;
        this.vit = vit;
        this.def = def;
    }

    //初始化状态
    public void initState() {
        this.atk = 100;
        this.def = 100;
        this.vit = 100;
    }

    //战斗状态
    public void fight() {
        this.atk = 0;
        this.def = 0;
        this.vit = 0;
    }

    public Memento saveState() {
        return new Memento(atk, vit, def);
    }

    public void recoverState(Memento roleStateMemento) {
        this.atk = roleStateMemento.getAtk();
        this.vit = roleStateMemento.getVit();
        this.def = roleStateMemento.getDef();
    }

    public void displayState(){
        System.out.println("角色生命力：" + this.vit);
        System.out.println("角色攻击力：" + this.atk);
        System.out.println("角色防御力：" + this.def);
    }



}
