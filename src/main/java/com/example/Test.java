package com.example;

import java.util.UUID;

public class Test {

    public static void main(String[] args) {
        String value = String.format("/close?requestId=%s", UUID.randomUUID().toString());
        System.out.println(value);
    }
}
