package com.example.algorithm.test;

import org.junit.Test;

import java.util.Arrays;

public class TestShellsSortOne {

    @Test
    public void ShellsSort() {
        //第一遍没看懂,重写
        int[] a = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        int h = 1;
        while (h < a.length / 2) {//增量规则
            h = 2 * h + 1;
        }
        int count = 0;

        while (h >= 1) {
            //排序
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (a[j - h] > a[j]) {
                        int temp = a[j];
                        a[j] = a[j - h];
                        a[j - h] = temp;
                    }else {
                        break;
                    }
                    count++;
                }
            }
            h = h / 2;
            System.out.println("中间遍历:" + count + ":" + Arrays.toString(a));
        }
        System.out.println(Arrays.toString(a));

    }

    @Test
    public void test(){
        int a[] = new int[100000];
        int b[] = new int[100000];
        for (int i = 100000; i > 0 ; i--) {
            a[i-1] = 100000-i;
            b[i-1] = 100000-i;
        }
        long start = System.currentTimeMillis();
        sortInsert(a);
        long end = System.currentTimeMillis();
        System.out.println(end-start + "毫秒");
        long start1 = System.currentTimeMillis();
        sortShells(b);
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1 + "毫秒");
    }

    public void sortShells(int[] a){
        //第一遍没看懂,重写
        int h = 1;
        while (h < a.length / 2) {//增量规则
            h = 2 * h + 1;
        }
        int count = 0;

        while (h >= 1) {
            //排序
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (a[j - h] > a[j]) {
                        int temp = a[j];
                        a[j] = a[j - h];
                        a[j - h] = temp;
                    }else {
                        break;
                    }
                    count++;
                }
            }
            h = h / 2;
        }
    }

    public void sortInsert(int[] a){
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }else {
                    break;
                }
            }
        }
    }
}
