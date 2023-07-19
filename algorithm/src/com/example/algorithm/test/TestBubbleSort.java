package com.example.algorithm.test;

import org.junit.Test;

import java.util.Arrays;

public class TestBubbleSort {

    //冒泡排序

    @Test
    public void bubbleSort() {
        int[] orign = {4, 5, 6, 1, 2, 3};
        for (int i = 0; i < orign.length - 1; i++) {
            for (int j = 0; j < orign.length - 1 - i; j++) {
                if (orign[j] > orign[j + 1]) {
                    int temp = orign[j];
                    orign[j] = orign[j + 1];
                    orign[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(orign));
    }



}
