package com.example;

public class SqlScriptGenerator {

    static String tables = "";

    public static void main(String[] args) {
        String[] arr = tables.split("\\|");

        System.out.println("create schema email;");

        String sql = "ALTER TABLE %s SET SCHEMA email;";

        for(String str: arr) {
            System.out.println(String.format(sql, str.trim()));
        }
    }
}
