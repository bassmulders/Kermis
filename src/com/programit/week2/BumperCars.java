package com.programit.week2;

/**
 * Created by Bas on 16/06/16.
 */
class BumperCars extends Ride  {
    void go(int nrOfTickets) {
        System.out.println("Zin je kunstgebit vast? We gaan in de botsauto's.");
        updateCounters(nrOfTickets);
    }
}
