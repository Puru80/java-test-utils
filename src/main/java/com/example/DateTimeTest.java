package com.example;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeTest {

    public static void main(String[] args) {
        String date = "2022-11-18 16:22:27.992 +0530";

        DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS x");

        System.out.println(date);

        ZonedDateTime zonedDateTime = ZonedDateTime.parse(date, formatter);
        System.out.println("ZonedDateTime: " + zonedDateTime);

        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        System.out.println("ZonedDateTime1: " + zonedDateTime1);

        zonedDateTime = zonedDateTime.minusMonths(3);
        System.out.println("ZonedDateTime(-3 months): " + zonedDateTime);


        OffsetDateTime dateTime = OffsetDateTime.now();
        System.out.println("Offset" + dateTime);



    }
}
