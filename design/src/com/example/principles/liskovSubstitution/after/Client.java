package com.example.principles.liskovSubstitution.after;

public class Client {

    public static void main(String[] args) {
        RectangleDemo rectangleDemo = new RectangleDemo();
        //将它与Square分离开来，不允许继承，这样，它在扩充时不会有问题
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(20L);
        rectangle.setLength(10L);
        rectangleDemo.resize(rectangle);
        rectangleDemo.printLengthAndWidth(rectangle);
        //因为与rectangle没有继承关系，所以它不能使用提供给rectangle的类使用，不会导致问题
        Square square = new Square();
        square.setLength(20L);
        square.setWidth(10L);
//        rectangleDemo.resize(square);
        rectangleDemo.printLengthAndWidth(square);
        //里氏代换原则，即拒绝对继承父类的方法修改，支持扩展
    }

}
