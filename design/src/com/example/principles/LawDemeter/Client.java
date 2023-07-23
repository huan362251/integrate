package com.example.principles.LawDemeter;

public class Client {

    public static void main(String[] args) {
        Agent agent = new Agent();
        agent.setFans(new Fans("臭屁股"));
        agent.setStar(new Star("白胖胖"));
        agent.setCompany(new Company("小崽媒体"));
        agent.business();
        agent.meeting();
    }

}
