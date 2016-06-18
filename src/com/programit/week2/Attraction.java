package com.programit.week2;

import java.util.ArrayList;

/**
 * Created by Bas on 13-6-2016.
 */
abstract class Attraction {

    private String name;
    private AttractionType type;
    private double price;
    //private Person owner = new Person();
    //private ArrayList<Person> employees = new ArrayList<Person>();
    private static double totalTurnover = 0.0;
    private static int attractionCounter = 0;
    private int ID;

    Attraction() {
        attractionCounter = getAttractionCounter() + 1;
    }

    static double getTotalTurnover() {
        return totalTurnover;
    }

    static void addTurnover(double turnover) {
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

    double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }
}
