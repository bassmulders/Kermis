package com.programit.week2;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Bas on 13-6-2016.
 */
class Fair {
    private String name;
    private ArrayList<Attraction> attractions = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    Fair(String name) {
        this.name = name;
        // Build the attractions
        buildAttractions();
    }

    String getName() {
        return name;
    }

    // Start the fair
    void run() {
        InputParser ip = new InputParser();
        boolean keepRunning = true;
        System.out.println("Welkom op " + getName() + "! Hier bevinden zich de volgende attracties:");
        while (keepRunning) {
            System.out.println("----- Voor de bezoekers: -----");            for (Attraction a : attractions) {
                System.out.printf("%3d. %-15s (€%.2f)\n", a.getID(), a.getName(), ((double) a.getPrice()/100));
            }
            System.out.println("-- Voor de kermisdirecteur: --");
            System.out.println("  o. Omzet bekijken");
            System.out.println("  k. Kaartverkoop bekijken");
            System.out.println("  x. Kermis sluiten");
            System.out.print("Kies de attractie waar u gebruik van wil maken, of een van de andere opties: ");
            ip.parse(sc.nextLine());
            if (ip.getParseResult() != -1) {
                if (ip.getParseResult() < 100) {
                    // TODO reconsider if visitAttraction should be able to cause a program exit.
                    keepRunning = visitAttraction(ip.getParseResult(), ip.getArgument());
                } else {
                    switch (ip.getParseResult()) {
                        case 101: // Print turnover
                            printTurnover();
                            break;
                        case 102: // Print sales
                            printSales();
                            break;
                        case 103: // Exit fair, i.e. end program
                            keepRunning = false;
                            break;
                    }
                }
            }
        }
    }


    // Build all attractions.
    private void buildAttractions() {
        buildAttraction(new BumperCars(),   "Botsauto's",       1, 250);
        buildAttraction(new TiltAWhirl(),   "Spin",             2, 225);
        buildAttraction(new MirrorPalace(), "Spiegelpaleis",    3, 275);
        buildAttraction(new HauntedHouse(), "Spookhuis",        4, 320);
        buildAttraction(new Hawaii(),       "Hawaii",           5, 290);
        buildAttraction(new Ladders(),      "Ladder klimmen",   6, 500);
        buildAttraction(new OilyBalls(),    "Oliebollenkraam", 11, 400);
        buildAttraction(new FrenchFries(),  "Frietkraam",      22, 345);
        buildAttraction(new Granola(),      "Mueslikraam",     33, 900);
        buildAttraction(new Shawarma(),     "Shoarmatent",     44, 515);
        buildAttraction(new Candy(),        "Snoepkraam",      55, 125);
        //System.out.println(Attraction.getAttractionCounter());
        //System.out.println(Ride.getRideCounter());
        //System.out.println(FoodStall.getFoodStallCounter());
    }

    // Build an attraction on the fair.
    private void buildAttraction(Attraction attraction, String name, int ID, int price) {
        // Create a new element in the array list
        attractions.add(attraction);
        attractions.get(attractions.size()-1).setName(name);
        attractions.get(attractions.size()-1).setID(ID);
        attractions.get(attractions.size()-1).setPrice(price);
    }

    // Visit an attraction to take a ride or buy a consumption.
    private boolean visitAttraction(int attractionID, int nrOfTickets) {
        for (Attraction a : attractions) {
            if (a.getID() == attractionID) {
                switch (a.getType()) {
                    case FOOD:
                        FoodStall fs = (FoodStall) a;
                        fs.eat(nrOfTickets);
                        return true;
                    case NON_FOOD:
                        Ride r = (Ride) a;
                        r.go(nrOfTickets);
                        return true;
                    default:
                        return false;
                }
            }
        }
        return false;
    }

    // For each attraction print the turnover, as well as the subtotals
    // of food and non-food and finally also the overall total.
    private void printTurnover() {
        for (Attraction a : attractions) {
            switch (a.getType()) {
                case FOOD:
                    FoodStall fs = (FoodStall) a;
                    System.out.printf("%3d. %-21s €%3.2f\n", fs.getID(), fs.getName(), (double) fs.getTurnover()/100);
                    break;
                case NON_FOOD:
                    Ride r = (Ride) a;
                    System.out.printf("%3d. %-21s €%3.2f\n", r.getID(), r.getName(), (double) r.getTurnover()/100);
                    break;
            }
        }
        System.out.printf("Subtotaal omzet Food:      €%3.2f\n", (double) FoodStall.getFoodStallsTurnover()/100);
        System.out.printf("Subtotaal omzet Non-Food:  €%3.2f\n", (double) Ride.getRidesTurnover()/100);
        System.out.printf("Totaal omzet:              €%3.2f\n", (double) Attraction.getTotalTurnover()/100);
        System.out.print("Druk enter om terug te gaan naar het hoofdmenu");
        sc.nextLine();
    }

    // For each attraction print the number of sold tickets or consumptions, as well as the subtotals
    // of food and non-food and finally also the overall total.
    private void printSales() {
        for (Attraction a : attractions) {
            switch (a.getType()) {
                case FOOD:
                    FoodStall fs = (FoodStall) a;
                    System.out.printf("%3d. %-21s %3d\n", fs.getID(), fs.getName(), fs.getConsumptionCounter());
                    break;
                case NON_FOOD:
                    Ride r = (Ride) a;
                    System.out.printf("%3d. %-21s %3d\n", r.getID(), r.getName(), r.getTicketCounter());
                    break;
            }
        }
        System.out.printf("Totaal aantal consumpties:  %3d\n", FoodStall.getTotalConsumptionCounter());
        System.out.printf("Totaal aantal kaartjes:     %3d\n", Ride.getTotalTicketCounter());
        System.out.print("Druk enter om terug te gaan naar het hoofdmenu");
        sc.nextLine();    }
}
