package com.example;

public class SqlScriptGenerator {

    static String tables = "country_code\n" +
            "                                    | customer_info\n" +
            "                                    | customer_status\n" +
            "                                    | customer_session\n" +
            "                                    | email_provider\n" +
            "                                    | customer_email\n" +
            "                                    | referral\n" +
            "                                    | sms_template\n" +
            "                                    | vertical\n" +
            "                                    | waitlist_config\n" +
            "                                    | waitlist\n" +
            "                                    | devices\n" +
            "                                    | customer_interest\n" +
            "                                    | flash_account\n" +
            "                                    | push_notification_section\n" +
            "                                    | push_notification_template\n" +
            "                                    | push_notifications\n" +
            "                                    | customer_refresh_token\n" +
            "                                    | customer_ecommerce_insights\n" +
            "                                    | avatar";

    public static void main(String[] args) {
        String[] arr = tables.split("\\|");

//        System.out.println("create schema email;");

        String sql = "ALTER TABLE users.%s SET SCHEMA public;";

        for(String str: arr) {
            System.out.println(String.format(sql, str.trim()));
        }
    }
}
