package com.example;

public class LambdaAlarmTemplate {
    
    public static String resources = "UsersLambda\n" +
            "WaitlistLambda\n" +
            "ReferralLambda\n" +
            "DeviceLambda\n" +
            "UserFeedsEventHandler\n" +
            "FetchCustomersEcommerceInsightsLambda\n" +
            "CustomersEcommerceInsightsSQSEventLambda";
    
    public static String template = "\"{resName} - Alarm\": {\n" +
            "        \"Type\": \"AWS::CloudWatch::Alarm\",\n" +
            "        \"Properties\": {\n" +
            "          \"AlarmName\": \"flash-stage-users-lambda-alarm\",\n" +
            "          \"ActionsEnabled\": true,\n" +
            "          \"OKActions\": [],\n" +
            "          \"AlarmActions\": [\n" +
            "            \"arn:aws:sns:ap-south-1:137982551423:flash-stage-lambda-alarms-topic\"\n" +
            "          ],\n" +
            "          \"InsufficientDataActions\": [],\n" +
            "          \"Dimensions\": [],\n" +
            "          \"EvaluationPeriods\": 1,\n" +
            "          \"DatapointsToAlarm\": 1,\n" +
            "          \"Threshold\": 3,\n" +
            "          \"ComparisonOperator\": \"GreaterThanThreshold\",\n" +
            "          \"TreatMissingData\": \"missing\",\n" +
            "          \"Metrics\": [\n" +
            "            {\n" +
            "              \"Id\": \"e1\",\n" +
            "              \"Label\": \"Error Percentage\",\n" +
            "              \"ReturnData\": true,\n" +
            "              \"Expression\": \"(m1/m2)*100\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"Id\": \"m1\",\n" +
            "              \"ReturnData\": false,\n" +
            "              \"MetricStat\": {\n" +
            "                \"Metric\": {\n" +
            "                  \"Namespace\": \"AWS/Lambda\",\n" +
            "                  \"MetricName\": \"Errors\",\n" +
            "                  \"Dimensions\": [\n" +
            "                    {\n" +
            "                      \"Name\": \"FunctionName\",\n" +
            "                      \"Value\": \"{resName}\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                      \"Name\": \"Resource\",\n" +
            "                      \"Value\": \"{resName}\"\n" +
            "                    }\n" +
            "                  ]\n" +
            "                },\n" +
            "                \"Period\": 60,\n" +
            "                \"Stat\": \"Sum\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"Id\": \"m2\",\n" +
            "              \"ReturnData\": false,\n" +
            "              \"MetricStat\": {\n" +
            "                \"Metric\": {\n" +
            "                  \"Namespace\": \"AWS/Lambda\",\n" +
            "                  \"MetricName\": \"Invocations\",\n" +
            "                  \"Dimensions\": [\n" +
            "                    {\n" +
            "                      \"Name\": \"FunctionName\",\n" +
            "                      \"Value\": \"{resName}\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                      \"Name\": \"Resource\",\n" +
            "                      \"Value\": \"{resName}\"\n" +
            "                    }\n" +
            "                  ]\n" +
            "                },\n" +
            "                \"Period\": 60,\n" +
            "                \"Stat\": \"Sum\"\n" +
            "              }\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      }, ";

    public static void main(String[] args) {
        String [] resArr = resources.split("\n");

        for (int i=0;i<resArr.length;i++) {
            String [] arr = resArr[i].split(" ");

            String lambda = arr[0];

            template = template.replace("{resName}", lambda);

            System.out.println(template);

            template = template.replace(lambda, "{resName}");

        }

        System.out.println();
        System.out.println(resArr.length);
    }
}
