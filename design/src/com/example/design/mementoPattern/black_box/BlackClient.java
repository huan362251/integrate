package com.example.design.mementoPattern.black_box;

public class BlackClient {

    public static void main(String[] args) {
        System.out.println("创建角色");
        BlackGameRole gameRole = new BlackGameRole();
        gameRole.initState();
        gameRole.displayState();
        System.out.println("存档");
        BlackMementoCreataker mementoCreataker = new BlackMementoCreataker();
        mementoCreataker.setRoleStateMemento(gameRole.saveState());
        System.out.println("打boss");
        gameRole.fight();
        gameRole.displayState();
        System.out.println("打的不好，回档");
        gameRole.recoverState(mementoCreataker.getRoleStateMemento());
        gameRole.displayState();
    }

}
