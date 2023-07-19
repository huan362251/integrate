package com.example.design.diedaiqi;

public interface StudentAggregate {

    public void addStudent(Student student);

    public void removeStudent(Student student);

    public StudentIterator iterator();
}
