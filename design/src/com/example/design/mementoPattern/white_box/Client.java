package com.example.design.mementoPattern.white_box;

public class Client {

    public static void main(String[] args) {
        System.out.println("创建角色");
        GameRole gameRole = new GameRole();
        gameRole.initState();
        gameRole.displayState();
        System.out.println("存档");
        MementoCreataker mementoCreataker = new MementoCreataker();
        mementoCreataker.setRoleStateMemento(gameRole.saveState());
        System.out.println("打boss");
        gameRole.fight();
        gameRole.displayState();
        System.out.println("打的不好，回档");
        gameRole.recoverState(mementoCreataker.getRoleStateMemento());
        gameRole.displayState();
    }

}
