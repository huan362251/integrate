package com.example.algorithm.test;

import org.junit.Test;

import java.util.Arrays;

public class TestShellsSort {

    //希尔排序
    @Test
    public void shellSort() {
        int[] a = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        int h = 1;
        while (h < a.length / 2) {
            h = (2 * h) + 1;
        }

        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if(a[j-h] > a[j]){
                        int temp = a[j-h];
                        a[j-h] = a[j];
                        a[j] = temp;
                    }else {
                        break;
                    }
                }
            }
            h = h / 2;//缩减增量
        }
        System.out.println(Arrays.toString(a));

    }

    //获取最大增长量
    private int getIncrement(int h, int length) {
        while (h < length / 2) {
            h = (2 * h) + 1;
        }
        return h;
    }

    private int decr(int h) {
        return h / 2;
    }

}
