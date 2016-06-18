package com.programit.week2;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Bas on 13-6-2016.
 */
class Fair {
    private String name;
    private ArrayList<Attraction> attractions = new ArrayList<Attraction>();
    private Scanner sc = new Scanner(System.in);

    Fair(String name) {
        setName(name);
        // Build the attractions
        buildAttractions();
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
    // Start the fair
    void run() {
        InputParser ip = new InputParser();
        boolean keepRunning = true;
        System.out.println("Welkom op " + getName() + "! Hier bevinden zich de volgende attracties:");
        while (keepRunning) {
            for (Attraction a : attractions) {
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
                    // TODO check if visitAttraction should be able to cause a program exit.
                    keepRunning = visitAttraction(ip.getParseResult());
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
        /*
        buildAttraction(AttractionType.NON_FOOD, "Botsauto's", 1, 2.5);
        buildAttraction(AttractionType.NON_FOOD, "Spin", 2, 2.25);
        buildAttraction(AttractionType.NON_FOOD, "Spiegelpaleis", 3, 2.75);
        buildAttraction(AttractionType.NON_FOOD, "Spookhuis", 4, 3.2);
        buildAttraction(AttractionType.NON_FOOD, "Hawaii", 5, 2.9);
        buildAttraction(AttractionType.NON_FOOD, "Ladderklimmen", 6, 5.0);
        buildAttraction(AttractionType.FOOD, "Oliebollenkraam", 11, 4.0);
        buildAttraction(AttractionType.FOOD, "Frietkraam", 22, 3.45);
        buildAttraction(AttractionType.FOOD, "Mueslikraam", 33, 9.0);
        buildAttraction(AttractionType.FOOD, "Shoarmatent", 44, 5.15);
        buildAttraction(AttractionType.FOOD, "Snoepkraam", 55, 1.25);

        attractions.add(new BumperCars("Botsauto's", 1, 250));
        attractions.add(new FerrisWheel("Reuzenrad", 2, 225));
        attractions.add(new HauntedHouse());
        attractions.add(new Caroussel());
        attractions.add(new RollerDerby());
        attractions.add(new FishAndChips());
        */

        buildAttraction(new BumperCars(),     "Botsauto's",       1, 250);
        buildAttraction(new TiltAWhirl(),     "Spin",             2, 225);
        buildAttraction(new MirrorPalace(),   "Spiegelpaleis",    3, 275);
        buildAttraction(new HauntedHouse(),   "Spookhuis",        4, 320);
        buildAttraction(new Hawaii(),         "Hawaii",           5, 290);
        buildAttraction(new Ladders(),        "Ladder klimmen",   6, 500);
        buildAttraction(new OilyBalls(),      "Oliebollenkraam", 11, 400);
        buildAttraction(new FrenchFries(),    "Frietkraam",      22, 345);
        buildAttraction(new Granola(),    "Mueslikraam",      33, 900);
        buildAttraction(new Shawarma(),    "Shoarmatent",      22, 500);
        buildAttraction(new FrenchFries(),    "Snoepkraam",      22, 500);




        //System.out.println(Attraction.getAttractionCounter());
        //System.out.println(Ride.getRideCounter());
        //System.out.println(FoodStall.getFoodStallCounter());
    }

    // Build an attraction on the fair.
    private void buildAttraction(Attraction attraction, String name, int ID, int price) {
        // Create a new element in the array list
        /*switch (type) {
            case FOOD:
                //attractions.add(new FoodStall(name, ID, price));
                attractions.add(new FoodStall());
                break;
            case NON_FOOD:
                //attractions.add(new Ride(name, ID, price));
                attractions.add(new Ride());
                break;
        }*/
        attractions.add(attraction);
        attractions.get(attractions.size()-1).setName(name);
        attractions.get(attractions.size()-1).setID(ID);
        attractions.get(attractions.size()-1).setPrice(price);
    }

    private boolean visitAttraction(int attractionID) {
        for (Attraction a : attractions) {
            if (a.getID() == attractionID) {
                switch (a.getType()) {
                    case FOOD:
                        FoodStall fs = (FoodStall) a;
                        fs.eat();
                        return true;
                    case NON_FOOD:
                        Ride r = (Ride) a;
                        r.go();
                        return true;
                    default:
                        return false;
                }
            }
        }
        return false;
    }

    private void printTurnover() {
        for (Attraction a : attractions) {
            switch (a.getType()) {
                case FOOD:
                    FoodStall fs = (FoodStall) a;
                    System.out.printf("%3d. %-21s €%.2f\n", fs.getID(), fs.getName(), (double) fs.getTurnover()/100);
                    break;
                case NON_FOOD:
                    Ride r = (Ride) a;
                    System.out.printf("%3d. %-21s €%.2f\n", r.getID(), r.getName(), (double) r.getTurnover()/100);
                    break;
            }

        }
        System.out.printf("Subtotal turnover Food:     €%.2f\n", (double) FoodStall.getFoodStallsTurnover()/100);
        System.out.printf("Subtotal turnover Non-Food: €%.2f\n", (double) Ride.getRidesTurnover()/100);
    }

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
        System.out.printf("Total number of consumptions:  %3d\n", FoodStall.getTotalConsumptionCounter());
        System.out.printf("Total number of tickets:       %3d\n", Ride.getTotalTicketCounter());
    }
}
