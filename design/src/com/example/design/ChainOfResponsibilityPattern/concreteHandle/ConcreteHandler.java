package com.example.design.ChainOfResponsibilityPattern.concreteHandle;


import com.example.design.ChainOfResponsibilityPattern.handle.BookHandler;

/**
 * @Description
 * @Date 2022/10/31 16:36
 * @Author by liu.huan
 */
public class ConcreteHandler extends BookHandler {

    @Override
    public void handleRequest() {
        if(getSuccessor() != null){
            getSuccessor().handleRequest();
        }
//        if(this.succ)

    }
}
