package com.example.algorithm.test;

import org.junit.Test;

import java.util.Arrays;

public class TestSelectionSort {

    //选择排序
    @Test
    public void selectionSort() {
        int[] a = {4, 6, 8, 7, 9, 2, 10, 1};
        for (int i = 0; i < a.length - 1; i++) { //轮数
            int min = i;
            for (int j = i + 1; j < a.length; j++) { //里面的内容
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
