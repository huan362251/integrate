package com.example.principles.liskovSubstitution.after;

public class Square implements Quadrilateral {

    private Long side;

    @Override
    public Long getLength() {
        return side;
    }

    public void setLength(Long length) {
        this.side = length;
    }

    @Override
    public Long getWidth() {
        return side;
    }

    public void setWidth(Long width) {
        this.side = width;
    }

}
