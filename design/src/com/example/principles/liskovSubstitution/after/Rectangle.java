package com.example.principles.liskovSubstitution.after;

public class Rectangle implements Quadrilateral{

    private Long length;

    private Long width;

    @Override
    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    @Override
    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }
}
