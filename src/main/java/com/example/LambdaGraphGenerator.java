package com.example;

public class LambdaGraphGenerator {

    private static String lambdas = "";

    private static String lambdaWidgets = "";

    public static void main(String[] args) {
        String[] lambdaArr = lambdas.split(" ");

        for(String str: lambdaArr) {
            System.out.println(String.format(lambdaWidgets, str, str));
        }

        System.out.println();
        System.out.println(lambdaArr.length);
    }
}
