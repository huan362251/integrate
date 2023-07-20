package com.example.principles.liskovSubstitution.before;

public class Square extends Rectangle{

    @Override
    public void setLength(Long length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(Long width) {
        this.setLength(width);
    }
}
