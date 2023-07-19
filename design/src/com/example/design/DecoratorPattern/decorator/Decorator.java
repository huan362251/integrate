package com.example.design.DecoratorPattern.decorator;

import com.example.design.DecoratorPattern.comment.Component;

/**
 * @Description
 * @Date 2022/11/16 11:12
 * @Author by liu.huan
 */
public abstract class Decorator extends Component {

    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }

}
