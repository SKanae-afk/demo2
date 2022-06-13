package com.example.regex_enum;

public enum Bagels {

    //bagels
    PLAIN("Plain"), SEEDS("Seeds"), CHEESE("Cheese"), YOGURT("Yogurt");

    private String brandname;
    private Bagels(String brand) {
        this.brandname = brand;
    }
}