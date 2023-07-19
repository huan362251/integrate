package com.example.algorithm.test;

import org.junit.Test;

public class TestRecursion {
    //递归算法
    @Test
    public void recursion() {
        System.out.println(recursionAlgo(10));
    }

    public int recursionAlgo(int n) {
        if (n == 1) {
            return n;
        }
        return n * recursionAlgo(n - 1);
    }
}
