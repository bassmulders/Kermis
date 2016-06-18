package com.programit.week2;

import java.util.ArrayList;

/**
 * Created by Bas on 13-6-2016.
 */
abstract class Attraction {

    private String name;
    private AttractionType type;
    private int price; // store price in cents, so whole number
    //private Person owner = new Person();
    //private ArrayList<Person> employees = new ArrayList<Person>();
    private static int totalTurnover = 0;
    private static int attractionCounter = 0;
    private int ID;

    Attraction() {
        attractionCounter = getAttractionCounter() + 1;
    }

    static int getTotalTurnover() {
        return totalTurnover;
    }

    static void addTurnover(int turnover) {
        totalTurnover += turnover;
    }

    static int getAttractionCounter() {
        return attractionCounter;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    protected AttractionType getType() {
        return type;
    }

    protected void setType(AttractionType type) {
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
