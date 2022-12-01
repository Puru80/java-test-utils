package com.example;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.logging.Logger;

public class RegexTest {

    public static final Logger logger = Logger.getLogger("RegexTest");

    public static void main(String[] args) {
        System.out.println(isEmailAddressIgnorable("no-reply@alerts.sbi.co.in"));
    }

    private static boolean isEmailAddressIgnorable(String emailId) {
        Set<String> possibleStrings = new LinkedHashSet<>();
        possibleStrings.add(emailId);

        String fromAddressDomainStart = StringUtils.substringBefore(emailId, "@");
        fetchEmailAliasRegexPattern(fromAddressDomainStart, possibleStrings);

        String fromAddressDomainEnd = StringUtils.substringAfter(emailId, "@");
        fetchEmailDomainRegexPattern(fromAddressDomainEnd, possibleStrings);

        List<String> list = List.of("@*.sbi.*");

        for (String val : possibleStrings) {
            System.out.println(val);
        }

        /*for (String val : possibleStrings) {
            if (list.contains(val)) {
                System.out.println(val);
                return true;
            }

        }
*/
        return false;
    }

    private static void fetchEmailAliasRegexPattern(String emailPart, Set<String> possibleStrings) {
        String[] fromAddressDomainStart = emailPart.split("\\.");
        String domain = fromAddressDomainStart[0];
        possibleStrings.add(domain + ".*");
        possibleStrings.add(domain + ".*@");

        for (int i = 1; i < fromAddressDomainStart.length; i++) {
            domain = domain.concat(".".concat(fromAddressDomainStart[i]));

            possibleStrings.add(domain + ".*");
            possibleStrings.add(domain + ".*@");
        }

        possibleStrings.add(domain + "@*");
    }

    private static void fetchEmailDomainRegexPattern(String emailPart, Set<String> possibleStrings) {
        String[] fromAddressDomainStart = emailPart.split("\\.");
        String domain = fromAddressDomainStart[0];
        possibleStrings.add("@" + domain + ".*");

        for (int i = 1; i < fromAddressDomainStart.length; i++) {
            domain = domain.concat(".".concat(fromAddressDomainStart[i]));

            possibleStrings.add("@" + domain + ".*");
            possibleStrings.add("*@" + domain + ".*");
        }

        possibleStrings.add("*@" + domain);

        domain = fromAddressDomainStart[fromAddressDomainStart.length - 1];
        possibleStrings.add("*." + domain);
        possibleStrings.add("@*." + domain);

        for (int i = fromAddressDomainStart.length - 2; i >= 0; i--) {
            domain = fromAddressDomainStart[i].concat(".".concat(domain));

            possibleStrings.add("*." + domain);
            possibleStrings.add("@*." + domain);
        }

        possibleStrings.add("@" + domain);

        for (int i = 0; i < fromAddressDomainStart.length - 1; i++) {
            String strNew = "@*." + fromAddressDomainStart[i] + ".*";
            possibleStrings.add(strNew);
        }
    }
}
