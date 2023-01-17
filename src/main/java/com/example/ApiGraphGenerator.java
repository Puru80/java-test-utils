package com.example;

public class ApiGraphGenerator {

    public static String apiRoutes = "";

    //region apiWidgets
    public static String apiWidgets = "{\n" +
            "            \"height\": 6,\n" +
            "            \"width\": 6,\n" +
            "            \"y\": 0,\n" +
            "            \"x\": 1,\n" +
            "            \"type\": \"metric\",\n" +
            "            \"properties\": {\n" +
            "                \"metrics\": [\n" +
            "                    [ \"AWS/ApiGateway\", \"Count\", \"Resource\", \"apiRoute\", \"Stage\", \"$default\", \"Method\", \"method\", \"ApiId\", \"apiId\", { \"label\": \"Invocations\" } ]\n" +
            "                ],\n" +
            "                \"view\": \"timeSeries\",\n" +
            "                \"stacked\": false,\n" +
            "                \"region\": \"ap-south-1\",\n" +
            "                \"stat\": \"Sum\",\n" +
            "                \"period\": 300,\n" +
            "                \"title\": \"apiRoute - Invocations\"\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"height\": 6,\n" +
            "            \"width\": 6,\n" +
            "            \"y\": 0,\n" +
            "            \"x\": 9,\n" +
            "            \"type\": \"metric\",\n" +
            "            \"properties\": {\n" +
            "                \"metrics\": [\n" +
            "                    [ \"AWS/ApiGateway\", \"4xx\", \"Resource\", \"apiRoute\", \"Stage\", \"$default\", \"Method\", \"method\", \"ApiId\", \"apiId\", { \"color\": \"#d62728\" } ],\n" +
            "                    [ \".\", \"5xx\", \".\", \".\", \".\", \".\", \".\", \".\", \".\", \".\", { \"color\": \"#e377c2\" } ]\n" +
            "                ],\n" +
            "                \"view\": \"timeSeries\",\n" +
            "                \"stacked\": false,\n" +
            "                \"region\": \"ap-south-1\",\n" +
            "                \"stat\": \"Sum\",\n" +
            "                \"period\": 300,\n" +
            "                \"title\": \"apiRoute - Error\"\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"height\": 6,\n" +
            "            \"width\": 6,\n" +
            "            \"y\": 0,\n" +
            "            \"x\": 17,\n" +
            "            \"type\": \"metric\",\n" +
            "            \"properties\": {\n" +
            "                \"metrics\": [\n" +
            "                    [ \"AWS/ApiGateway\", \"Latency\", \"Resource\", \"apiRoute\", \"Stage\", \"$default\", \"Method\", \"method\", \"ApiId\", \"apiId\", { \"color\": \"#9467bd\" } ]\n" +
            "                ],\n" +
            "                \"view\": \"timeSeries\",\n" +
            "                \"stacked\": false,\n" +
            "                \"region\": \"ap-south-1\",\n" +
            "                \"stat\": \"p99\",\n" +
            "                \"period\": 300,\n" +
            "                \"title\": \"apiRoute - Latency\"\n" +
            "            }\n" +
            "        },";
    //endregion

    public static void main(String[] args) {

        String [] apiArr = apiRoutes.split("\n");

        for (String str : apiArr) {
            String [] arr = str.split("\t");

            String apiId = arr[0];
            String method = arr[1];
            String apiRoute = arr[2];

            apiWidgets = apiWidgets.replace("apiRoute", apiRoute);
            apiWidgets = apiWidgets.replace("method", method);
            apiWidgets = apiWidgets.replace("apiId", apiId);

            System.out.println(apiWidgets);

            apiWidgets = apiWidgets.replace(apiRoute, "apiRoute");
            apiWidgets = apiWidgets.replace(method, "method");
            apiWidgets = apiWidgets.replace(apiId, "apiId");

        }

        System.out.println();
        System.out.println(apiArr.length);

    }
}
