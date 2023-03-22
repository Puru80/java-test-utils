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
    */

    public static String resources = "/user/login POST 10000 ApiGatewayUserLoginThroughputCritical\n" +
            "/user/validate-otp POST 3000 ApiGatewayUserValidateOtpThroughputCritical\n" +
            "/user/logout POST 800 ApiGatewayUserLogoutThroughputCritical\n" +
            "/user/flash/create-account POST 5000 ApiGatewayUserFlashCreateAccountThroughputCritical\n" +
            "/user/profile GET 5000 ApiGatewayUserProfileThroughputCritical\n" +
            "/user/refresh-session PUT 5000 ApiGatewayUserRefreshSessionThroughputCritical\n" +
            "/v1/users/invite/validate POST 500 ApiGatewayUserInviteValidateThroughputCritical\n" +
            "/v1/users/invite/usage GET 3000 ApiGatewayUserInviteUsageThroughputCritical\n" +
            "/device/store POST 2000 ApiGatewayDeviceStoreThroughputCritical\n" +
            "/device/update POST 3000 ApiGatewayDeviceUpdateThroughputCritical\n" +
            "/user/insights GET 15000 ApiGatewayUserInsightsThroughputCritical\n" +
            "/user/insights/brand/{brand} GET 2000 ApiGatewayUserBrandInsightsThroughputCritical";

    public static String template = "\"{resource}\": {\n" +
            "    \"Type\": \"AWS::CloudWatch::Alarm\",\n" +
            "    \"Properties\": {\n" +
            "        \"AlarmName\": \"API GATEWAY | {resName} | throughput_low | Critical\",\n" +
            "        \"AlarmDescription\": \"Check the Throughput in Prod for {resName} API. The api might be down.\",\n" +
            "        \"ActionsEnabled\": true,\n" +
            "        \"OKActions\": [],\n" +
            "        \"AlarmActions\": [\n" +
            "            \"arn:aws:sns:ap-south-1:734835702833:Flash_Prod_CloudWatch_Alarms_Topic\"\n" +
            "        ],\n" +
            "        \"InsufficientDataActions\": [],\n" +
            "        \"MetricName\": \"Count\",\n" +
            "        \"Namespace\": \"AWS/ApiGateway\",\n" +
            "        \"Statistic\": \"Sum\",\n" +
            "        \"Dimensions\": [\n" +
            "            {\n" +
            "                \"Name\": \"Stage\",\n" +
            "                \"Value\": \"$default\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"Name\": \"Method\",\n" +
            "                \"Value\": \"{method}\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"Name\": \"Resource\",\n" +
            "                \"Value\": \"{resName}\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"Name\": \"ApiId\",\n" +
            "                \"Value\": \"ju6maoy9o2\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"Period\": 600,\n" +
            "        \"EvaluationPeriods\": 1,\n" +
            "        \"DatapointsToAlarm\": 1,\n" +
            "        \"Threshold\": 0,\n" +
            "        \"ComparisonOperator\": \"LessThanOrEqualToThreshold\",\n" +
            "        \"TreatMissingData\": \"missing\"\n" +
            "    }\n" +
            "},";

    public static void main(String[] args) {
        String[] resArr = resources.split("\n");

        for (int i = 0; i < resArr.length; i++) {
            String[] arr = resArr[i].split(" ");

            String apiRoute = arr[0];
            String method = arr[1];
            String threshold = arr[2];
            String resource = arr[3];

            template = template.replace("{resource}", resource);
            template = template.replace("{resName}", apiRoute);
            template = template.replace("{method}", method);
//            template = template.replace("{threshold}", "1");

            System.out.println(template);

            template = template.replace(resource, "{resource}");
            template = template.replace(apiRoute, "{resName}");
//            template = template.replace("Threshold: 1", "Threshold: {threshold}");
            template = template.replace(method, "{method}");
        }

        System.out.println();
        System.out.println(resArr.length);
    }

}
