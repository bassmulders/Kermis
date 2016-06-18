package com.programit.week2;

/**
 * Created by Bas on 18/06/16.
 * Frietkraam
 */
class FrenchFries extends FoodStall {
    void eat(int nrOfOrders) {
        System.out.println("Lekker! Frietje met zonder satésaus.");
        updateCounters(nrOfOrders);
    }
}
