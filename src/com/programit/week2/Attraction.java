package com.programit.week2;

/**
 * Created by Bas on 13-6-2016.
 */
abstract class Attraction {

    private String name;
    private AttractionType type;
    private int price; // store price in cents, so whole number
    private static int totalTurnover = 0;
    private int ID;

    static int getTotalTurnover() {
        return totalTurnover;
    }

    static void addTurnover(int turnover) {
        totalTurnover += turnover;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    AttractionType getType() {
        return type;
    }

    void setType(AttractionType type) {
        this.type = type;
    }

    int getID() {
        return ID;
    }

    void setID(int ID) {
        this.ID = ID;
    }

    int getPrice() {
        return price;
    }

    void setPrice(int price) {
        this.price = price;
    }
}
