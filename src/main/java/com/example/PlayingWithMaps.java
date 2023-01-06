package com.example;

import java.util.HashMap;
import java.util.Map;

public class PlayingWithMaps {

    public static void main(String[] args) {
        Map<String, Integer > map = new HashMap<>();

        map.put("Puru", 1);

        Integer i = map.get("Sanchit") ;

        System.out.println(i);
    }

}
