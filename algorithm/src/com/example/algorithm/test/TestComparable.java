package com.example.algorithm.test;

import com.example.algorithm.sort.Student;
import org.junit.Test;

public class TestComparable {

    @Test
    public void testCompare(){
        Student student = new Student();
        student.setAge(18);
        student.setUserName("张三");

        Student student1 = new Student();
        student1.setAge(20);
        student1.setUserName("李四");
        Comparable max = getMax(student, student1);
        System.out.println(max);

    }

    //使用父类的返回，可以变更为通用型的方法
    private Comparable getMax(Comparable c1,Comparable c2){
        int i = c1.compareTo(c2);
        if(i>=0){
            return c1;
        }else {
            return c2;
        }
    }

}
