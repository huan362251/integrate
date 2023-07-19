package com.example.design.DecoratorPattern.comment.impl;

import com.example.design.DecoratorPattern.comment.Component;

/**
 * @Description
 * @Date 2022/11/16 11:11
 * @Author by liu.huan
 */
public class ConcreteComponent extends Component {

    @Override
    public void operation() {
        System.out.println("ConcreteComponent say");
    }

}
