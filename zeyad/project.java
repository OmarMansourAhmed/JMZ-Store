package org.example.shoppingcart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    Stage window;
    Scene scene, cartScene, paymentScene;
    TableView<Product> table;
    TextField userQuantityInput;
    ArrayList<CartItem> cart;
    GridPane gridPane;
    HBox shoppingCartH;

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("MJZ");

        //Name Column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price Column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Quantity Column
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //userQuantity Input
        userQuantityInput = new TextField();
        userQuantityInput.setPromptText("0");
        userQuantityInput.setMinWidth(100);

        //userQuantity Label
        Label userQauntityLabel = new Label("Select the product and enter the quantity you want here");

        //Add to cart Button
        Button addToCartButton = new Button("Add To Cart");
        addToCartButton.setOnAction(e -> addToCartClicked()); //add the selected item to a new scene called Shopping Cart

        //This button change the scene to the cart scene
        Button nextButton = new Button("Go To Cart");
        nextButton.setOnAction(e -> {
            window.setScene(cartScene);
        });

        //Back button in cart scene
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.setScene(scene));

        //Back button in Payment scene
        Button backButton2 = new Button("Back");
        backButton2.setOnAction(e -> window.setScene(cartScene));

        //Go to payment button
        Button goToPaymentButton = new Button("Go To Payment");
        goToPaymentButton.setOnAction(e -> window.setScene(paymentScene));

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(userQauntityLabel, userQuantityInput);


        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(10, 10, 10, 10));
        hBox2.setSpacing(10);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(addToCartButton, nextButton);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox, hBox2);



        //Grid Pane in the cart scene

        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);
        GridPane.setConstraints(backButton, 10, 25);
        GridPane.setConstraints(goToPaymentButton, 15, 25);
        //GridPane.setConstraints(cartTable,0,0);
        gridPane.getChildren().addAll(backButton,goToPaymentButton);



        cartScene = new Scene(gridPane, 600, 600);

        //paymentScene= new Scene(vBox1,600,600);

        //By mansoor
        VBox vv = new VBox(10);
        paymentScene = new Scene(vv, 600, 600);
        vv.getChildren().addAll(backButton2);
        ///********************************************************************///

        scene = new Scene(vBox, 600, 600);

        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch();
    }

    public ObservableList<Product> getProduct() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 10000.00, 20));
        products.add(new Product("Coffee", 55.00, 15));
        products.add(new Product("Mac Book", 20000.00, 10));
        products.add(new Product("NotePad", 3000.00, 5));
        return products;
    }

    public void addToCartClicked() {
        // Get the selected product
        Product selectedProduct = table.getSelectionModel().getSelectedItem();
        if (selectedProduct == null) {
            System.out.println("Please select a product first.");
            return;
        }

        // Get the entered quantity
        int userQuantity;
        try {
            userQuantity = Integer.parseInt(userQuantityInput.getText());
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity, Please enter a number.");
            return;
        }

        if (cart == null) {
            cart = new ArrayList<CartItem>(); // Create a cart if it doesn't exist
        }
        cart.add(new CartItem(selectedProduct, userQuantity));



        System.out.println("Added " + userQuantity + " of " + selectedProduct.getName() + " to cart!");
        updateCartDisplay();
        window.setScene(cartScene);
    }


public void updateCartDisplay() {
        ListView<String> cartList = new ListView<>(); // Create a new ListView

        double totalPrice = 0.0; // Initialize total price

        if (cart != null) { // Check if cart exists
            for (CartItem item : cart) {
                Product product = item.getProduct();
                int quantity = item.getQuantity();
                double total = quantity * product.getPrice();
                totalPrice += total; // Add individual item price to total

                String itemString = product.getName() + " (x" + quantity + ") " + String.format("%.2f EGP", total);
                cartList.getItems().add(itemString);
            }
        }

        // Add the ListView to the cart scene
        gridPane.getChildren().add(cartList);

        // Remove existing total price label
        for (Node node : gridPane.getChildren()) {
            if (node instanceof Label && ((Label) node).getText().startsWith("Total Price = ")) {
                gridPane.getChildren().remove(node);
                break;
            }
        }

        // Display the total price
        Label totalPriceLabel = new Label("Total Price = " + String.format("%.2f EGP", totalPrice));
        gridPane.add(totalPriceLabel, 0, 2);
    }

}
