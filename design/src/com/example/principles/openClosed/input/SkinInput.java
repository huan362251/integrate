package com.example.principles.openClosed.input;

import com.example.principles.openClosed.service.AbstractSkin;

public class SkinInput {

    private AbstractSkin abstractSkin;

    public void setAbstractSkin(AbstractSkin abstractSkin) {
        this.abstractSkin = abstractSkin;
    }

    public void display(){
        abstractSkin.display();
    }

}
