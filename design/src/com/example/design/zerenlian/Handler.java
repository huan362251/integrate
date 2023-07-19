package com.example.design.zerenlian;

public abstract class Handler {

    protected static final int NUM_ONE = 1;

    protected static final int NUM_THREE = 3;

    protected static final int NUM_SEVEN = 7;

    private int numStart;

    private int numEnd;

    private Handler nextHandler;

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    public abstract void handlerLevel(LeaveRequest request);

    public void submit(LeaveRequest request) {
        this.handlerLevel(request);
        if (this.nextHandler != null && request.getNum() > this.numEnd) {
            this.nextHandler.submit(request);
        } else {
            System.out.println("流程结束 ");
        }
    }

}
