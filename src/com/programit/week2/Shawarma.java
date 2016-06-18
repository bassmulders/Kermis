package com.programit.week2;

/**
 * Created by Bas on 18/06/16.
 */
class Shawarma extends FoodStall {
    void eat(int nrOfOrders) {
        System.out.println("Shoarma met knoflooksaus");
        updateCounters(nrOfOrders);
    }
}
