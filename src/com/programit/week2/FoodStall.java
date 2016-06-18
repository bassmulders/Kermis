package com.programit.week2;

/**
 * Created by Bas on 13-6-2016.
 */
abstract class FoodStall extends Attraction {
    private static int foodStallsTurnover = 0; // Keep track of the total food turnover.
    private static int totalConsumptionCounter = 0; // Count the total number of consumptions sold.
    private int turnover = 0; // Keep track of the turnover for this FoodStall
    private int consumptionCounter = 0; // Count the number of consumptions sold at this stall

    FoodStall() {
        this.setType(AttractionType.FOOD);
    }

    abstract void eat(int nrOfOrders);

    static int getFoodStallsTurnover() {
        return foodStallsTurnover;
    }

    static int getTotalConsumptionCounter() {
        return totalConsumptionCounter;
    }

    int getTurnover() {
        return turnover;
    }

    int getConsumptionCounter() {
        return consumptionCounter;
    }

    void updateCounters(int nrOfOrders) {
        consumptionCounter += nrOfOrders; // Update the number of consumptions sold at this stall
        totalConsumptionCounter += nrOfOrders; // Update the number of consumptions sold at all stalls combined
        turnover += nrOfOrders * this.getPrice(); // Update the turnover of this stall
        foodStallsTurnover += nrOfOrders * this.getPrice(); // Update the turnover over all stalls combined
        Attraction.addTurnover(nrOfOrders * this.getPrice());
    }
}
