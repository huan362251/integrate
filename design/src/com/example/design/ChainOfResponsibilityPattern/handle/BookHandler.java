package com.example.design.ChainOfResponsibilityPattern.handle;

/**
 * @Description
 * @Date 2022/10/31 16:31
 * @Author by liu.huan
 */
public abstract class BookHandler {

    private BookHandler successor;

    public void handleRequest() {
        if (successor != null) {
            successor.handleRequest();
        }
    }

    public void setSuccessor(BookHandler successor) {
        this.successor = successor;
    }

    public BookHandler getSuccessor() {
        return successor;
    }
}
