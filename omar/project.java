package org.example.demo7;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

//import java.awt.*;
//import javax.naming.InvalidNameException;
import java.io.IOException;

// Custom exception for invalid name input
class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

// Custom exception for validation errors
class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

public class HelloApplication extends Application {
    private static Customer customer = new Customer();
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Checkout Window");

        // Create fields for customer information
        TextField nameField = new TextField();
        nameField.setStyle("-fx-border-color: #070707; -fx-border-width: 1px;");
        nameField.setPromptText("Full Name");

        TextField addressField = new TextField();
        addressField.setStyle("-fx-border-color: #070707; -fx-border-width: 1px;");
        addressField.setPromptText("Address");

        TextField emailField = new TextField();
        emailField.setStyle("-fx-border-color: #070707; -fx-border-width: 1px;");
        emailField.setPromptText("Email");

        // payment method buttons
        Button payOnDeliveryButton = new Button("Pay On Delivery");
        Button creditButton = new Button("Pay with Credit");

        // Create a layout and add components
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(55, 0, 0, 110));

        gridPane.add(new Label("Name:"), 0, 0);
        gridPane.add(nameField, 1, 0);

        gridPane.add(new Label("Address:"), 0, 1);
        gridPane.add(addressField, 1, 1);

        gridPane.add(new Label("Email:"), 0, 2);
        gridPane.add(emailField, 1, 2);

        VBox buttonBox = new VBox(10);
        buttonBox.getChildren().addAll(payOnDeliveryButton, creditButton);
        gridPane.add(buttonBox, 1, 3);

        // Event handling for "Pay on Delivery"
        payOnDeliveryButton.setOnAction(event -> {
            try {
                validateFields(nameField.getText(), addressField.getText(), emailField.getText()); // Validate fields
                validateName(nameField.getText());
                customer.setCustomerName(nameField.getText()); // Update Customer with user input
                customer.setCustomerAddress(addressField.getText());
                customer.setCustomerEmail(emailField.getText());

                if(addressField.getText().contains("cairo")||addressField.getText().contains("Cairo")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Cash Payment");
                    alert.setHeaderText("Thank You For Shopping With Us");
                    alert.setContentText("Your Delivery fees is $50");
                    alert.showAndWait();
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Cash Payment");
                    alert.setHeaderText("Thank You For Shopping With Us");
                    alert.setContentText("Your Delivery fees is $80");
                    alert.showAndWait();
                }

            }catch (ValidationException | InvalidNameException e){
                showError(e.getMessage());
            }

        });

        // Event handling for "Pay with Credit" (opens a new window)
        creditButton.setOnAction(event -> {
            try{
                validateFields(nameField.getText(), addressField.getText(), emailField.getText()); // Validate fields
                validateName(nameField.getText());
                // Update the Customer instance with user input
                customer.setCustomerName(nameField.getText());
                customer.setCustomerAddress(addressField.getText());
                customer.setCustomerEmail(emailField.getText());

                Stage creditStage = new Stage();
                creditStage.setTitle("Credit Card Information");

                GridPane creditGrid = new GridPane();
                creditGrid.setVgap(10);
                creditGrid.setHgap(10);


                TextField cardHolderField = new TextField();
                cardHolderField.setStyle("-fx-border-color: #070707; -fx-border-width: 1px;");
                cardHolderField.setPromptText("Card Holder Name");

                PasswordField cvvField = new PasswordField();
                cvvField.setStyle("-fx-border-color: #070707; -fx-border-width: 1px;");
                cvvField.setPromptText("CVV");

                creditGrid.add(new Label("Card Holder Name:"), 0, 0);
                creditGrid.add(cardHolderField, 1, 0);

                creditGrid.add(new Label("CVV:"), 0, 1);
                creditGrid.add(cvvField, 1, 1);

                Button confirmButton = new Button("Confirm");
                creditGrid.add(confirmButton, 1, 2);

                confirmButton.setOnAction(e -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Payment Confirmation");
                    alert.setHeaderText("Thank You For Shopping With Us");
                    alert.setContentText("Payment is being processed...");
                    alert.showAndWait();
                    creditStage.close();
            });
            creditGrid.setPadding(new Insets(30, 0, 0, 30));
            Scene creditScene = new Scene(creditGrid, 350, 200);
            creditStage.setScene(creditScene);
            creditStage.initModality(Modality.APPLICATION_MODAL); // Makes this window modal
            creditStage.showAndWait();
            } catch (ValidationException | InvalidNameException e) {
                showError(e.getMessage());
            }
        });

        // Create a scene and set it on the stage
        Scene scene = new Scene(gridPane, 450, 350);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    // Validate if any of the fields are empty
    private void validateFields(String name, String address, String email) throws ValidationException {
        if (name.isEmpty() || address.isEmpty() || email.isEmpty()) {
            throw new ValidationException("All fields must be filled in.");
        }
    }

    // Function to validate the name field
    private void validateName(String name) throws InvalidNameException {
        if (name.matches(".*\\d.*")) { // Check if the name contains any digit
            throw new InvalidNameException("Name should not contain numbers.");
        }
    }

    // Function to show error message
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setHeaderText("Input Validation Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
        System.out.println(customer.getCustomerName());
        System.out.println(customer.getCustomerAddress());
        System.out.println(customer.getCustomerEmail());

    }
}
