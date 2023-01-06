package com.example;

public class SNSGraphGenerator {

    private static String topics = "";

    private static String snsWidgets = ",";

    public static void main(String[] args) {
        String[] topicArr = topics.split("\n");

        for(String str: topicArr) {
            System.out.println(String.format(snsWidgets, str, str));
        }

        System.out.println();
        System.out.println(topicArr.length);
    }
}
