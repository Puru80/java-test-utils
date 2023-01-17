package com.example;

public class SQSGraphGenerator {

    public static String queueNames = "";

    //region sqsWidgets
    public static String sqsWidget = "{\n" +
            "            \"height\": 6,\n" +
            "            \"width\": 6,\n" +
            "            \"y\": 0,\n" +
            "            \"x\": 0,\n" +
            "            \"type\": \"metric\",\n" +
            "            \"properties\": {\n" +
            "                \"metrics\": [\n" +
            "                    [ \"AWS/SQS\", \"NumberOfMessagesReceived\", \"QueueName\", \"queueName\" ],\n" +
            "                    [ \".\", \"NumberOfMessagesDeleted\", \".\", \".\" ],\n" +
            "                    [ \".\", \"NumberOfMessagesSent\", \".\", \".\" ]\n" +
            "                ],\n" +
            "                \"view\": \"timeSeries\",\n" +
            "                \"stacked\": false,\n" +
            "                \"region\": \"ap-south-1\",\n" +
            "                \"stat\": \"Sum\",\n" +
            "                \"period\": 60,\n" +
            "                \"title\": \"queueName\"\n" +
            "            }\n" +
            "        }, ";
    //endregion

    public static void main(String[] args) {
        String queueArr[] = queueNames.split("\n");

        for(String str: queueArr) {
            System.out.println(sqsWidget.replace("queueName", str));
        }

        System.out.println();
        System.out.println(queueArr.length);
    }
}
