package com.programit.week2;

/**
 * Created by Bas on 18/06/16.
 */
class Granola extends FoodStall {
    void eat(int nrOfOrders) {
        System.out.println("Muesli met yoghurt.");
        updateCounters(nrOfOrders);
    }
}
