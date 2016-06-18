package com.programit.week2;

/**
 * Created by Bas on 18/06/16.
 */
class TiltAWhirl extends Ride {
    void go (int nrOfTickets) {
        System.out.println("Oh nee, de spin. Als ik maar niet misselijk word!");
        updateCounters(nrOfTickets);
    }
}
