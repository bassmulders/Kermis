package com.programit.week2;

/**
 * Created by Bas on 16/06/16.
 */
class HauntedHouse extends Ride  {
    void go(int nrOfTickets) {
        System.out.println("Het spookhuis is niet voor mensen met een zwak hart!");
        updateCounters(nrOfTickets);
    }
}
