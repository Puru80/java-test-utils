package com.example;

import com.example.models.ClassificationStrategy;
import com.google.gson.Gson;

import java.util.List;

public class ClassificationStrategyTest {

    public static void main(String[] args) {
        ClassificationStrategy classificationStrategy = new ClassificationStrategy();

        classificationStrategy.setName("ClassificationStrategy Object");
        classificationStrategy.setEmailIds(List.of("puru.agar99@gmaill.com", "example@gmail.com"));

//        System.out.println(classificationStrategy);

        Gson gson = new Gson();
        System.out.println(gson.toJson("Puru"));
    }
}
