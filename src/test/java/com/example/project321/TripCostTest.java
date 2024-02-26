/**
 * Author:- Nardos Lemma
 * CMSC 215
 * 02| 20| 24
 * This is my TripCostTest class that tests tripCost class.
 */
package com.example.project321;

import static org.junit.Assert.*;

public class TripCostTest {

    TripCost cost1 = new TripCost(200, 3.0, 20, 60, 30, 7, 150, "Kilometers", "Dollars per Liter", "Kilometers per Liter");
    TripCost cost2 = new TripCost(150, 2.0, 25, 40, 25, 4, 120, "Miles", "Dollars per Gallon", "Miles per Gallon");
    @org.junit.Test
    public void calculateTotalCost() {

        double expectedTotalCost1= 810.0;
        double expectedTotalCost2 = 392;
        assertEquals(expectedTotalCost1, cost1.calculateTotalCost(), 0.01);
        assertEquals(expectedTotalCost2, cost2.calculateTotalCost(), 0.01);

    }

}