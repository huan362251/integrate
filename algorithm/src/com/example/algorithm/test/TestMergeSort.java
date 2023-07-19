package com.example.algorithm.test;

import org.junit.Test;

import java.util.Arrays;

public class TestMergeSort {

    private static Comparable[] assigt;

    @Test
    public void mergeSort() {
        Integer[] a = {8, 4, 5, 7, 1, 3, 6, 2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private void sort(Comparable[] a) {
        //构建辅助数据
        assigt = new Comparable[a.length];
        //获取初始起点和终点
        int low = 0;
        int high = a.length - 1;
        //进行排序
        sort(a, low, high);
    }

    private void sort(Comparable[] a, int low, int high) {
        //拆分到最后一位时，结束
        if (high <= low) {
            return;
        }
        //获取中位
        int mid = low + (high - low) / 2;
        //对每个分组进行排序
        sort(a, low, mid);
        sort(a, mid + 1, high);
        //进行合并
        merge(a, low, mid, high);
    }

    private void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int p1 = low;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= high) {
            if (a[p1].compareTo(a[p2]) < 0) {
                assigt[i++] = a[p1++];
            } else {
                assigt[i++] = a[p2++];
            }
        }
        while (p1 <= mid) {
            assigt[i++] = a[p1++];
        }
        while (p2 <= high) {
            assigt[i++] = a[p2++];
        }
        for (int index = low; index <= high; index++) {
            a[index] = assigt[index];
        }
    }

}
