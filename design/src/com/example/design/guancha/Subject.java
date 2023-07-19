package com.example.design.guancha;

public interface Subject {

    public void attach(Observer observer);

    public void detach(Observer observer);

    public void notifytach(String msg);

}
