package com.example.principles.liskovSubstitution.before;

public class Client {

    public static void main(String[] args) {
        RectangleDemo rectangleDemo = new RectangleDemo();
        /*
            基类正常能跑出来
         */
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(10L);
        rectangle.setWidth(20L);
        rectangleDemo.resize(rectangle);
        rectangleDemo.printLengthAndWidth(rectangle);
        /*
            子类不正常，死循环
            因为子类继承后修改了父类的实现，导致逻辑出现漏洞，从而形成死循环
            所以不建议子类修改父类的实现
         */
        Square square = new Square();
        square.setLength(10L);
        square.setWidth(20L);
        rectangleDemo.resize(square);
        rectangleDemo.printLengthAndWidth(square);
    }

}
