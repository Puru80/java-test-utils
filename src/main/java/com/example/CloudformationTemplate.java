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

    public static String resources = "/user/login POST 10000 ApiGatewayUserLogin4xxErrorCritical\n" +
            "/user/validate-otp POST 3000 ApiGatewayUserValidateOtp4xxErrorCritical\n" +
            "/user/logout POST 800 ApiGatewayUserLogout4xxErrorCritical\n" +
            "/user/flash/create-account POST 5000 ApiGatewayUserFlashCreateAccount4xxErrorCritical\n" +
            "/user/profile GET 5000 ApiGatewayUserProfile4xxErrorCritical\n" +
            "/user/refresh-session PUT 5000 ApiGatewayUserRefreshSession4xxErrorCritical\n" +
            "/v1/users/invite/validate POST 500 ApiGatewayUserInviteValidate4xxErrorCritical\n" +
            "/v1/users/invite/usage GET 3000 ApiGatewayUserInviteUsage4xxErrorCritical\n" +
            "/device/store POST 2000 ApiGatewayDeviceStore4xxErrorCritical\n" +
            "/device/update POST 3000 ApiGatewayDeviceUpdate4xxErrorCritical\n" +
            "/user/insights GET 15000 ApiGatewayUserInsights4xxErrorCritical\n" +
            "/user/insights/brand/{brand} GET 2000 ApiGatewayUserBrandInsights4xxErrorCritical";

    public static String template = "\"{resource}\": {\n" +
            "      \"Type\": \"AWS::CloudWatch::Alarm\",\n" +
            "      \"Properties\": {\n" +
            "        \"AlarmName\": \"API GATEWAY | {resName} | 4xx_error%_high | Critical\",\n" +
            "        \"AlarmDescription\": \"Check the 4xx_error%_high% in Prod for {resName} API.\",\n" +
            "        \"ActionsEnabled\": true,\n" +
            "        \"OKActions\": [],\n" +
            "        \"AlarmActions\": [\n" +
            "          \"arn:aws:sns:ap-south-1:734835702833:Flash_Prod_CloudWatch_Alarms_Topic\"\n" +
            "        ],\n" +
            "        \"InsufficientDataActions\": [],\n" +
            "        \"Dimensions\": [],\n" +
            "        \"EvaluationPeriods\": 3,\n" +
            "        \"DatapointsToAlarm\": 3,\n" +
            "        \"Threshold\": 20,\n" +
            "        \"ComparisonOperator\": \"GreaterThanOrEqualToThreshold\",\n" +
            "        \"TreatMissingData\": \"missing\",\n" +
            "        \"Metrics\": [\n" +
            "          {\n" +
            "            \"Id\": \"e1\",\n" +
            "            \"Label\": \"Expression1\",\n" +
            "            \"ReturnData\": true,\n" +
            "            \"Expression\": \"100*(m3/m1)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"Id\": \"m3\",\n" +
            "            \"ReturnData\": false,\n" +
            "            \"MetricStat\": {\n" +
            "              \"Metric\": {\n" +
            "                \"Namespace\": \"AWS/ApiGateway\",\n" +
            "                \"MetricName\": \"4xx\",\n" +
            "                \"Dimensions\": [\n" +
            "                  {\n" +
            "                    \"Name\": \"Resource\",\n" +
            "                    \"Value\": \"{resName}\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"Name\": \"Stage\",\n" +
            "                    \"Value\": \"$default\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"Name\": \"Method\",\n" +
            "                    \"Value\": \"{method}\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"Name\": \"ApiId\",\n" +
            "                    \"Value\": \"ju6maoy9o2\"\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              \"Period\": 60,\n" +
            "              \"Stat\": \"Sum\"\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"Id\": \"m1\",\n" +
            "            \"Label\": \"Invocations\",\n" +
            "            \"ReturnData\": false,\n" +
            "            \"MetricStat\": {\n" +
            "              \"Metric\": {\n" +
            "                \"Namespace\": \"AWS/ApiGateway\",\n" +
            "                \"MetricName\": \"Count\",\n" +
            "                \"Dimensions\": [\n" +
            "                  {\n" +
            "                    \"Name\": \"Resource\",\n" +
            "                    \"Value\": \"{resName}\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"Name\": \"Stage\",\n" +
            "                    \"Value\": \"$default\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"Name\": \"Method\",\n" +
            "                    \"Value\": \"{method}\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"Name\": \"ApiId\",\n" +
            "                    \"Value\": \"ju6maoy9o2\"\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              \"Period\": 60,\n" +
            "              \"Stat\": \"Sum\"\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    }, ";

    public static void main(String[] args) {
        String [] resArr = resources.split("\n");

        for (int i=0;i<resArr.length;i++) {
            String [] arr = resArr[i].split(" ");

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
