/**
 * Author:- Nardos Lemma
 * CMSC 215
 * 02| 20| 24
 * This is my Project3 class that define the GUI
 */
package com.example.project321;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Project3 extends Application {
    private TextField distanceField, gasolineCostField, gasMileageField, daysField,hotelCostField, foodCostField, attractionsCostField, totalCostField;
    private ComboBox<String> distanceUnits, gasolineCostUnits, gasMileageUnits;

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        distanceField = new TextField();
        gasolineCostField = new TextField();
        gasMileageField = new TextField();
        daysField = new TextField();
        hotelCostField = new TextField();
        foodCostField = new TextField();
        attractionsCostField = new TextField();
        totalCostField = new TextField();
        totalCostField.setEditable(false); // Output field should not be editable

        distanceUnits = new ComboBox<>();
        distanceUnits.getItems().addAll("Miles ", "Kilometers");

        gasolineCostUnits = new ComboBox<>();
        gasolineCostUnits.getItems().addAll("Dollars/Gallon ", "Dollars/Liter");

        gasMileageUnits = new ComboBox<>();
        gasMileageUnits.getItems().addAll("Miles/Gallon", "Kilometers/Liter");
//button
        Button button = new Button("Calculate");
        button.setOnAction(e -> calculateTotalCost());

        gridPane.add(new Label("Distance:"), 0, 0);
        gridPane.add(distanceField, 1, 0);
        gridPane.add(distanceUnits, 2, 0);

        gridPane.add(new Label("Gasoline Cost:"), 0, 1);
        gridPane.add(gasolineCostField, 1, 1);
        gridPane.add(gasolineCostUnits, 2, 1);

        gridPane.add(new Label("Gas Mileage:"), 0, 2);
        gridPane.add(gasMileageField, 1, 2);
        gridPane.add(gasMileageUnits, 2, 2);

        gridPane.add(new Label("Number of Days:"), 0, 3);
        gridPane.add(daysField, 1, 3);

        gridPane.add(new Label("Hotel Cost:"), 0, 4);
        gridPane.add(hotelCostField, 1, 4);

        gridPane.add(new Label("Food Cost:"), 0, 5);
        gridPane.add(foodCostField, 1, 5);

        gridPane.add(new Label("Attractions Cost:"), 0, 6);
        gridPane.add(attractionsCostField, 1, 6);

        HBox actions = new HBox(10);
        actions.setAlignment(Pos.CENTER_RIGHT);
        actions.getChildren().add(button);

        gridPane.add(actions, 1, 7);

        gridPane.add(new Label("Total Cost:"), 0, 8);
        gridPane.add(totalCostField, 1, 8);

        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setTitle("Trip Cost Estimator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateTotalCost() {
        try {
            double distance = Double.parseDouble(distanceField.getText());
            double gasolineCost = Double.parseDouble(gasolineCostField.getText());
            double gasMileage = Double.parseDouble(gasMileageField.getText());
            int days = Integer.parseInt(daysField.getText());
            double hotelCost = Double.parseDouble(hotelCostField.getText());
            double foodCost = Double.parseDouble(foodCostField.getText());
            double attractionsCost = Double.parseDouble(attractionsCostField.getText());

            String distanceUnit = distanceUnits.getValue();
            String gasolineCostUnit = gasolineCostUnits.getValue();
            String gasMileageUnit = gasMileageUnits.getValue();

            TripCost tripCost = new TripCost(distance, gasolineCost, gasMileage, hotelCost, foodCost, days, attractionsCost, distanceUnit, gasolineCostUnit, gasMileageUnit);
            double totalCost = tripCost.calculateTotalCost();

            totalCostField.setText(String.format("%.2f", totalCost));
        } catch (NumberFormatException e) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Can you please enter valid numbers.");
            a.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}



