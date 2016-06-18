package com.programit.week2;

/**
 * Created by Bas on 13-6-2016.
 */
abstract class Ride extends Attraction {
    private static int ridesTurnover = 0; // Keep track of the total turnover of all Ride objects combined
    private static int totalTicketCounter = 0; // Count the total number of tickets sold.
    private int turnover = 0; // Keep track of the turnover for this instance of Ride
    private int ticketCounter = 0; // Count the number of tickets sold for this Ride

    Ride() {
        this.setType(AttractionType.NON_FOOD);
    }

    abstract void go(int nrOfTickets);

    static int getRidesTurnover() {
        return ridesTurnover;
    }

    static int getTotalTicketCounter() {
        return totalTicketCounter;
    }

    int getTicketCounter() {
        return ticketCounter;
    }

    int getTurnover() {
        return turnover;
    }

    void updateCounters(int nrOfTickets) {
        ticketCounter += nrOfTickets; // Update the number of tickets sold at this Ride
        totalTicketCounter += nrOfTickets; // Update the total number of tickets over all Rides combined
        turnover += nrOfTickets * this.getPrice(); // Update the turnover of this Ride
        ridesTurnover += nrOfTickets * this.getPrice(); // Update the turnover over all Rides combined
        Attraction.addTurnover(nrOfTickets * this.getPrice());
    }

}
