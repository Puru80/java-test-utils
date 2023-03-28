package com.example;

public class MetricFilterCloudFormationTemplate {

    public static String apiResources = "/user/login POST UserLogin\n" +
            "/user/validate-otp POST UserValidateOtp\n" +
            "/user/logout POST UserLogout\n" +
            "/user/flash/create-account POST UserFlashCreateAccount\n" +
            "/user/profile GET UserProfile\n" +
            "/user/refresh-session PUT UserRefreshSession\n" +
            "/v1/users/invite/validate POST UserInviteValidate\n" +
            "/v1/users/invite/usage GET UserInviteUsage\n" +
            "/device/store POST DeviceStore\n" +
            "/device/update POST DeviceUpdate\n" +
            "/user/insights GET UserInsights\n" +
            "/user/insights/brand/{brand} GET UserBrandInsights\n";

    public static String resourceTemplate = "\"{resName}401MetricFilter\": {\n" +
            "      \"Type\": \"AWS::Logs::MetricFilter\",\n" +
            "      \"Properties\": {\n" +
            "        \"LogGroupName\": \"/aws/ApiGateway/FlashAppGatewayLogs\",\n" +
            "        \"FilterPattern\": \"{$.routeKey = \\\"{method} {api}\\\" && $.status = 401}\",\n" +
            "        \"FilterName\": \"{resName}401MetricFilter\", \n" +
            "        \"MetricTransformations\": [\n" +
            "          {\n" +
            "            \"DefaultValue\": 0,\n" +
            "            \"MetricValue\": \"1\",\n" +
            "            \"MetricNamespace\": \"FlashAppGateway/401s\",\n" +
            "            \"MetricName\": \"{api} - 401Count\",\n" +
            "            \"Unit\": \"Count\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    }, ";

    public static void main(String[] args) {
        String[] resArr = apiResources.split("\n");

        for (int i = 0; i < resArr.length; i++) {
            String[] arr = resArr[i].split(" ");

            String apiRoute = arr[0];
            String method = arr[1];
            String resName = arr[2];

            resourceTemplate = resourceTemplate.replace("{api}", apiRoute);
            resourceTemplate = resourceTemplate.replace("{method}", method);
            resourceTemplate = resourceTemplate.replace("{resName}", resName);

            System.out.println(resourceTemplate);

            resourceTemplate = resourceTemplate.replace(apiRoute, "{api}");
            resourceTemplate = resourceTemplate.replace(method, "{method}");
            resourceTemplate = resourceTemplate.replace(resName, "{resName}");
        }

        System.out.println();
        System.out.println(resArr.length);
    }


}
