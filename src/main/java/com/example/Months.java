package com.example;

import java.time.Instant;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Months {

    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_OFFSET_TIME;
    public static final String timeStringAfter = "08:00:00+05:30";
    public static final String timeStringBefore = "23:00:00+05:30";

    public static void main(String[] args) {
        System.out.println(Month.of(1).name());

        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        System.out.println("OffsetTime: " + offsetDateTime.toOffsetTime().getOffset());

        System.out.println(isDayTimeOrder(offsetDateTime.toOffsetTime()));
    }

    private static boolean isDayTimeOrder(OffsetTime orderPlacedTime) {
        if (orderPlacedTime != null) {
            return (orderPlacedTime.isAfter(OffsetTime.parse(timeStringAfter, dateTimeFormatter))
                    && orderPlacedTime.isBefore(OffsetTime.parse(timeStringBefore, dateTimeFormatter)));
        }

        return true;
    }
}
