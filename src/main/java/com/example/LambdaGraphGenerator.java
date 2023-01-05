package com.example;

public class LambdaGraphGenerator {

    private static String lambdas = "EmailServiceLambda\n" +
            "GmailUserMailboxServiceLambda\n" +
            "GmailUserServiceLambda\n" +
            "HandleNewFmailLambda\n" +
            "WatchSchedulerLambda\n" +
            "GmailSubscriptionHTTPEventHandler\n" +
            "InboxFeedService\n" +
            "EmailCategorizationEventHandler\n" +
            "EmailAttachmentHandler\n" +
            "EmailComposeHandler";

    //region lambdaWidgets
    private static String lambdaWidgets = "{\n" +
            "            \"height\": 6,\n" +
            "            \"width\": 6,\n" +
            "            \"y\": 0,\n" +
            "            \"x\": 0,\n" +
            "            \"type\": \"metric\",\n" +
            "            \"properties\": {\n" +
            "                \"metrics\": [\n" +
            "                    [ \"AWS/Lambda\", \"Errors\", \"FunctionName\", \"varr\", \"Resource\", \"varr\", { \"color\": \"#d62728\" } ]\n" +
            "                ],\n" +
            "                \"sparkline\": true,\n" +
            "                \"period\": 60,\n" +
            "                \"region\": \"ap-south-1\",\n" +
            "                \"title\": \"varr - Error count\",\n" +
            "                \"yAxis\": {\n" +
            "                    \"right\": {\n" +
            "                        \"max\": 100\n" +
            "                    }\n" +
            "                },\n" +
            "                \"view\": \"timeSeries\",\n" +
            "                \"stacked\": false,\n" +
            "                \"stat\": \"Sum\"\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"height\": 6,\n" +
            "            \"width\": 6,\n" +
            "            \"y\": 0,\n" +
            "            \"x\": 6,\n" +
            "            \"type\": \"metric\",\n" +
            "            \"properties\": {\n" +
            "                \"metrics\": [\n" +
            "                    [ \"AWS/Lambda\", \"Invocations\", \"FunctionName\", \"varr\", \"Resource\", \"varr\" ]\n" +
            "                ],\n" +
            "                \"period\": 60,\n" +
            "                \"region\": \"ap-south-1\",\n" +
            "                \"title\": \"varr - Invocations\",\n" +
            "                \"view\": \"timeSeries\",\n" +
            "                \"stacked\": false\n" +
            "            }\n" +
            "        },";
    //endregion

    public static void main(String[] args) {
        String[] lambdaArr = lambdas.split("\n");

        for(String str: lambdaArr) {
            System.out.println(lambdaWidgets.replace("varr", str));
        }

        System.out.println();
        System.out.println(lambdaArr.length);

        /*String[] routeArr = finalRoutes.split("\n");

        int c=0;
        int count = 0;
        for (int i = 0; i < routeArr.length; i++) {
            ++count;

            if (count == 1) {
                c++;
                System.out.println(routeArr[i].replace("\t", " "));
            }

            if (count == 6)
                count = 0;
        }

        System.out.println(c);*/

    }
}
