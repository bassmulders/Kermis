package com.programit.week2;

/**
 * Created by Bas on 13-6-2016.
 */
class Ride extends Attraction {
    private static double ridesTurnover = 0.0; // Keep track of the total turnover of all Ride objects combined
    //private static int rideCounter = 0; // Count the number of Ride objects
    private static int totalTicketCounter = 0; // Count the total number of tickets sold.
    private int ticketCounter = 0; // Count the number of tickets sold for this Ride
    private double turnover = 0.0; // Keep track of the turnover for this Ride


    Ride() {
        this.setType(AttractionType.NON_FOOD);
    }

    //Ride (String name, int ID, double ticketPrice) {
    //    this.setType(AttractionType.NON_FOOD);
    //    this.setID(ID);
    //    this.setName(name);
    //    this.setPrice(ticketPrice);
    //    //rideCounter++;
    //}

    static double getRidesTurnover() {
        return ridesTurnover;
    }

    static int getTotalTicketCounter() {
        return totalTicketCounter;
    }

    int getTicketCounter() {
        return ticketCounter;
    }

    double getTurnover() {
        return turnover;
    }

    void go() {
        System.out.println("Leuk! We gaan in de " + this.getName() + ".");
        this.ticketCounter++; // Update the number of tickets sold at this Ride
        totalTicketCounter++; // Update the total number of tickets over all Rides combined
        this.turnover = this.getTurnover() + this.getPrice(); // Update the turnover of this Ride
        ridesTurnover += this.getPrice(); // Update the turnover over all Rides combined
    }

}
