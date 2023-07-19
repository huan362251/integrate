package com.example.design.diedaiqi;

import java.util.ArrayList;
import java.util.List;

public class StudentAggregateImpl implements StudentAggregate{

    private List<Student> list = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        list.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        list.remove(student);
    }

    @Override
    public StudentIterator iterator() {
        return new StudentIteratorImpl(list);
    }

}
