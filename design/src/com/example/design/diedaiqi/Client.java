package com.example.design.diedaiqi;

public class Client {

    public static void main(String[] args) {
        Student student = new Student("张三","003");
        Student student1 = new Student("李四","004");
        Student student2 = new Student("王五","005");
        Student student3 = new Student("赵六","006");
        Student student4 = new Student("陈七","007");
        StudentAggregate aggregate = new StudentAggregateImpl();
        aggregate.addStudent(student);
        aggregate.addStudent(student1);
        aggregate.addStudent(student2);
        aggregate.addStudent(student3);
        aggregate.addStudent(student4);
        StudentIterator iterator = aggregate.iterator();
        while (iterator.hasNext()){
            Student next = iterator.next();
            System.out.println("姓名："+next.getName()+",学号："+next.getNumber());
        }

    }

}
