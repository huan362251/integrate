package com.example.principles.openClosed.client;

import com.example.principles.openClosed.input.SkinInput;
import com.example.principles.openClosed.service.impl.JianKeSkin;
import com.example.principles.openClosed.service.impl.WuShiSkin;

public class OpenCloseSkin {

    public static void main(String[] args) {
        SkinInput skinInput = new SkinInput();
        //这一步随便变，
//        JianKeSkin skin = new JianKeSkin();
        WuShiSkin skin = new WuShiSkin();

        skinInput.setAbstractSkin(skin);
        skinInput.display();
    }

}
