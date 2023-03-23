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

    public static String apiResources = "/user/login POST 10000 ApiGatewayUserLoginLatencyHighWarn\n" +
            "/user/validate-otp POST 3000 ApiGatewayUserValidateOtpLatencyHighWarn\n" +
            "/user/logout POST 800 ApiGatewayUserLogoutLatencyHighWarn\n" +
            "/user/flash/create-account POST 5000 ApiGatewayUserFlashCreateAccountLatencyHighWarn\n" +
            "/user/profile GET 5000 ApiGatewayUserProfileLatencyHighWarn\n" +
            "/user/refresh-session PUT 5000 ApiGatewayUserRefreshSessionLatencyHighWarn\n" +
            "/v1/users/invite/validate POST 500 ApiGatewayUserInviteValidateLatencyHighWarn\n" +
            "/v1/users/invite/usage GET 3000 ApiGatewayUserInviteUsageLatencyHighWarn\n" +
            "/device/store POST 2000 ApiGatewayDeviceStoreLatencyHighWarn\n" +
            "/device/update POST 3000 ApiGatewayDeviceUpdateLatencyHighWarn\n" +
            "/user/insights GET 15000 ApiGatewayUserInsightsLatencyHighWarn\n" +
            "/user/insights/brand/{brand} GET 2000 ApiGatewayUserBrandInsightsLatencyHighWarn";

    public static String sqsResources = "Customer-Feeds-Update-Queue CustomerFeedsUpdateQueueAlarm\n" +
            "Customer-Feeds-Update-Queue-dlq CustomerFeedsUpdateQueueDLQAlarm\n" +
            "Ninja-fetch-emails-deadletter-queue NinjaFetchEmailsDLQAlarm\n" +
            "Ninja-fetch-emails-queue NinjaFetchEmailsQueueAlarm\n" +
            "Ninja-process-emails-deadletter-queue NinjaFetchEmailsDLQAlarm\n" +
            "Ninja-process-emails-queue NinjaProcessEmailsQueueAlarm\n" +
            "PushNotificationQueue PushNotificationQueueAlarm\n" +
            "Reward-Events-Queue RewardEventsQueueAlarm\n" +
            "Reward-Events-Queue-Dead-letter RewardEventsDLQAlarm\n" +
            "customer-insights-handler-queue CustomerInsightsHandlerQueueAlarm\n" +
            "customer-insights-handler-queue-dlq CustomerInsightsHandlerDLQAlarm\n" +
            "email-categorization-queue EmailCategorizationQueueAlarm\n" +
            "email-categorization-queue-dlq EmailCategorizationDLQAlarm\n" +
            "email_merchant_classification_dlq EmailMerchantClassificationDLQAlarm\n" +
            "email_merchant_classification_queue EmailMerchantClassificationQueueAlarm\n" +
            "fetch-tracking-details-dead-letter-queue FetchTrackingDetailsDLQAlarm\n" +
            "fetch-tracking-details-queue FetchTrackingDetailsQueueAlarm\n" +
            "flash-analytics-email-fetch-queue FlashAnalyticsEmailFetchQueueAlarm\n" +
            "flash-analytics-email-process-queue FlashAnalyticsEmailProcessQueueAlarm\n" +
            "flash-app-ses-inbound-s3-save-notification FlashAppSesInboundS3SaveNotificationQueueAlarm\n" +
            "flash-app-ses-inbound-s3-save-notification-dlq FlashAppSesInboundS3SaveNotificationDLQAlarm\n" +
            "flash-gmail-user-inbox-onboarding FlashGmailUserInboxOnboardingQueueAlarm\n" +
            "flash-gmail-user-inbox-onboarding-deadletter FlashGmailUserInboxOnboardingDLQAlarm\n" +
            "flash-payments-webhook FlashPaymentsWebhookQueueAlarm\n" +
            "flash-payments-webhook-dlq FlashPaymentsWebhookDLQAlarm\n" +
            "flash-prod-ops-portal-email-pipeline-queue FlashProdOpsPortalEmailPipelineQueueAlarm\n" +
            "flash_email_received_alarm_queue FlashEmailReceivedAlarmQueueAlarm\n" +
            "fmail_sent_feedback_queue FmailSentFeedbackQueueAlarm\n" +
            "gmail_push_subscription_queue GmailPushSubscriptionQueueAlarm\n" +
            "gmail_push_subscription_queue_dlq GmailPushSubscriptionDLQAlarm\n" +
            "push-notifications-dlq PushNotificationsDLQAlarm\n" +
            "pushNotificationTriggerQueue PushNotificationTriggerQueueAlarm\n" +
            "scheduler-redis-queue SchedulerRedisQueueAlarm\n" +
            "tracking-details-response-dead-letter-queue TrackingDetailsResponseDLQAlarm\n" +
            "tracking-details-response-queue TrackingDetailsResponseQueueAlarm";

    public static String template = "\"{resource}\": {\n" +
            "  \"Type\": \"AWS::CloudWatch::Alarm\",\n" +
            "  \"Properties\": {\n" +
            "    \"AlarmName\": \"SQS | {resName} | Stuck Messages Percentage | Critical\",\n" +
            "    \"AlarmDescription\": \"Check the stuck message count in {resName}\",\n" +
            "    \"ActionsEnabled\": true,\n" +
            "    \"OKActions\": [],\n" +
            "    \"AlarmActions\": [\n" +
            "      \"arn:aws:sns:ap-south-1:734835702833:Flash_Prod_CloudWatch_Alarms_Topic\"\n" +
            "    ],\n" +
            "    \"InsufficientDataActions\": [],\n" +
            "    \"Dimensions\": [],\n" +
            "    \"EvaluationPeriods\": 1,\n" +
            "    \"DatapointsToAlarm\": 1,\n" +
            "    \"Threshold\": 90,\n" +
            "    \"ComparisonOperator\": \"LessThanOrEqualToThreshold\",\n" +
            "    \"TreatMissingData\": \"missing\",\n" +
            "    \"Metrics\": [\n" +
            "      {\n" +
            "        \"Id\": \"e1\",\n" +
            "        \"Label\": \"Expression1\",\n" +
            "        \"ReturnData\": true,\n" +
            "        \"Expression\": \"100*(m2/m1)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Id\": \"m2\",\n" +
            "        \"ReturnData\": false,\n" +
            "        \"MetricStat\": {\n" +
            "          \"Metric\": {\n" +
            "            \"Namespace\": \"AWS/SQS\",\n" +
            "            \"MetricName\": \"NumberOfMessagesDeleted\",\n" +
            "            \"Dimensions\": [\n" +
            "              {\n" +
            "                \"Name\": \"QueueName\",\n" +
            "                \"Value\": \"{resName}\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          \"Period\": 300,\n" +
            "          \"Stat\": \"Sum\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"Id\": \"m1\",\n" +
            "        \"ReturnData\": false,\n" +
            "        \"MetricStat\": {\n" +
            "          \"Metric\": {\n" +
            "            \"Namespace\": \"AWS/SQS\",\n" +
            "            \"MetricName\": \"NumberOfMessagesReceived\",\n" +
            "            \"Dimensions\": [\n" +
            "              {\n" +
            "                \"Name\": \"QueueName\",\n" +
            "                \"Value\": \"{resName}\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          \"Period\": 300,\n" +
            "          \"Stat\": \"Sum\"\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}, ";

    public static void main(String[] args) {
        String[] resArr = sqsResources.split("\n");

        for (int i = 0; i < resArr.length; i++) {
            String[] arr = resArr[i].split(" ");

            String apiRoute = arr[0];
//            String method = arr[1];
//            String threshold = arr[2];
            String resource = arr[1];

            template = template.replace("{resource}", resource);
            template = template.replace("{resName}", apiRoute);
//            template = template.replace("{method}", method);
//            template = template.replace("{threshold}", "1");

            System.out.println(template);

            template = template.replace(resource, "{resource}");
            template = template.replace(apiRoute, "{resName}");
//            template = template.replace("Threshold: 1", "Threshold: {threshold}");
//            template = template.replace(method, "{method}");
        }

        System.out.println();
        System.out.println(resArr.length);
    }

}
