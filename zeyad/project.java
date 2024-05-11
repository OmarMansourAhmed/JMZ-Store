package org.example.shoppingcart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    Label totalPriceLabel = new Label();
    ArrayList<CartItem> cart; // Assuming you'll use an ArrayList for the cart
    GridPane gridPane;
    ListView<String> cartList = new ListView<>();
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
        nextButton.setOnAction(e -> window.setScene(cartScene));

        //Back button in cart scene
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.setScene(scene));

        //Back button in Payment scene
        Button backButton2 = new Button("Back");
        backButton2.setOnAction(e -> window.setScene(cartScene));

        //Go to payment button
        Button goToPaymentButton = new Button("Go To Payment");
        goToPaymentButton.setOnAction(e -> window.setScene(paymentScene));

        //Remove from Cart button
        Button removeFromCart = new Button("Remove From Cart");
        removeFromCart.setOnAction(e -> removeFromCartClicked());

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

        Label yourCartLabel = new Label("Shopping CART!");
        totalPriceLabel.setText("Total Price = 0 EGP");

        //Grid Pane in the cart scene

        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);
        yourCartLabel.setStyle("-fx-font-size: 15pt;");
        GridPane.setConstraints(yourCartLabel, 0, 0,3,1);
        GridPane.setConstraints(backButton, 0, 4);
        GridPane.setConstraints(goToPaymentButton, 2, 4);
        GridPane.setConstraints(removeFromCart, 0, 2);
        GridPane.setConstraints(cartList, 0, 1, 3, 1); // Spanning 3 columns and 1 row
        totalPriceLabel.setStyle("-fx-font-size: 15pt;");
        GridPane.setConstraints(totalPriceLabel, 0, 3, 3, 1); // Spanning 2 columns and 1 row

        gridPane.getChildren().addAll(backButton,goToPaymentButton,removeFromCart,cartList,totalPriceLabel,yourCartLabel);

        HBox cartSceneHBox = new HBox();
        cartSceneHBox.getChildren().add(gridPane);
        cartSceneHBox.setAlignment(Pos.CENTER);

        cartScene = new Scene(cartSceneHBox, 600, 600);

        //paymentScene= new Scene(vBox1,600,600);

        //Payment Scene
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
        products.add(new Product("Keyboard", 200.00, 15));
        products.add(new Product("ASUS", 20000.00, 10));
        products.add(new Product("NotePad", 3000.00, 5));
        return products;
    }

    public void addToCartClicked() {
        // Get the selected product
        Product selectedProduct = table.getSelectionModel().getSelectedItem();
        if (selectedProduct == null) {
            System.out.println("Please select a product first");
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

        //check if userQuantity is within stock limits
        if (userQuantity > selectedProduct.getQuantity()) {
            Alert alert = new Alert(Alert.AlertType.ERROR); // Create an error alert
            alert.setTitle("Insufficient Stock");
            String errorMessage = "The selected product only has " + selectedProduct.getQuantity() + " items in stock.";
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return;
        }

        if (cart == null) {
            cart = new ArrayList<>(); // Create a cart if it doesn't exist
        }
        cart.add(new CartItem(selectedProduct, userQuantity));


        System.out.println("Added " + userQuantity + " of " + selectedProduct.getName() + " to cart!");
        updateCartDisplay();
    }

    public void removeFromCartClicked() {
        try {
            ObservableList<String> selectedItems = cartList.getSelectionModel().getSelectedItems();

            if (!selectedItems.isEmpty()) {
                for (String itemString : selectedItems) {
                    // Parse the item string to identify the product
                    String[] itemParts = itemString.split(" "); // Split by space
                    String productName = itemParts[0];

                    // Find the corresponding CartItem in the cart
                    CartItem itemToRemove = null;
                    for (CartItem item : cart) {
                        if (item.getProduct().getName().equals(productName)) {
                            itemToRemove = item;
                            break;
                        }
                    }

                    if (itemToRemove != null) {
                        cart.remove(itemToRemove); // Remove the CartItem from the cart
                        System.out.println("Item "+ itemString + " is Removed!");
                    }
                }

                updateCartDisplay(); // Update the ListView with the modified cart
            } else {
                System.out.println("No items selected to remove.");
            }
        } catch (NullPointerException e){
            //System.out.println(e);
            System.out.println("Cart list or selection model is unavailable.");
        }
    }

    public void updateCartDisplay() {
        if (cartList != null) { // Check cartList
            cartList.getItems().clear(); // Clear previous items
        }
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


        totalPriceLabel.setText("Total Price = " + String.format("%.2f EGP", totalPrice));

    }

}
