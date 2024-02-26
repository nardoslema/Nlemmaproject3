/**
 * Author:- Nardos Lemma
 * CMSC 215
 * 02| 20| 24
 * This is my TripCost class that computes and returns the total trip cost.
 */
package com.example.project321;
public class TripCost {
    private final double distance;
    private final double gasolineCost;
    private final double gasMileage;
    private final double hotelCost;
    private final double foodCost;
    private final int noOfDays;
    private final double attractionsCost;
    private final String distUnit;
    private final String gasolineCostUnit;
    private final String gasMileageUnit;
// constructor that takes in fields
    public TripCost(double distance, double gasolineCost, double gasMileage, double hotelCost, double foodCost, int days, double attractionsCost, String distanceUnit, String gasolineCostUnit, String gasMileageUnit) {
        this.distance = distance;
        this.gasolineCost = gasolineCost;
        this.gasMileage = gasMileage;
        this.hotelCost = hotelCost;
        this.foodCost = foodCost;
        this.noOfDays = days;
        this.attractionsCost = attractionsCost;
        this.distUnit = distanceUnit;
        this.gasolineCostUnit = gasolineCostUnit;
        this.gasMileageUnit = gasMileageUnit;
    }

    //converting the gas mileage
    private double convertGasMileage(double mile, String unit) {
        return unit.equals("Miles per Gallon") ? mile : mile * 2.35215;
    }
// converts the distance
    private double convertDistance(double dist, String unit) {
        return unit.equals("Miles") ? dist : dist * 0.621371;
    }
    // Convert price gallon if necessary
    private double convertGasolineCost(double cost, String unit) {
        return unit.equals("Dollars per Gallon") ? cost : cost * 3.78541;
    }
    // this method will help in calculating the total cost
    public double calculateTotalCost() {
        double convertDistance = convertDistance(distance, distUnit);
        double convertedGasolineCost = convertGasolineCost(gasolineCost, gasolineCostUnit);
        double convertedGasMileage = convertGasMileage(gasMileage, gasMileageUnit);
        double conversion =(convertDistance / convertedGasMileage);
        double gasCost = conversion * convertedGasolineCost;

        double otherCosts = (hotelCost + foodCost) * noOfDays + attractionsCost;
        double totCost = gasCost + otherCosts;
        return Math.round(totCost * 100.0) / 100.0;
    }

}





