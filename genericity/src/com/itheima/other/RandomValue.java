package com.itheima.other;

import java.util.UUID;

public class RandomValue {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-",""));
    }
}
