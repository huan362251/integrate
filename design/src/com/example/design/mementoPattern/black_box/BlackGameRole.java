package com.example.design.mementoPattern.black_box;

import com.example.design.mementoPattern.white_box.Memento;

public class BlackGameRole {

    //攻击
    private int atk;

    //血量
    private int vit;

    //防御
    private int def;

    public BlackGameRole() {
    }

    public BlackGameRole(int atk, int vit, int def) {
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

    public BlackMemento saveState() {
        return new BlackMementoGameRole(atk, vit, def);
    }

    public void recoverState(BlackMemento roleStateMemento) {
        BlackMementoGameRole stateMemento = (BlackMementoGameRole) roleStateMemento;
        this.atk = stateMemento.getAtk();
        this.vit = stateMemento.getVit();
        this.def = stateMemento.getDef();
    }

    public void displayState(){
        System.out.println("角色生命力：" + this.vit);
        System.out.println("角色攻击力：" + this.atk);
        System.out.println("角色防御力：" + this.def);
    }

    public class BlackMementoGameRole implements BlackMemento {
        //攻击
        private int atk;

        //血量
        private int vit;

        //防御
        private int def;

        public BlackMementoGameRole() {
        }

        public BlackMementoGameRole(int atk, int vit, int def) {
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

}
