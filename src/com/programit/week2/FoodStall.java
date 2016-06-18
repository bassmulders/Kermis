package com.programit.week2;

/**
 * Created by Bas on 13-6-2016.
 */
class FoodStall extends Attraction {
    private static double foodStallsTurnover = 0.0; // Keep track of the total food turnover.
    //private static int foodStallCounter = 0; // Count the number of FoodStall objects
    private static int totalConsumptionCounter = 0; // Count the total number of consumptions sold.
    private int consumptionCounter = 0; // Count the number of consumptions sold at this stall
    private double turnover = 0.0; // Keep track of the turnover for this FoodStall

    FoodStall() {
        this.setType(AttractionType.FOOD);
    }
    //FoodStall(String name, int ID, double consumptionPrice) {
    //    this.setType(AttractionType.FOOD);
    //    this.setName(name);
    //    this.setID(ID);
    //    this.setPrice(consumptionPrice);
    //    //foodStallCounter++;
    //}

    static double getFoodStallsTurnover() {
        return foodStallsTurnover;
    }

    static int getTotalConsumptionCounter() {
        return totalConsumptionCounter;
    }

    double getTurnover() {
        return turnover;
    }

    int getConsumptionCounter() {
        return consumptionCounter;
    }

    void eat() {
        System.out.println("Lekker! We nemen iets te eten bij de " + this.getName() + ".");
        totalConsumptionCounter++; // Update the number of consumptions sold at all stalls combined
        this.consumptionCounter = this.getConsumptionCounter() + 1; // Update the number of consumptions sold at this stall
        this.turnover = this.getTurnover() + this.getPrice(); // Update the turnover of this stall
        foodStallsTurnover += this.getPrice(); // Update the turnover over all stalls combined
    }

}
