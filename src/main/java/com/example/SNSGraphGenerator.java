package com.example;

public class SNSGraphGenerator {

    private static String topics = "amplify_codecommit_topic " +
            "DealEventTopic" +
            "emailAssociationEventTopic " +
            "entityEventUpdateTopic " +
            "entityTrackingUpdateEventTopic " +
            "flashAccountEventTopic " +
            "RewardPointsEventTopic " +
            "sms-otp-login";

    private static String snsWidgets = "{\n" +
            "            \"height\": 6,\n" +
            "            \"width\": 6,\n" +
            "            \"y\": 0,\n" +
            "            \"x\": 6,\n" +
            "            \"type\": \"metric\",\n" +
            "            \"properties\": {\n" +
            "                \"metrics\": [\n" +
            "                    [ \"AWS/SNS\", \"NumberOfNotificationsDelivered\", \"TopicName\", \"%s\" ],\n" +
            "                    [ \".\", \"NumberOfNotificationsFailed\", \".\", \".\" ],\n" +
            "                    [ \".\", \"NumberOfMessagesPublished\", \".\", \".\" ]\n" +
            "                ],\n" +
            "                \"view\": \"timeSeries\",\n" +
            "                \"stacked\": false,\n" +
            "                \"region\": \"ap-south-1\",\n" +
            "                \"stat\": \"Sum\",\n" +
            "                \"period\": 60,\n" +
            "                \"title\": \"%s\"\n" +
            "            }\n" +
            "        },";

    public static void main(String[] args) {
        String[] topicArr = topics.split(" ");

        for(String str: topicArr) {
            System.out.println(String.format(snsWidgets, str, str));
        }

        System.out.println();
        System.out.println(topicArr.length);
    }
}
