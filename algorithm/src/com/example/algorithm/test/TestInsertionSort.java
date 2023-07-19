package com.example.algorithm.test;

import org.junit.Test;

import java.util.Arrays;

public class TestInsertionSort {

    //插入排序
    @Test
    public void InsertionSort() {
        int[] a = {4, 3, 2, 10, 12, 1, 5, 6};
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
        System.out.println(Arrays.toString(a));
    }
}
