package com.example.design.diedaiqi;

import java.util.List;

public class StudentIteratorImpl implements StudentIterator {

    private List<Student> list;

    private int position;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        Student student = list.get(position);
        position++;
        return student;
    }

}
