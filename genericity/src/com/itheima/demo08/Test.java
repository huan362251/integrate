package com.itheima.demo08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<MiniCat> miniCats = new ArrayList<>();

        /**
         * 只能传入子类、或同级参数
         */
//        demo(animals);

//        demo(cats);
//        demo(miniCats);

        TreeSet<Cat> catTreeSet = new TreeSet<>(new c2());
        catTreeSet.add(new Cat("jim",22));
        catTreeSet.add(new Cat("cat",24));
        catTreeSet.add(new Cat("sir",27));
        catTreeSet.add(new Cat("kqe",32));
        for (Cat cat : catTreeSet) {
            System.out.println(cat);
        }

    }

    public static void demo(ArrayList<? extends Cat> list) {
        //不允许再传入参数，因为不知道上级传入的是什么类型
//        list.add(new MiniCat())
        for (Cat cat : list) {
            System.out.println(cat);
        }
    }

}

class c1 implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class c2 implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.getAge() - o2.getAge();
    }
}

class c3 implements Comparator<MiniCat> {
    @Override
    public int compare(MiniCat o1, MiniCat o2) {
        return o1.getLevel() - o2.getLevel();
    }
}
