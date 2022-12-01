package com.example;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

public class Test {

    public static void main(String[] args) {
        Integer i = 5;
        Set<String> possibleStrings = new LinkedHashSet<>();
        possibleStrings.add("emailId");

        updateInt(i, possibleStrings);

//        for (String val : possibleStrings) {
//            System.out.println(val);
//        }
//        System.out.println(possibleStrings.hashCode());


        System.out.println(i.hashCode());
    }


    public static void updateInt(Integer i, Set<String> possibleStrings){
        i = 1;
        System.out.println(i.hashCode());
//        possibleStrings.add("Hello World!!!!");

//        System.out.println(possibleStrings.hashCode());
//        possibleStrings = new LinkedHashSet<>();
//        possibleStrings.add("updateInt(Integer i, Set<String> possibleStrings)");
//        System.out.println(possibleStrings.hashCode());
    }
}
