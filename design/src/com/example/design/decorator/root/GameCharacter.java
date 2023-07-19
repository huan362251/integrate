package com.example.design.decorator.root;

/**
 * 根人物-白板人物
 */
public abstract class GameCharacter {

    public String desc = "白板游戏人物";

    public String getDesc() {
        return desc;
    }

    /**
     * 人物伤害
     **/
    public abstract int harm();

}
