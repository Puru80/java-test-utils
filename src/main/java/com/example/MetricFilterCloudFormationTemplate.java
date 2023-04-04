package com.example;

public class MetricFilterCloudFormationTemplate {

    public static String apiUserResources = "/user/login POST UserLogin\n" +
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

    public static final String API_RESOURCES = "GET /user/gmail-consent UserGmailConsent\n" +
            "POST /user/flash/reserve/send-otp FlashReserveSendOTP\n" +
            "POST /tracking/trackingMore/callback TrackingMoreCallback\n" +
            "GET /v1/ops/ignore/promotional OpsIgnorePromotionalV1\n" +
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
            "GET /v1/ops/phrases/strategy OpsPhrasesStrategyV1\n" +
            "GET /v1/campaigns/streaks CampaignsStreaksV1\n" +
            "POST /v1/ops/phrases/{id}/remove OpsPhrasesRemoveV1\n" +
            "POST /v1/ops/sender OpsSenderV1Post\n" +
            "GET /entity EntityAPI\n" +
            "POST /v1/rewards/redeem RewardsRedeemV1\n" +
            "GET /v1/ops/sender/{id}/classifier OpsSenderClassifierV1\n" +
            "GET /v1/ops/sender/{sender}/domain OpsSenderDomainV1Get\n" +
            "GET /v1/ops/senders OpsSendersV1\n" +
            "GET /v1/ops/sender/address OpsSenderAddressV1\n" +
            "GET /v1/ops/sender OpsSenderV1Get\n" +
            "GET /v1/ops/ignore/personal OpsIgnorePersonalV1\n" +
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
            "POST /v1/ops/sender/domain OpsSenderDomainV1Post\n" +
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

    public static String resourceTemplate = "\"{resName} 404MetricFilter\": {\n" +
            "      \"Type\": \"AWS::Logs::MetricFilter\",\n" +
            "      \"Properties\": {\n" +
            "        \"LogGroupName\": \"/aws/ApiGateway/FlashAppGatewayLogs\",\n" +
            "        \"FilterPattern\": \"{$.routeKey = \\\"{method} {api}\\\" && $.status =  404}\",\n" +
            "        \"FilterName\": \"{resName} 404MetricFilter\", \n" +
            "        \"MetricTransformations\": [\n" +
            "          {\n" +
            "            \"DefaultValue\": 0,\n" +
            "            \"MetricValue\": \"1\",\n" +
            "            \"MetricNamespace\": \"FlashAppGateway/ 404s\",\n" +
            "            \"MetricName\": \"{api} -  404Count\",\n" +
            "            \"Unit\": \"Count\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    }, ";

    public static void main(String[] args) {
        String[] resArr = API_RESOURCES.split("\n");

        for (int i = 0; i < resArr.length; i++) {
            String[] arr = resArr[i].split(" ");

            String apiRoute = arr[1];
            String method = arr[0];
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
