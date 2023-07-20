package com.example.principles.liskovSubstitution.after;

public class RectangleDemo {

    public void resize(Rectangle rectangle) {
        while (rectangle.getLength() <= rectangle.getWidth()) {
            rectangle.setLength(rectangle.getLength() + 1);
        }
    }

    public void printLengthAndWidth(Quadrilateral rectangle) {
        System.out.println("length:" + rectangle.getLength() + ",width:" + rectangle.getWidth());
    }

}
