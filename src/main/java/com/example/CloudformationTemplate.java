package com.example;

public class CloudformationTemplate {

    /*
    /user/login POST
    /user/validate-otp POST
    /user/interest POST
    /user/logout POST
    /user/flash/create-account POST
    /user/profile GET
    /user/refresh-session PUT
    /user/deactivate POST
    /referral/update POST
    /referral/fetch GET
    /v1/users/invite/validate POST
    /v1/users/invite/usage GET
    /device/store POST
    /device/update POST
    /waitlist/fetch GET
    /user/insights GET
    /user/insights/brand/{brand} GET
    * */

    public static String resources = "/user/login POST\n" +
            "/user/validate-otp POST\n" +
            "/user/interest POST\n" +
            "/user/logout POST\n" +
            "/user/flash/create-account POST\n" +
            "/user/profile GET\n" +
            "/user/refresh-session PUT\n" +
            "/user/deactivate POST\n" +
            "/referral/update POST\n" +
            "/referral/fetch GET\n" +
            "/v1/users/invite/validate POST\n" +
            "/v1/users/invite/usage GET\n" +
            "/device/store POST\n" +
            "/device/update POST\n" +
            "/waitlist/fetch GET\n" +
            "/user/insights GET\n" +
            "/user/insights/brand/{brand} GET";

    public static String template = "\"Properties\": {\n" +
            "                \"AlarmName\": \"{resName} - Alarm\",\n" +
            "                \"ActionsEnabled\": true,\n" +
            "                \"OKActions\": [],\n" +
            "                \"AlarmActions\": [\n" +
            "                    \"arn:aws:sns:ap-south-1:137982551423:flash-stage-user-alarms-topic\"\n" +
            "                ],\n" +
            "                \"InsufficientDataActions\": [],\n" +
            "                \"Dimensions\": [],\n" +
            "                \"EvaluationPeriods\": 1,\n" +
            "                \"DatapointsToAlarm\": 1,\n" +
            "                \"Threshold\": 3,\n" +
            "                \"ComparisonOperator\": \"GreaterThanThreshold\",\n" +
            "                \"TreatMissingData\": \"notBreaching\",\n" +
            "                \"Metrics\": [\n" +
            "                    {\n" +
            "                        \"Id\": \"e1\",\n" +
            "                        \"Label\": \"Error Percentrage\",\n" +
            "                        \"ReturnData\": true,\n" +
            "                        \"Expression\": \"((m2 + m3)/m1) * 100\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"Id\": \"m2\",\n" +
            "                        \"ReturnData\": false,\n" +
            "                        \"MetricStat\": {\n" +
            "                            \"Metric\": {\n" +
            "                                \"Namespace\": \"AWS/ApiGateway\",\n" +
            "                                \"MetricName\": \"4xx\",\n" +
            "                                \"Dimensions\": [\n" +
            "                                    {\n" +
            "                                        \"Name\": \"Stage\",\n" +
            "                                        \"Value\": \"$default\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"Name\": \"Method\",\n" +
            "                                        \"Value\": \"{method}\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"Name\": \"Resource\",\n" +
            "                                        \"Value\": \"{resName}\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"Name\": \"ApiId\",\n" +
            "                                        \"Value\": \"5a5b3x6e13\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            \"Period\": 60,\n" +
            "                            \"Stat\": \"Sum\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"Id\": \"m3\",\n" +
            "                        \"ReturnData\": false,\n" +
            "                        \"MetricStat\": {\n" +
            "                            \"Metric\": {\n" +
            "                                \"Namespace\": \"AWS/ApiGateway\",\n" +
            "                                \"MetricName\": \"5xx\",\n" +
            "                                \"Dimensions\": [\n" +
            "                                    {\n" +
            "                                        \"Name\": \"Stage\",\n" +
            "                                        \"Value\": \"$default\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"Name\": \"Method\",\n" +
            "                                        \"Value\": \"{method}\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"Name\": \"Resource\",\n" +
            "                                        \"Value\": \"{resName}\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"Name\": \"ApiId\",\n" +
            "                                        \"Value\": \"5a5b3x6e13\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            \"Period\": 60,\n" +
            "                            \"Stat\": \"Sum\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"Id\": \"m1\",\n" +
            "                        \"Label\": \"Invocations\",\n" +
            "                        \"ReturnData\": false,\n" +
            "                        \"MetricStat\": {\n" +
            "                            \"Metric\": {\n" +
            "                                \"Namespace\": \"AWS/ApiGateway\",\n" +
            "                                \"MetricName\": \"Count\",\n" +
            "                                \"Dimensions\": [\n" +
            "                                    {\n" +
            "                                        \"Name\": \"Stage\",\n" +
            "                                        \"Value\": \"$default\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"Name\": \"Method\",\n" +
            "                                        \"Value\": \"{method}\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"Name\": \"Resource\",\n" +
            "                                        \"Value\": \"{resName}\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"Name\": \"ApiId\",\n" +
            "                                        \"Value\": \"5a5b3x6e13\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            \"Period\": 60,\n" +
            "                            \"Stat\": \"Sum\"\n" +
            "                        }\n" +
            "                    }\n" +
            "                ]\n" +
            "            }";

    public static void main(String[] args) {
        String [] resArr = resources.split("\n");

        for (int i=0;i<resArr.length;i++) {
            String [] arr = resArr[i].split(" ");

            String apiRoute = arr[0];
            String method = arr[1];

            template = template.replace("{resName}", apiRoute);
            template = template.replace("{method}", method);

            System.out.println(template);

            template = template.replace(apiRoute, "{resName}");
            template = template.replace(method, "{method}");

//            System.out.println(template);
//            break;

        }

        System.out.println();
        System.out.println(resArr.length);
    }

}
