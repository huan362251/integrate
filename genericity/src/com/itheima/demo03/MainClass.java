package com.itheima.demo03;

public class MainClass {

    public static void main(String[] args) {
        String[] strings = {"苹果手机","小米手机","华为手机","扫地机器人"};
        ProductGetter<String> productGetter = new ProductGetter<>();
        for (String string : strings) {
            productGetter.addProduct(string);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(productGetter.getProduct());
        }
        System.out.println("----------------");
        Integer[] integers = {3000,5000,7000,10000};
        ProductGetter<Object> objectProductGetter = new ProductGetter<>();
        for (Integer integer : integers) {
            objectProductGetter.addProduct(integer);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(objectProductGetter.getProduct());
        }

    }

}
