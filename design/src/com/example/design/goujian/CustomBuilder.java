package com.example.design.goujian;

public class CustomBuilder {

    private String name;

    private int age;

    public CustomBuilder(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public static class Builder{

        private String name;

        private int age;

        public Builder() {
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public CustomBuilder build(){
            return new CustomBuilder(this);
        }

    }

    @Override
    public String toString() {
        return "CustomBuilder{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
