package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    public static final String API_RESOURCES = "GET /user/gmail-consent UserGmailConsent\n" +
            "POST /user/flash/reserve/send-otp FlashReserveSendOTP\n" +
            "POST /tracking/trackingMore/callback TrackingMoreCallback\n" +
            /*"GET /v1/ops/ignore/promotional OpsIgnorePromotionalV1\n" +
            "GET /v1/ops/classify_type OpsClassifyTypeV1\n" +
            "GET /v1/ops/classifier/classifiers OpsClassifiersV1\n" +
            "POST /v1/ops/sender/{id}/address OpsSenderIdAddressV1\n" +
            "POST /v1/ops/phrases/add OpsPhrasesAdd\n" +
            "POST /v1/ops/ignore/add OpsIgnorePhrases\n" +
            "POST /v1/ops/classifier/add OpsClassifierAddV1\n" +
            "POST /v1/ops/phrases/{id}/update OpsPhrasesUpdateV1\n" +
            "POST /v1/ops/strategy/add OpsStrategyAddV1\n" +
            "POST /v1/ops/strategy/{id}/update OpsStrategyUpdateV1\n" +
            "POST /v1/ops/classifier/{id}/update OpsClassifierUpdateV1\n" +
            "POST /v1/ops/ignore/{id}/update OpsIgnoreUpdateV1\n" +
            "GET /v1/ops/phrases/promotional OpsPhrasesPromotionalV1\n" +
            "GET /v1/ops/domains OpsDomainsV1\n" +
            "GET /v1/ops/phrases/transactional OpsPhrasesTransactionalV1\n" +
            "GET /v1/ops/phrases/strategy OpsPhrasesStrategyV1\n" +*/
            "GET /v1/campaigns/streaks CampaignsStreaksV1\n" +
            /*"POST /v1/ops/phrases/{id}/remove OpsPhrasesRemoveV1\n" +
            "POST /v1/ops/sender OpsSenderV1Post\n" +*/
            "GET /entity EntityAPI\n" +
            "POST /v1/rewards/redeem RewardsRedeemV1\n" +
            /*"GET /v1/ops/sender/{id}/classifier OpsSenderClassifierV1\n" +
            "GET /v1/ops/sender/{sender}/domain OpsSenderDomainV1Get\n" +
            "GET /v1/ops/senders OpsSendersV1\n" +
            "GET /v1/ops/sender/address OpsSenderAddressV1\n" +
            "GET /v1/ops/sender OpsSenderV1Get\n" +
            "GET /v1/ops/ignore/personal OpsIgnorePersonalV1\n" +*/
            "GET /user/insights UserInsights\n" +
            "GET /api/v2/entities/home EntitiesHomeV2\n" +
            "POST /v1/queues/{queueName}/emails/ack QueuesEmailsAckV1\n" +
            "POST /v1/pipeline/mails PipelineMailsV1\n" +
            "GET /v1/campaigns/streaks/{id}/history CampaignsStreaksHistoryV1\n" +
            "GET /api/v1/entities/home EntitiesHomeV1\n" +
            "POST /v1/users/invite/validate UserInviteValidate\n" +
            "GET /mails MailsAPI\n" +
            "POST /device/update DeviceUpdate\n" +
            "GET /v1/campaigns/standalone/deals CampaignsStandaloneDealsV1\n" +
            "GET /v1/campaigns/streaks/{id} CampaignsStreaksIdV1\n" +
            "POST /v1/user/email-onboarding/init UserEmailOnboardingInitV1\n" +
            "POST /user/flash/reserve UserFlashReserve\n" +
            "GET /user/gmail-consent-callback UserGmailConsentCallback \n" +
            "POST /user/flash/validate UserFlashValidate\n" +
            "POST /user/login UserLogin\n" +
            /*"POST /v1/ops/sender/domain OpsSenderDomainV1Post\n" +*/
            "GET /v1/rewards/summary RewardsSummaryV1\n" +
            "POST /user/validate-otp UserValidateOtp\n" +
            "POST /user/flash/create-account UserFlashCreateAccount\n" +
            "POST /v1/campaigns/standalone/deal/fetch CampaignsStandaloneDealsFetchV1\n" +
            "GET /v1/campaigns/feed/FLASH_COIN/view CampaignsFeedFCoinViewV1\n" +
            "GET /v1/campaigns/streaks/grouped CampaignsStreaksGroupedV1\n" +
            "POST /email/trigger EmailTrigger\n" +
            "POST /gmail/subscribe GmailSubscribe\n" +
            "GET /v1/users/feed UsersFeedV1\n" +
            "GET /mail MailAPI\n" +
            "ANY /v1/user/gmail/onboarding-status UserGmailOnboardingStatusV1\n" +
            "POST /v1/payments/{gateway}/webhook PaymentsGatewayWebhookV1\n" +
            "POST /referral/update ReferralUpdate\n" +
            "GET /v1/rewards/ledger RewardsV1Ledger\n" +
            "GET /user/profile UserProfile\n" +
            "PUT /api/v1/entity/update/{entityId} EntityUpdateV1\n" +
            "POST /tracking/afterShip/callback TrackingAfterShipCallback\n" +
            "GET /entities/home EntitiesHome\n" +
            "GET /remote-config/fetch RemoteConfigFetch\n" +
            "POST /user/deactivate UserDeactivate\n" +
            "GET /v1/email/{mailId}/attachment/{attachmentId}/meta EmailAttachmentV1\n" +
            "GET /v1/user/email-onboarding/config UserGmailOnboardingConfigV1\n" +
            "GET /v1/rewards/redeem/status/{id} RewardsRedeemStatusV1\n" +
            "GET /v1/campaigns/deals CampaignsDealsV1\n" +
            "GET /v1/users/invite/usage UserInviteUsage\n" +
            "GET /user/insights/brand/{brand} UserBrandInsights\n" +
            "GET /v1/campaigns/deal CampaignsDealV1\n" +
            "POST /v1/users/feed/invalidate UsersFeedInvalidateV1\n" +
            "POST /device/store DeviceStore\n" +
            "POST /user/logout UserLogout\n" +
            "GET /inbox InboxAPI\n" +
            "GET /api/v1/entity EntityAPIV1\n" +
            "PUT /user/refresh-session UserRefreshSession\n" +
            "GET /api/v1/inbox InboxAPIV1\n" +
            "GET /v1/queues/{queueName}/clusters/{clusterId}/{mailUUID} QueuesClustersV1\n";

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
            "      \"Type\": \"AWS::CloudWatch::Alarm\",\n" +
            "      \"Properties\": {\n" +
            "        \"AlarmName\": \"API GATEWAY | {resName} | 4xx_error%_high | Critical\",\n" +
            "        \"AlarmDescription\": \"Check the 4xx_error%_high in Prod for {resName} API.\",\n" +
            "        \"ActionsEnabled\": true,\n" +
            "        \"OKActions\": [],\n" +
            "        \"AlarmActions\": [\n" +
            "          \"arn:aws:sns:ap-south-1:734835702833:Flash_Prod_CloudWatch_Alarms_Topic\"\n" +
            "        ],\n" +
            "        \"InsufficientDataActions\": [],\n" +
            "        \"Dimensions\": [],\n" +
            "        \"EvaluationPeriods\": 3,\n" +
            "        \"DatapointsToAlarm\": 3,\n" +
            "        \"Threshold\": 2,\n" +
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
        File file = new File("/Users/puruagarwal/dev/IdeaProjects/flash-alerts/api-gateway/api-gateway-4xx-alarms.json");

        String[] resArr = API_RESOURCES.split("\n");

        try {
            // Step 2: Create a FileWriter object
            FileWriter writer = new FileWriter(file, true);

            // Step 3: Write data to the file
            writer.write("{\n" +
                    "  \"AWSTemplateFormatVersion\": \"2010-09-09\",\n" +
                    "  \"Resources\": {");

            for (int i = 0; i < resArr.length; i++) {
                String[] arr = resArr[i].split(" ");

                String method = arr[0];
                String apiRoute = arr[1];
                String resource = arr[2];

                resource = "APIGateway".concat(resource);
                resource = resource.concat("4xxErrorCritical");

                template = template.replace("{resource}", resource);
                template = template.replace("{resName}", apiRoute);
                template = template.replace("{method}", method);

                writer.write(template);

                template = template.replace(resource, "{resource}");
                template = template.replace(apiRoute, "{resName}");
                template = template.replace(method, "{method}");
            }

            writer.write("}\n" +
                    "}");

            // Step 4: Close the FileWriter object
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        System.out.println();
        System.out.println(resArr.length);
    }

}
