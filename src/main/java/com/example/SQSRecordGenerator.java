package com.example;

public class SQSRecordGenerator {

    public static String records = "{\n" +
            "      \"messageId\": \"19dd0b57-b21e-4ac1-bd88-01bbb068cb78\",\n" +
            "      \"receiptHandle\": \"MessageReceiptHandle\",\n" +
            "      \"body\": \"{\\\"customerId\\\":  \\\"%s\\\", \\\"eventType\\\": \\\"ENTITY_UPDATED\\\"}\",\n" +
            "      \"attributes\": {\n" +
            "        \"ApproximateReceiveCount\": \"1\",\n" +
            "        \"SentTimestamp\": \"1523232000000\",\n" +
            "        \"SenderId\": \"123456789012\",\n" +
            "        \"ApproximateFirstReceiveTimestamp\": \"1523232000001\"\n" +
            "      },\n" +
            "      \"messageAttributes\": {},\n" +
            "      \"md5OfBody\": \"{{{md5_of_body}}}\",\n" +
            "      \"eventSource\": \"aws:sqs\",\n" +
            "      \"eventSourceARN\": \"arn:aws:sqs:us-east-1:123456789012:MyQueue\",\n" +
            "      \"awsRegion\": \"us-east-1\"\n" +
            "    }";

    public static String customerIds = "";

    public static void main(String[] args) {

        int count=0;
        for(String str: customerIds.split("\n")){
            count++;
            System.out.println(String.format(records, str) + ", ");
        }

        System.out.println(count);
    }
}
