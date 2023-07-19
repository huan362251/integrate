package com.example.design.guancha;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject {

    private List<Observer> list;

    public SubscriptionSubject() {
        this.list = new ArrayList<Observer>();
    }

    @Override
    public void attach(Observer observer) {
        list.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifytach(String msg) {
        for (Observer observer : list) {
            observer.update(msg);
        }
    }

}
