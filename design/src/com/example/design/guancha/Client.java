package com.example.design.guancha;

public class Client {

    public static void main(String[] args) {
        Observer user = new WeiXinUser("张三");
        Observer user1 = new WeiXinUser("李四");
        Observer user2 = new WeiXinUser("王五");
        Observer user3 = new WeiXinUser("赵六");

        Subject subject = new SubscriptionSubject();
        subject.attach(user);
        subject.attach(user1);
        subject.attach(user2);
        subject.attach(user3);

        subject.notifytach("发送消息");
    }

}
