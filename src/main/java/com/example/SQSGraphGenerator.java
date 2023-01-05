package com.example;

public class SQSGraphGenerator {

    public static String queueNames = "Customer-Feeds-Update-Queue\n" +
            "customer-insights-handler-queue\n" +
            "email-categorization-dead-letter-queue\n" +
            "email-categorization-queue\n" +
            "fetch-tracking-details-queue\n" +
            "flash-analytics-email-fetch-queue\n" +
            "flash-analytics-email-process-queue\n" +
            "flash-app-ses-inbound-s3-save-notification\n" +
            "flash-gmail-user-inbox-onboarding\n" +
            "flash-gmail-user-inbox-onboarding-dead-letter-queue\n" +
            "flash-payments-webhook\n" +
            "inbox-testing-gmail-user-inbox-onboarding\n" +
            "rewardEventTriggerQueue\n" +
            "testPushNotificationQueue\n" +
            "tracking-details-response-queue\n" +
            "update-tracking-details-queue\n";

    public static String sqsWidget = "{\n" +
            "            \"height\": 6,\n" +
            "            \"width\": 6,\n" +
            "            \"y\": 0,\n" +
            "            \"x\": 0,\n" +
            "            \"type\": \"sqsWidget\",\n" +
            "            \"properties\": {\n" +
            "                \"metrics\": [\n" +
            "                    [ \"AWS/SQS\", \"NumberOfMessagesReceived\", \"QueueName\", \"%s\" ],\n" +
            "                    [ \".\", \"NumberOfMessagesDeleted\", \".\", \".\" ],\n" +
            "                    [ \".\", \"NumberOfMessagesSent\", \".\", \".\" ]\n" +
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
        String queueArr[] = queueNames.split("\n");

        for(String str: queueArr) {
            System.out.println(String.format(sqsWidget, str, str));
        }

        System.out.println();
        System.out.println(queueArr.length);
    }
}
