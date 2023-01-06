package com.example;

public class SQSGraphGenerator {

    public static String queueNames = "";

    public static String sqsWidget = "";

    public static void main(String[] args) {
        String queueArr[] = queueNames.split("\n");

        for(String str: queueArr) {
            System.out.println(String.format(sqsWidget, str, str));
        }

        System.out.println();
        System.out.println(queueArr.length);
    }
}
