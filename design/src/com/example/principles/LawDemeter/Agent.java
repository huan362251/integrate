package com.example.principles.LawDemeter;

public class Agent {

    private Company company;

    private Fans fans;

    private Star star;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Fans getFans() {
        return fans;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public void meeting(){
        System.out.println("见面会，明星：" + star.getName() + "见了粉丝：" + fans.getName());
    }

    public void business(){
        System.out.println("商业行业，明星：" + star.getName() + "与" + company.getName() + "达成合作");
    }

}
