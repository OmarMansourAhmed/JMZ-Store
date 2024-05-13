package com.example.jana;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;


import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

//import static com.example.jana.Admin.products;

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

public class HelloApplication extends Application  {


    private static Customer customer = new Customer();
    private Scene mainScene;
    private Scene logInScene; //login scene
    private Scene customerScene;
   private Scene adminScene; //should be admin scene
    private Scene scene;
Button button;
ListView<String>list;
//Stage window;

TextField name1input;
TextField price1input;
TextField quantity1input;
    TextField name2input;
    TextField price2input;
    TextField quantity2input;
    TextField name3input;
    TextField price3input;
    TextField quantity3input;
    TextField name4input;
    TextField price4input;
    TextField quantity4input;
    TextField name5input;
    TextField price5input;
    TextField quantity5input;
    TextField name6input;
    TextField price6input;
    TextField quantity6input;
TextField processorinput;
TextField screeninput;

TextField noofcamerasinput;
TextField storageinput;
TextField cellinput;

TextField modelinput;

TextField connection1input;

TextField led1input;
    TextField connection2input;

    TextField led2input;
    TextField connection3input;

    TextField led3input;
TextField Noiseinput;

TextField switchesinput;

TextField sensitivityinput;
ObservableList<Laptops> laptops;
ObservableList<MobilePhones> mobiles;
ObservableList<PlayStation> playstation;
ObservableList<HeadSets> headSets;
ObservableList<Keyboard>keyboards;
ObservableList<Mouse>mouse;

    ObservableList<Laptops>laptopsObservableList;
    ObservableList<MobilePhones>mobilePhonesObservableList;
    ObservableList<PlayStation>playStationObservableList;
    ObservableList<HeadSets>HeadsetsObservableList;
    ObservableList<Keyboard>keyboardObservableList;
    ObservableList<Mouse>MouseObservableList;
TableView<Laptops> table1;
TableView<MobilePhones> table2;

TableView<HeadSets> table4;
TableView<PlayStation> table3;
TableView<Keyboard> table5;
TableView<Mouse> table6;
    TableView<Laptops> lapsTable;
    TableView<MobilePhones> mobTable;

    TableView<HeadSets> headsetTable;
    TableView<PlayStation>psTable ;
    TableView<Keyboard> keyboardTable;
    TableView<Mouse> mouseTable;
    ChoiceBox<String> accessoriesChoiceBox=new ChoiceBox();

    ArrayList<Products> Product_initial=new ArrayList<>();
    ListView<String> cartList = new ListView<>();

    double totalprice=0;

    Label totalPriceLabel=new Label();

//TableView<Products>table1,table2,table3,table4;  //at least one column in table view
    public static void main(String[] args) {

        launch(args);}
    @Override
    public void start(Stage stage) throws Exception {

        //MAIN PAGE
        // Creating labels and buttons for the main scene
        Label welcomeLabel = new Label("Welcome to JMZ Store");
        welcomeLabel.setStyle("-fx-font-size: 28pt; -fx-font-family: Arvo; -fx-text-fill: " + formatColor(Color.rgb(255, 219, 153)));
        Label loginAsLabel = new Label("Login As");
        loginAsLabel.setStyle("-fx-font-size: 18pt; -fx-text-fill: " + formatColor(Color.rgb(255, 93, 178)));
        Button adminButton = new Button("Admin");
        Button customerButton = new Button("Customer");

        // Styling buttons for the main scene
        adminButton.setStyle("-fx-background-color: " + formatColor(Color.rgb(255, 93, 178)) + "; -fx-text-fill: white;");
        customerButton.setStyle("-fx-background-color: " + formatColor(Color.rgb(255, 93, 178)) + "; -fx-text-fill: white;");

        // Creating an HBox for the buttons in the main scene
        HBox buttonsBox = new HBox(20); // 20 pixels spacing between buttons
        buttonsBox.setAlignment(Pos.CENTER); // Center aligning buttons
        buttonsBox.getChildren().addAll(adminButton, customerButton);

        // Creating a VBox for the labels and buttons in the main scene
        VBox mainLayout = new VBox(20); // 20 pixels spacing between components
        mainLayout.setAlignment(Pos.CENTER); // Center aligning components vertically
        mainLayout.setBackground(new Background(new BackgroundFill(Color.rgb(31, 15, 83), null, null)));
        mainLayout.getChildren().addAll(welcomeLabel, loginAsLabel, buttonsBox);

        // Creating an ImageView for the image
        Image image = new Image("file:\\C:\\Users\\Jana Aly\\Downloads\\mjz-logo-zip-file\\png\\logo-no-background.png");

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(400); // Set the width of the image
        imageView.setPreserveRatio(true); // Preserve the aspect ratio of the image

        // Adding the ImageView to the mainLayout
        mainLayout.getChildren().add(0, imageView); // Adding the ImageView at the beginning of the VBox

        // Creating the main scene
        mainScene = new Scene(mainLayout, 1100, 500);

        // Creating labels and buttons for the admin scene
        Label adminLabel = new Label("Admin Login");
        adminLabel.setStyle("-fx-font-size: 24pt; -fx-font-family: Arvo; -fx-text-fill: " + formatColor(Color.rgb(255, 219, 153)));
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        nameField.setMaxWidth(120); // Setting max width for name field
        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-size: 14pt; -fx-text-fill: " + formatColor(Color.rgb(255, 219, 153)));

        // Creating an HBox for the name label and field
        HBox nameBox = new HBox(10);
        nameBox.setAlignment(Pos.CENTER); // Center aligning components horizontally
        nameBox.getChildren().addAll(nameLabel, nameField);

        TextField idField = new TextField();
        idField.setPromptText("Enter your ID");
        idField.setMaxWidth(120); // Setting max width for ID field
        Label idLabel = new Label("ID:");
        idLabel.setStyle("-fx-font-size: 14pt; -fx-text-fill: " + formatColor(Color.rgb(255, 219, 153)));

        // Creating an HBox for the ID label and field
        HBox idBox = new HBox(10);
        idBox.setAlignment(Pos.CENTER); // Center aligning components horizontally
        idBox.getChildren().addAll(idLabel, idField);

        Button loginButton = new Button("Login");
        Button backButton = new Button("Back");

        // Styling buttons for the admin scene
        loginButton.setStyle("-fx-background-color: " + formatColor(Color.rgb(255, 93, 178)) + "; -fx-text-fill: white;");
        backButton.setStyle("-fx-background-color: " + formatColor(Color.rgb(255, 93, 178)) + "; -fx-text-fill: white;");

        // Creating an HBox for the buttons in the admin scene
        HBox adminButtonsBox = new HBox(20); // 20 pixels spacing between buttons
        adminButtonsBox.setAlignment(Pos.CENTER); // Center aligning buttons
        adminButtonsBox.getChildren().addAll(loginButton, backButton);

        // Creating a VBox for the labels and input fields in the admin scene
        VBox adminFieldsLayout = new VBox(20); // 20 pixels spacing between components
        adminFieldsLayout.setAlignment(Pos.CENTER); // Center aligning components vertically
        adminFieldsLayout.setBackground(new Background(new BackgroundFill(Color.rgb(31, 15, 83), null, null)));
        adminFieldsLayout.getChildren().addAll(adminLabel, nameBox, idBox, adminButtonsBox);

        // Creating the admin scene
        logInScene = new Scene(adminFieldsLayout, 1100, 500);

        // Creating labels and buttons for the customer scene
        Label customerLabel = new Label("Customer Scene");
        customerLabel.setStyle("-fx-font-size: 24pt; -fx-font-family: Arvo; -fx-text-fill: " + formatColor(Color.rgb(255, 219, 153)));
        Button backToMainButton = new Button("Back to Main");

        // Styling button for the customer scene
        backToMainButton.setStyle("-fx-background-color: " + formatColor(Color.rgb(255, 93, 178)) + "; -fx-text-fill: white;");

        // Creating an HBox for the button in the customer scene
        HBox customerButtonBox = new HBox(20); // 20 pixels spacing between buttons
        customerButtonBox.setAlignment(Pos.CENTER); // Center aligning button
        customerButtonBox.getChildren().addAll(backToMainButton);


        // Creating labels and buttons for the control scene
        Label controlLabel = new Label("Control Scene");
        controlLabel.setStyle("-fx-font-size: 24pt; -fx-font-family: Arvo; -fx-text-fill: " + formatColor(Color.rgb(255, 219, 153)));

        // Setting action for the Admin button
        adminButton.setOnAction(e -> stage.setScene(logInScene));

        // Setting action for the Back button in the admin scene
        backButton.setOnAction(e -> stage.setScene(mainScene));

        // Setting action for the Login button in the admin scene
        loginButton.setOnAction(e -> {
            String name = nameField.getText();
            String id = idField.getText();
            if (name.equals("JMZ") && id.equals("333")) {
                stage.setScene(adminScene);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect Data");
                alert.setHeaderText(null);
                alert.setContentText("Incorrect Data");
                alert.showAndWait();
            }
        });

        // Setting action for the Customer button
        customerButton.setOnAction(e -> stage.setScene(customerScene));

        // Setting action for the Back to Main button in the customer scene
        backToMainButton.setOnAction(e -> stage.setScene(mainScene));

        // Setting the icon for the stage
        stage.getIcons().add(new Image("file:///C:/Users/ahmed/Downloads/mjz-favicon-color.png"));

        // Setting the stage title
        stage.setTitle("MJZ Store");

        // Setting the main scene to the stage
        stage.setScene(mainScene);





    ////////////////////////////
        accessoriesChoiceBox.setStyle("-fx-font-size: 20px; -fx-min-width: 200px; -fx-min-height: 100px;");
        HBox mainPage = new HBox();
        mainPage.setSpacing(30);
        HBox hBox2 = new HBox();
        hBox2.setSpacing(30);
        VBox vBox = new VBox();
        vBox.setSpacing(30);
        mainPage.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);

        //4 buttons
        Button laptopsButton = new Button("Laptops");
        Button mobilePhonesButton = new Button("Mobile Phones");
        Button playstationButton = new Button("Playstation");
        Button homefromlapButton= new Button("Back");
        Button homefrommobButton= new Button("Back");
        Button homefrompsButton= new Button("Back");
        Button homefromheadsetsButton= new Button("Back");
        Button homefromkeyboardButton= new Button("Back");
        Button homefrommouseButton= new Button("Back");
        laptopsButton.setStyle("-fx-font-size: 20px; -fx-min-width: 200px; -fx-min-height: 100px;");
        mobilePhonesButton.setStyle("-fx-font-size: 20px; -fx-min-width: 200px; -fx-min-height: 100px;");
        playstationButton.setStyle("-fx-font-size: 20px; -fx-min-width: 200px; -fx-min-height: 100px;");
        //Button accessoriesButton = new Button("ACCESSORIES");

 //****************************************************first page*************************************************************



        TableColumn<Laptops,String> name1column=new TableColumn<>("Name");
        name1column.setMinWidth(200);
        name1column.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Laptops,Double> pricecolumn=new TableColumn<>("price");
        pricecolumn.setMinWidth(100);
        pricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Laptops,Integer> quantitycolumn=new TableColumn<>("Quantity");
        quantitycolumn.setMinWidth(100);
        quantitycolumn.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        TableColumn<MobilePhones,String> name2column=new TableColumn<>("Name");
        name2column.setMinWidth(200);
        name2column.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<MobilePhones,Double> price2column=new TableColumn<>("price");
        price2column.setMinWidth(100);
        price2column.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<MobilePhones,Integer> quantity2column=new TableColumn<>("Quantity");
        quantity2column.setMinWidth(100);
        quantity2column.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        TableColumn<PlayStation,String> name3column=new TableColumn<>("Name");
        name3column.setMinWidth(200);
        name3column.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<PlayStation,Double> price3column=new TableColumn<>("price");
        price3column.setMinWidth(100);
        price3column.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<PlayStation,Integer> quantity3column=new TableColumn<>("Quantity");
        quantity3column.setMinWidth(100);
        quantity3column.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        TableColumn<HeadSets,String> name4column=new TableColumn<>("Name");   //Keyboard
        name4column.setMinWidth(200);
        name4column.setCellValueFactory(new PropertyValueFactory<>("name"));



        TableColumn<HeadSets,Double> price4column=new TableColumn<>("price");
        price4column.setMinWidth(100);
        price4column.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<HeadSets,Integer> quantity4column=new TableColumn<>("Quantity");
        quantity4column.setMinWidth(100);
        quantity4column.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        TableColumn<Keyboard,String> name5column=new TableColumn<>("Name");   //Keyboard
        name5column.setMinWidth(200);
        name5column.setCellValueFactory(new PropertyValueFactory<>("name"));



        TableColumn<Keyboard,Double> price5column=new TableColumn<>("price");
        price5column.setMinWidth(100);
        price5column.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Keyboard,Integer> quantity5column=new TableColumn<>("Quantity");
        quantity5column.setMinWidth(100);
        quantity5column.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        TableColumn<Mouse,String> name6column=new TableColumn<>("Name");  // Mouse
        name6column.setMinWidth(200);
        name6column.setCellValueFactory(new PropertyValueFactory<>("name"));



        TableColumn<Mouse,Double> price6column=new TableColumn<>("price");
        price6column.setMinWidth(100);
        price6column.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Mouse,Integer> quantity6column=new TableColumn<>("Quantity");
        quantity6column.setMinWidth(100);
        quantity6column.setCellValueFactory(new PropertyValueFactory<>("inStock"));



        TableColumn<Laptops,String> processorcol =new TableColumn<>("Processor");
        processorcol.setMinWidth(100);
        processorcol.setCellValueFactory(new PropertyValueFactory<>("processor"));

        TableColumn<Laptops,Double> screencol =new TableColumn<>("ScreenSize");
        screencol.setMinWidth(100);
        screencol.setCellValueFactory(new PropertyValueFactory<>("screenSize"));

        TableColumn<MobilePhones,Integer> camerano =new TableColumn<>("no of cameras");
        camerano.setMinWidth(100);
        camerano.setCellValueFactory(new PropertyValueFactory<>("numberOfCameras"));


        TableColumn<MobilePhones,Integer> storage =new TableColumn<>("Storage");
        storage.setMinWidth(100);
        storage.setCellValueFactory(new PropertyValueFactory<>("storage"));

        TableColumn<MobilePhones,String> cell =new TableColumn<>("cellular");
        cell.setMinWidth(100);
        cell.setCellValueFactory(new PropertyValueFactory<>("cellular"));

        TableColumn<PlayStation,String> model =new TableColumn<>("ps model");
        model.setMinWidth(100);
        model.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn<HeadSets,String> connectiontype1 =new TableColumn<>("connection type");
        connectiontype1.setMinWidth(100);
        connectiontype1.setCellValueFactory(new PropertyValueFactory<>("connectionType"));

        TableColumn<HeadSets,Boolean> rgbled1 =new TableColumn<>("RGB LED");
        rgbled1.setMinWidth(100);
        rgbled1.setCellValueFactory(new PropertyValueFactory<>("ledRGB"));

        TableColumn< Keyboard,String> connectiontype2 =new TableColumn<>("connection type");
        connectiontype2.setMinWidth(100);
        connectiontype2.setCellValueFactory(new PropertyValueFactory<>("connectionType"));

        TableColumn< Keyboard,Boolean> rgbled2 =new TableColumn<>("RGB LED");
        rgbled2.setMinWidth(100);
        rgbled2.setCellValueFactory(new PropertyValueFactory<>("ledRGB"));

        TableColumn<Mouse,String> connectiontype3 =new TableColumn<>("connection type");
        connectiontype3.setMinWidth(100);
        connectiontype3.setCellValueFactory(new PropertyValueFactory<>("connectionType"));

        TableColumn<Mouse,Boolean> rgbled3 =new TableColumn<>("RGB LED");
        rgbled3.setMinWidth(100);
        rgbled3.setCellValueFactory(new PropertyValueFactory<>("ledRGB"));


        TableColumn<HeadSets,Boolean> noisecancellation =new TableColumn<>("noise cancellation");
        noisecancellation.setMinWidth(100);
        noisecancellation.setCellValueFactory(new PropertyValueFactory<>("noiseCancellation"));

        TableColumn<Keyboard,String> switchesType =new TableColumn<>("switches type");
        switchesType.setMinWidth(100);
        switchesType.setCellValueFactory(new PropertyValueFactory<>("switchesType"));

        TableColumn<Mouse,Double> sensitivity =new TableColumn<>("sensitivity");
        sensitivity.setMinWidth(100);
        sensitivity.setCellValueFactory(new PropertyValueFactory<>("Sensitivity"));



        name1input=new TextField();
        name1input.setPromptText("name");
        name1input.setMinWidth(100);

        price1input=new TextField();
        price1input.setPromptText("price");
        //priceinput.setMaxWidth(100);

        quantity1input=new TextField();
        quantity1input.setPromptText("quantity");


        name2input=new TextField();
        name2input.setPromptText("name");
        name2input.setMinWidth(100);

        price2input=new TextField();
        price2input.setPromptText("price");
        //priceinput.setMaxWidth(100);

        quantity2input=new TextField();
        quantity2input.setPromptText("quantity");
        //quantityinput.setMaxWidth(100);


        name3input=new TextField();
        name3input.setPromptText("name");
        name3input.setMinWidth(100);

        price3input=new TextField();
        price3input.setPromptText("price");
        //priceinput.setMaxWidth(100);

        quantity3input=new TextField();
        quantity3input.setPromptText("quantity");


        name4input=new TextField();
        name4input.setPromptText("name");
        name4input.setMinWidth(100);

        price4input=new TextField();
        price4input.setPromptText("price");
        //priceinput.setMaxWidth(100);

        quantity4input=new TextField();
        quantity4input.setPromptText("quantity");

        name5input=new TextField();
        name5input.setPromptText("name");
        name5input.setMinWidth(100);

        price5input=new TextField();
        price5input.setPromptText("price");
        //priceinput.setMaxWidth(100);

        quantity5input=new TextField();
        quantity5input.setPromptText("quantity");

        name6input=new TextField();
        name6input.setPromptText("name");
        name6input.setMinWidth(100);

        price6input=new TextField();
        price6input.setPromptText("price");
        //priceinput.setMaxWidth(100);

        quantity6input=new TextField();
        quantity6input.setPromptText("quantity");

        processorinput=new TextField();
        processorinput.setPromptText("processor type");

        screeninput=new TextField();
        screeninput.setPromptText("screen size");

        noofcamerasinput=new TextField();
        noofcamerasinput.setPromptText("no of cameras");

        storageinput=new TextField();
        storageinput.setPromptText("storage");

        cellinput=new TextField();
        cellinput.setPromptText("cellular");

        modelinput=new TextField();
        modelinput.setPromptText("Model type");

        connection1input=new TextField();
        connection1input.setPromptText("connection type");

        led1input=new TextField();
        led1input.setPromptText("RGB led");

        connection2input=new TextField();
        connection2input.setPromptText("connection type");

        led2input=new TextField();
        led2input.setPromptText("RGB led");

        connection3input=new TextField();
        connection3input.setPromptText("connection type");

        led3input=new TextField();
        led3input.setPromptText("RGB led");

        Noiseinput =new TextField();
        Noiseinput.setPromptText("noise cancellation");

        switchesinput=new TextField();
        switchesinput.setPromptText("switches type");

        sensitivityinput=new TextField();
        sensitivityinput.setPromptText("sensitivity level");




        ObservableList<Laptops>laptopsObservableList= get1product();
        ObservableList<MobilePhones>mobilePhonesObservableList= get2product();
        ObservableList<PlayStation>playStationObservableList= get3product();
        ObservableList<HeadSets>HeadsetsObservableList= get4product();
        ObservableList<Keyboard>keyboardObservableList= get5product();
        ObservableList<Mouse>MouseObservableList= get6product();

        table1=createTableView1(laptopsObservableList);
        table2=createTableView2(mobilePhonesObservableList);
        table3=createTableView3(playStationObservableList);
        table4=createTableView4(HeadsetsObservableList);
        table5 =createTableView5(keyboardObservableList);
        table6 =createTableView6(MouseObservableList);

         lapsTable=createTableView1(laptopsObservableList);
         mobTable=createTableView2(mobilePhonesObservableList);
         psTable=createTableView3(playStationObservableList);
         headsetTable =createTableView4(HeadsetsObservableList);
         keyboardTable =createTableView5(keyboardObservableList);
         mouseTable =createTableView6(MouseObservableList);

        Collections.sort(Product_initial);

        for(Products i:Product_initial){
            System.out.println(i.toString());
        }

        Button back_from_admin=new Button("Log Out");
        Button back_from_customer=new Button("Back to main page");

        Button addbutton1=new Button("Add");
        addbutton1.setOnAction(e -> {
            additem_laptop();
        });

        Button deletebutton1=new Button("Delete");
        deletebutton1.setOnAction(e -> deleteitem_laptop());



        Button addbutton2=new Button("Add");
        addbutton2.setOnAction(e -> {
            additem_mobiles();

        });

        Button deletebutton2=new Button("Delete");
        deletebutton2.setOnAction(e -> deleteitem_mobiles());


        Button addbutton3=new Button("Add");
        addbutton3.setOnAction(e -> {
            additem_playstation();

        });

        Button deletebutton3=new Button("Delete");
        deletebutton3.setOnAction(e -> deleteitem_playstation());

        Button addbutton4=new Button("Add");
        addbutton4.setOnAction(e -> {
            additem_headsets();

        });

        Button deletebutton4=new Button("Delete");
        deletebutton4.setOnAction(e -> deleteitem_headsets());

        Button addbutton5=new Button("Add");
        addbutton5.setOnAction(e -> {
            additem_keyboard();

        });

        Button deletebutton5=new Button("Delete");
        deletebutton5.setOnAction(e -> deleteitem_keyboard());

        Button addbutton6=new Button("add");
        addbutton6.setOnAction(e -> {
            additem_mouse();

        });

        Button deletebutton6=new Button("Delete");
        deletebutton6.setOnAction(e -> deleteitem_mouse());



        HBox hBox1 = new HBox(); //laps
       hBox1.getChildren().addAll(name1input,price1input,quantity1input,processorinput,screeninput, addbutton1,deletebutton1,homefromlapButton);
        HBox hbox2 =new HBox(); //mobilephones
        hbox2.getChildren().addAll(name2input,price2input,quantity2input,noofcamerasinput,storageinput,cellinput,addbutton2,deletebutton2,homefrommobButton);
        HBox hBox3 = new HBox(); //ps
        hBox3.getChildren().addAll(name3input,price3input,quantity3input,modelinput,addbutton3,deletebutton3,homefrompsButton);
        HBox hBox4 = new HBox(); //headsets
        hBox4.getChildren().addAll(name4input,price4input,quantity4input,connection1input,led1input,Noiseinput,addbutton4,deletebutton4,homefromheadsetsButton);
        HBox hBox5 = new HBox(); //keyboard
        hBox5.getChildren().addAll(name5input,price5input,quantity5input,connection2input,led2input,switchesinput,addbutton5,deletebutton5,homefromkeyboardButton);
        HBox hBox6 = new HBox(); //mouse
        hBox6.getChildren().addAll(name6input,price6input,quantity6input,connection3input,led3input,sensitivityinput,addbutton6,deletebutton6,homefrommouseButton);

        TextField tf1=new TextField("0");
        Button incbutton1=new Button("+");
        incbutton1.setOnAction(e -> {

            ObservableList<Laptops>productsselected;
            productsselected=lapsTable.getSelectionModel().getSelectedItems();
            //isAvailable() {
            //        return p.inStock>0;
            //   }
            for(Laptops i:productsselected){
                if (Integer.parseInt(tf1.getText())+1> i.getInStock() && !i.isAvailable() ){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Input");
                    alert.setHeaderText("Input Validation Error");
                    alert.showAndWait();
                }
                else tf1.setText(increment(tf1.getText()));}
        });
        Button decbutton1=new Button("-");
        decbutton1.setOnAction(e -> {
            if(Integer.parseInt(decrement(tf1.getText()))<0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Input Validation Error");
                alert.showAndWait();
            }
            else
                tf1.setText(decrement(tf1.getText()));
        });
        TextField tf2=new TextField("0");
        Button incbutton2=new Button("+");
        incbutton2.setOnAction(e -> {

            ObservableList<MobilePhones>productsselected;
            productsselected=mobTable.getSelectionModel().getSelectedItems();

            for(MobilePhones i:productsselected){
            if (Integer.parseInt(tf2.getText())+1> i.getInStock()&& !i.isAvailable()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Input Validation Error");
                alert.showAndWait();
            }
           else tf2.setText(increment(tf2.getText()));}
        });
        Button decbutton2=new Button("-");
        decbutton2.setOnAction(e -> {
            if(Integer.parseInt(decrement(tf2.getText()))<0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Input Validation Error");
                alert.showAndWait();
            }
            else
                tf2.setText(decrement(tf2.getText()));
        });


        TextField tf3=new TextField("0");
        Button incbutton3=new Button("+");
        incbutton3.setOnAction(e ->{

            ObservableList<PlayStation>productsselected;
            productsselected=psTable.getSelectionModel().getSelectedItems();

            for(PlayStation i:productsselected){
                if (Integer.parseInt(tf3.getText())+1> i.getInStock()&& !i.isAvailable()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Input");
                    alert.setHeaderText("Input Validation Error");
                    alert.showAndWait();
                }
                else tf3.setText(increment(tf3.getText()));}
        });
        Button decbutton3=new Button("-");
        decbutton3.setOnAction(e -> {
            if(Integer.parseInt(decrement(tf3.getText()))<0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Input Validation Error");
                alert.showAndWait();
            }
            else
                tf3.setText(decrement(tf3.getText()));
        });


        TextField tf4=new TextField("0");
        Button incbutton4=new Button("+");
        incbutton4.setOnAction(e -> {

            ObservableList<HeadSets>productsselected;
            productsselected=headsetTable.getSelectionModel().getSelectedItems();

            for(HeadSets i:productsselected){
                if (Integer.parseInt(tf4.getText())+1> i.getInStock()&& !i.isAvailable()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Input");
                    alert.setHeaderText("Input Validation Error");
                    alert.showAndWait();
                }
                else tf4.setText(increment(tf4.getText()));}
        });
        Button decbutton4=new Button("-");
        decbutton4.setOnAction(e -> {
            if(Integer.parseInt(decrement(tf4.getText()))<0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Input Validation Error");
                alert.showAndWait();
            }
            else
                tf4.setText(decrement(tf4.getText()));
        });


        TextField tf5=new TextField("0");
        Button incbutton5=new Button("+");
        incbutton5.setOnAction(e -> {

            ObservableList<Keyboard>productsselected;
            productsselected=keyboardTable.getSelectionModel().getSelectedItems();

            for(Keyboard i:productsselected){
                if (Integer.parseInt(tf5.getText())+1> i.getInStock()&& !i.isAvailable()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Input");
                    alert.setHeaderText("Input Validation Error");
                    alert.showAndWait();
                }
                else tf5.setText(increment(tf5.getText()));}
        });
        Button decbutton5=new Button("-");
        decbutton5.setOnAction(e -> {
            if(Integer.parseInt(decrement(tf5.getText()))<0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Input Validation Error");
                alert.showAndWait();
            }
            else
                tf5.setText(decrement(tf5.getText()));
        });

        TextField tf6=new TextField("0");
        Button incbutton6=new Button("+");
        incbutton6.setOnAction(e -> {

            ObservableList<Mouse>productsselected;
            productsselected=mouseTable.getSelectionModel().getSelectedItems();

            for(Mouse i:productsselected){
                if (Integer.parseInt(tf6.getText())+1> i.getInStock()&& !i.isAvailable()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Input");
                    alert.setHeaderText("Input Validation Error");
                    alert.showAndWait();
                }
                else tf6.setText(increment(tf6.getText()));}
        });
        Button decbutton6=new Button("-");
        decbutton6.setOnAction(e -> {
            if(Integer.parseInt(decrement(tf6.getText()))<0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Input Validation Error");
                alert.showAndWait();
            }
            else
                tf6.setText(decrement(tf6.getText()));
        });







        ArrayList<Products> productArrayList=new ArrayList<Products>();
        ArrayList<Integer> quantity=new ArrayList<>();
        Button addtocart1=new Button("add to cart");
        Button addtocart2=new Button("add to cart");
        Button addtocart3=new Button("add to cart");
        Button addtocart4=new Button("add to cart");
        Button addtocart5=new Button("add to cart");
        Button addtocart6=new Button("add to cart");






        addtocart1.setOnAction(e->
        {

            if (tf1.getText().equals("0")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Input Validation Error");
            alert.showAndWait();
        }
        else {
            ObservableList<Laptops>productsselected;

        //isAvailable(Products p) {
                //        return p.inStock>0;
                //   }
            productsselected=lapsTable.getSelectionModel().getSelectedItems();
            for(Laptops i:productsselected){
                productArrayList.add((Products) i);
                cartList.getItems().add(i.getName() + " (x" + Integer.parseInt(tf1.getText()) + ")");
                cartList.getItems().add("                                       "+i.getPrice()*Integer.parseInt(tf1.getText()));
                Totalprice( i.getPrice() * Integer.parseInt(tf1.getText()));
            }
            quantity.add(Integer.parseInt(tf1.getText()));

        }
        });

        addtocart2.setOnAction(e->
        {
            if (tf2.getText().equals("0")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Input Validation Error");
                alert.showAndWait();
            }
            else {
            //  productArrayList.add(//selected item);
            ObservableList<MobilePhones>productsselected;
            productsselected=mobTable.getSelectionModel().getSelectedItems();
            for(MobilePhones i:productsselected){
                productArrayList.add((Products) i);
                cartList.getItems().add(i.getName() + " (x" + Integer.parseInt(tf2.getText()) + ")");
                cartList.getItems().add("                                       "+i.getPrice()*Integer.parseInt(tf2.getText()));
                Totalprice( i.getPrice() * Integer.parseInt(tf2.getText()));
            }
            quantity.add(Integer.parseInt(tf2.getText()));
        }});
        addtocart3.setOnAction(e->
        {
            //  productArrayList.add(//selected item);
/////////////////////////////////////////////////////////
            if (tf3.getText().equals("0")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Input Validation Error");
                alert.showAndWait();
            }
            else {
            ObservableList<PlayStation>productsselected;
            productsselected=psTable.getSelectionModel().getSelectedItems();
            for(PlayStation i:productsselected){
                productArrayList.add((Products) i);
                cartList.getItems().add(i.getName() + " (x" + Integer.parseInt(tf3.getText()) + ")");
                cartList.getItems().add("                                       "+i.getPrice()*Integer.parseInt(tf3.getText()));
                Totalprice( i.getPrice() * Integer.parseInt(tf3.getText()));
            }
/////////////////////////////////////////////////////////
            quantity.add(Integer.parseInt(tf3.getText()));
        }});
        addtocart4.setOnAction(e->
        { if (tf4.getText().equals("0")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Input Validation Error");
            alert.showAndWait();
        }
        else {
            //  productArrayList.add(//selected item);
            ObservableList<HeadSets>productsselected;
            productsselected=headsetTable.getSelectionModel().getSelectedItems();
            for(HeadSets i:productsselected){
                productArrayList.add((Products) i);
                cartList.getItems().add(i.getName() + " (x" + Integer.parseInt(tf4.getText()) + ")");
                cartList.getItems().add("                                       "+i.getPrice()*Integer.parseInt(tf4.getText()));
                Totalprice( i.getPrice() * Integer.parseInt(tf4.getText()));
            }
            quantity.add(Integer.parseInt(tf4.getText()));
        }});
        addtocart5.setOnAction(e->
        {
            //  productArrayList.add(//selected item);
            if (tf5.getText().equals("0")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Input Validation Error");
                alert.showAndWait();
            }
            else {
            ObservableList<Keyboard>productsselected;
            productsselected=keyboardTable.getSelectionModel().getSelectedItems();
            for(Keyboard i:productsselected){
               productArrayList.add((Products) i);
                cartList.getItems().add(i.getName() + " (x" + Integer.parseInt(tf5.getText()) + ")");
                cartList.getItems().add("                                       "+i.getPrice()*Integer.parseInt(tf5.getText()));
                Totalprice( i.getPrice() * Integer.parseInt(tf5.getText()));
          }
            quantity.add(Integer.parseInt(tf5.getText()));
        }});
        addtocart6.setOnAction(e->
        { if (tf6.getText().equals("0")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Input Validation Error");
            alert.showAndWait();
        }
        else {
            //  productArrayList.add(//selected item);
            ObservableList<Mouse>productsselected;
            productsselected=mouseTable.getSelectionModel().getSelectedItems();
            for(Mouse i:productsselected){
               productArrayList.add((Products) i);
                cartList.getItems().add(i.getName() + " (x" + Integer.parseInt(tf6.getText()) + ")");
                cartList.getItems().add("                                       "+i.getPrice()*Integer.parseInt(tf6.getText()));
                Totalprice( i.getPrice() * Integer.parseInt(tf6.getText()));
           }
            quantity.add(Integer.parseInt(tf6.getText()));
        }});

        Button backButton1 = new Button("Back");
        Button backButton2 = new Button("Back");
        Button backButton3 = new Button("Back");
        Button backButton4 = new Button("Back");
        Button backButton5 = new Button("Back");
        Button backButton6 = new Button("Back");

        GridPane gridPane =new GridPane();

        HBox cartSceneHBox = new HBox();
        cartSceneHBox.getChildren().add(gridPane);
        cartSceneHBox.setAlignment(Pos.CENTER);
        Scene cartScene =  new Scene(cartSceneHBox,1100,500);

        Button cartButton1 = new Button("Go to cart");
        Button cartButton2 = new Button("Go to cart");
        Button cartButton3 = new Button("Go to cart");
        Button cartButton4 = new Button("Go to cart");
        Button cartButton5 = new Button("Go to cart");
        Button cartButton6 = new Button("Go to cart");
        cartButton1.setOnAction(e->
        {
            stage.setScene(cartScene);
            totalPriceLabel.setText("Total Price = " + totalprice);

        });
        cartButton2.setOnAction(e->
        {
            stage.setScene(cartScene);
            totalPriceLabel.setText("Total Price = " + totalprice);

        });
        cartButton3.setOnAction(e->
        {
            stage.setScene(cartScene);
            totalPriceLabel.setText("Total Price = " + totalprice);

        });
        cartButton4.setOnAction(e->
        {
            stage.setScene(cartScene);
            totalPriceLabel.setText("Total Price = " + totalprice);

        });
        cartButton5.setOnAction(e->
        {
            stage.setScene(cartScene);
            totalPriceLabel.setText("Total Price = " + totalprice);

        });
        cartButton6.setOnAction(e->
        {
            stage.setScene(cartScene);
            totalPriceLabel.setText("Total Price = " + totalprice);

        });
        Label warrantylabel1= new Label("Laptops warranty duration is two years");
        Label warrantylabel2= new Label("Mobile Phones warranty duration is one year and six months");
        Label warrantylabel3= new Label("Playstation warranty duration is one year");
        Label warrantylabel4= new Label("Headsets warranty duration is six months");
        Label warrantylabel5= new Label("Keyboards warranty duration is six months");
        Label warrantylabel6= new Label("Mouses warranty duration is six months");


        warrantylabel1.setStyle("-fx-font-size: 15pt;");
        warrantylabel2.setStyle("-fx-font-size: 15pt;");
        warrantylabel3.setStyle("-fx-font-size: 15pt;");
        warrantylabel4.setStyle("-fx-font-size: 15pt;");
        warrantylabel5.setStyle("-fx-font-size: 15pt;");
        warrantylabel6.setStyle("-fx-font-size: 15pt;");
        HBox hBox7 = new HBox(); //laps
        hBox7.getChildren().addAll(warrantylabel1,backButton1,decbutton1,tf1,incbutton1,addtocart1,cartButton1);
        hBox7.setSpacing(20);
        hBox7.setAlignment(Pos.CENTER);
        HBox hbox8 =new HBox(); //mobilephones
        hbox8.getChildren().addAll(warrantylabel2,backButton2,decbutton2,tf2,incbutton2,addtocart2,cartButton2);
        hbox8.setSpacing(20);
        hbox8.setAlignment(Pos.CENTER);
        HBox hBox9 = new HBox(); //ps
        hBox9.getChildren().addAll(warrantylabel3,backButton3,decbutton3,tf3,incbutton3,addtocart3,cartButton3);
        hBox9.setSpacing(20);
        hBox9.setAlignment(Pos.CENTER);
        HBox hBox10 = new HBox(); //headsets
        hBox10.getChildren().addAll(warrantylabel4,backButton4,decbutton4,tf4,incbutton4,addtocart4,cartButton4);
        hBox10.setSpacing(20);
        hBox10.setAlignment(Pos.CENTER);
        HBox hBox11 = new HBox(); //keyboard
        hBox11.getChildren().addAll(warrantylabel5,backButton5,decbutton5,tf5,incbutton5,addtocart5,cartButton5);
        hBox11.setSpacing(20);
        hBox11.setAlignment(Pos.CENTER);
        HBox hBox12 = new HBox(); //mouse
        hBox12.getChildren().addAll(warrantylabel6,backButton6,decbutton6,tf6,incbutton6,addtocart6,cartButton6);
        hBox12.setSpacing(20);
        hBox12.setAlignment(Pos.CENTER);



// laptopsButton.setPrefSize(50,50);
// 6 new scenes
        VBox vBox1 = new VBox(); //laps
        vBox1.getChildren().addAll(table1,hBox1);
        VBox vBox2 =new VBox(); //mobilephones
        vBox2.getChildren().addAll(table2,hbox2);
        VBox vBox3 = new VBox(); //ps
        vBox3.getChildren().addAll(table3,hBox3);
        VBox vBox4 = new VBox(); //headsets
        vBox4.getChildren().addAll(table4,hBox4);
        VBox vBox5 = new VBox(); //keyboard
        vBox5.getChildren().addAll(table5,hBox5);
        VBox vBox6 = new VBox(); //mouse
        vBox6.getChildren().addAll(table6,hBox6);
        VBox vbox7=new VBox();
        vbox7.getChildren().addAll(lapsTable,hBox7);
        VBox vBox8 =new VBox(); //mobilephones
        vBox8.getChildren().addAll(mobTable,hbox8);
        VBox vBox9 = new VBox(); //ps
        vBox9.getChildren().addAll(psTable,hBox9);
        VBox vBox10 = new VBox(); //headsets
        vBox10.getChildren().addAll(headsetTable,hBox10);
        VBox vBox11 = new VBox(); //keyboard
        vBox11.getChildren().addAll(keyboardTable,hBox11);
        VBox vBox12 = new VBox(); //mouse
        vBox12.getChildren().addAll(mouseTable,hBox12);


        //4 new scenes
        Scene laptopsScene = new Scene(vBox1, 1100, 500);
        Scene mobilePhonesScene = new Scene(vBox2, 1100, 500);
        Scene playstaionScene = new Scene(vBox3, 1100, 500);
        Scene headSetsScene = new Scene(vBox4, 1100, 500);
        Scene keyboardScene =   new Scene(vBox5, 1100, 500);
        Scene mouseScene =   new Scene(vBox6, 1100, 500);
        Scene customerLaptopsScene = new Scene(vbox7, 1100, 500);
        Scene customerMobilePhonesScene = new Scene(vBox8, 1100, 500);
        Scene customerPlaystaionScene = new Scene(vBox9, 1100, 500);
        Scene customerHeadSetsScene = new Scene(vBox10, 1100, 500);
        Scene customerKeyboardScene =   new Scene(vBox11, 1100, 500);
        Scene customerMouseScene =   new Scene(vBox12, 1100, 500);


// BUTTONS ACTIONS
        laptopsButton.setOnAction(e->{
            stage.setScene(laptopsScene);
        });
        mobilePhonesButton.setOnAction(e->{
            stage.setScene(mobilePhonesScene);
        });
        playstationButton.setOnAction(e->{
            stage.setScene(playstaionScene);
        });
        //adjust pane of choices page
        mainPage.getChildren().addAll(laptopsButton,mobilePhonesButton);
        hBox2.getChildren().addAll(playstationButton,accessoriesChoiceBox);
        adminScene=  new Scene(vBox,1100,500);
        //stage.setScene(adminScene);



        homefromlapButton.setOnAction(e->
        {
            stage.setScene(adminScene);

        });
        homefrommobButton.setOnAction(e->
        {
            stage.setScene(adminScene);

        });
       homefrompsButton.setOnAction(e->
        {
            stage.setScene(adminScene);

        });
        homefromheadsetsButton.setOnAction(e->
        {
            stage.setScene(adminScene);

        });
        homefromkeyboardButton.setOnAction(e->
        {
            stage.setScene(adminScene);

        });
        homefrommouseButton.setOnAction(e->
        {
            stage.setScene(adminScene);

        });





//handle closing program
       stage.setOnCloseRequest(e ->{
           e.consume();  //allows us to control the flow from here on
            boolean answer= ConfirmBox.display("EXIT","Are you sure you want to leave us </3?");
           if(answer) stage.close();
       });


       accessoriesChoiceBox.getItems().addAll("Headsets","Keyboard","Mouse");
        accessoriesChoiceBox.setValue("Accessories");
        accessoriesChoiceBox.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)-> {
            if(newValue=="Headsets"){
                stage.setScene(headSetsScene);
            }
            else if(newValue=="Keyboard"){
                stage.setScene(keyboardScene);
            }
            else if(newValue=="Mouse"){
                stage.setScene(mouseScene);
            }

        });
Button mainpagefromcheckout= new Button("Go to home page");
mainpagefromcheckout.setOnAction(e->
{
    stage.setScene(customerScene);
});
        VBox vBox13 = new VBox();
        HBox hBox13 = new HBox();
        HBox hBox14 = new HBox();
        Button customerLaptopsBtn= new Button("Laptops");
        customerLaptopsBtn.setStyle("-fx-font-size: 20px; -fx-min-width: 200px; -fx-min-height: 100px;");
        Button customerMobilePhonesBtn= new Button("Mobile Phones");
        customerMobilePhonesBtn.setStyle("-fx-font-size: 20px; -fx-min-width: 200px; -fx-min-height: 100px;");

        Button customerPlaystaionBtn= new Button("Playstaion");
        customerPlaystaionBtn.setStyle("-fx-font-size: 20px; -fx-min-width: 200px; -fx-min-height: 100px;");



        customerLaptopsBtn.setOnAction(e->stage.setScene(customerLaptopsScene));
        customerMobilePhonesBtn.setOnAction(e->stage.setScene(customerMobilePhonesScene));
        customerPlaystaionBtn.setOnAction(e->stage.setScene(customerPlaystaionScene));
        ChoiceBox<String> customerAccChoiceBox=new ChoiceBox();
customerAccChoiceBox.setStyle("-fx-font-size: 20px; -fx-min-width: 200px; -fx-min-height: 100px;");
        customerAccChoiceBox.getItems().addAll("Headsets","Keyboard","Mouse");
        customerAccChoiceBox.setValue("Accessories");
        customerAccChoiceBox.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)-> {
            if(newValue=="Headsets"){
                stage.setScene(customerHeadSetsScene);
            }
            else if(newValue=="Keyboard"){
                stage.setScene(customerKeyboardScene);
            }
            else if(newValue=="Mouse"){
                stage.setScene(customerMouseScene);
            }

        });


        hBox13.setSpacing(30);
        hBox14.setSpacing(30);
        vBox13.setSpacing(30);
        hBox13.getChildren().addAll(customerLaptopsBtn,customerMobilePhonesBtn);
        hBox14.getChildren().addAll(customerPlaystaionBtn,customerAccChoiceBox);
        vBox13.getChildren().addAll(hBox13,hBox14,back_from_customer);
        hBox14.setAlignment(Pos.CENTER);
        hBox13.setAlignment(Pos.CENTER);
        vBox13.setAlignment(Pos.CENTER);

      customerScene =   new Scene(vBox13, 1100, 500);


        backButton1.setOnAction(e->
        {
            stage.setScene(customerScene);

        });
        backButton2.setOnAction(e->
        {
            stage.setScene(customerScene);

        });
        backButton3.setOnAction(e->
        {
            stage.setScene(customerScene);

        });
        backButton4.setOnAction(e->
        {
            stage.setScene(customerScene);

        });
        backButton5.setOnAction(e->
        {
            stage.setScene(customerScene);

        });
        backButton6.setOnAction(e->
        {
            stage.setScene(customerScene);

        });

        back_from_admin.setOnAction(e->{
            stage.setScene(mainScene);
        });

        back_from_customer.setOnAction(e->{
            stage.setScene(mainScene);
        });
        vBox.getChildren().addAll(mainPage, hBox2,back_from_admin);

////////////////////////////////////////////////////////////////////////////



//*******************************************************************************//
//Back button in cartButton3 scene
        Button backButtoncart = new Button("Back");
        backButtoncart.setOnAction(e -> stage.setScene(customerScene));
//Go to payment button
        Button goToPaymentButton = new Button("Go To Payment");


        gridPane.add(totalPriceLabel, 0, 2);


        Button clearCart = new Button("Clear Cart");
        clearCart.setOnAction(e-> {
            cartList.getItems().clear();
            productArrayList.clear();
        });
        GridPane.setConstraints(clearCart, 3, 4);
        Label yourCartLabel = new Label("Shopping CART!");
        //totalPriceLabel.setText();
        //Grid Pane in the cartButton3 scene

        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);
        yourCartLabel.setStyle("-fx-font-size: 15pt;");
        GridPane.setConstraints(yourCartLabel, 0, 0,3,1);
        GridPane.setConstraints(backButtoncart, 0, 4);
        GridPane.setConstraints(goToPaymentButton, 2, 4);
      //  GridPane.setConstraints(removeFromCart, 0, 2);
        GridPane.setConstraints(cartList, 0, 1, 3, 1); // Spanning 3 columns and 1 row
        totalPriceLabel.setStyle("-fx-font-size: 15pt;");
        GridPane.setConstraints(totalPriceLabel, 0, 3, 3, 1); // Spanning 2 columns and 1 row
        cartList.setStyle("-fx-font-size: 12pt;");
        gridPane.getChildren().addAll(backButtoncart,goToPaymentButton,cartList,yourCartLabel,clearCart);
        Label labeltotalpriceco=new Label();
        goToPaymentButton.setOnAction(e-> {
            stage.setScene(scene);
           labeltotalpriceco.setText(String.valueOf(totalprice));
        });

        TextField nameField1 = new TextField();
        nameField1.setStyle("-fx-border-color: #070707; -fx-border-width: 1px;");
        nameField1.setPromptText("Full Name");

        TextField numberField = new TextField();
        numberField.setStyle("-fx-border-color: #070707; -fx-border-width: 1px;");
        numberField.setPromptText("Your Phone Number");

        TextField addressField = new TextField();
        addressField.setStyle("-fx-border-color: #070707; -fx-border-width: 1px;");
        addressField.setPromptText("Address");

        TextField emailField = new TextField();
        emailField.setStyle("-fx-border-color: #070707; -fx-border-width: 1px;");
        emailField.setPromptText("Email");

        TextField offerField = new TextField();
        offerField.setStyle("-fx-border-color: #070707; -fx-border-width: 1px;");
        offerField.setPromptText("Promo Code");

        // payment method buttons
        Button payOnDeliveryButton = new Button("Pay On Delivery");
        Button creditButton = new Button("Pay with Credit");
        Button backFromCheckOutButton = new Button("Back");
        Button promoButton = new Button("->");

promoButton.setOnAction(e->{
    if(offerField.getText().equals("mazen20"))
    {double x=Double.parseDouble(labeltotalpriceco.getText());
        labeltotalpriceco.setText(String.valueOf(x-(0.2*x)));
    }
    else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setHeaderText("Input Validation Error");
        alert.setContentText("Please input a valid promocode");
        alert.showAndWait();

    }
});
        backFromCheckOutButton.setOnAction(e->{
            stage.setScene(cartScene);
        });


        // Create a layout and add components
        GridPane gridPane1 = new GridPane();
        gridPane1.setVgap(10);
        gridPane1.setHgap(10);
        gridPane1.setAlignment(Pos.CENTER);

        gridPane1.add(new Label("Name:"), 0, 0);
        gridPane1.add(nameField1, 1, 0);

        gridPane1.add(new Label("Phone Number:"), 0, 1);
        gridPane1.add(numberField, 1, 1);

        gridPane1.add(new Label("Address:"), 0, 2);
        gridPane1.add(addressField, 1, 2);

        gridPane1.add(new Label("Email:"), 0, 3);
        gridPane1.add(emailField, 1, 3);

        gridPane1.add(new Label("Promo Code:"), 0, 4);
        gridPane1.add(offerField, 1, 4);

        gridPane1.add(new Label("Total Price:"), 0, 5);

        gridPane1.add(labeltotalpriceco, 1, 5);

        gridPane1.add(promoButton,2,4);
        VBox buttonBox = new VBox(10);

        buttonBox.getChildren().addAll(payOnDeliveryButton, creditButton,backFromCheckOutButton);
        gridPane1.add(buttonBox, 1, 6);

        // Event handling for "Pay on Delivery"
        payOnDeliveryButton.setOnAction(event -> {
            try {
                validateFields(nameField1.getText(), addressField.getText(), emailField.getText(),numberField.getText()); // Validate fields
                validateName(nameField1.getText());
                customer.setCustomerName(nameField1.getText()); // Update Customer with user input
                customer.setCustomerAddress(addressField.getText());
                customer.setCustomerEmail(emailField.getText());

                if(addressField.getText().contains("cairo")||addressField.getText().contains("Cairo")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Cash Payment");
                    alert.setHeaderText("Thank You For Shopping With Us");
                    alert.setContentText("Your Delivery fees is $50");
                    Optional<ButtonType> result = alert.showAndWait();
                    ButtonType button = result.orElse(ButtonType.CANCEL);

                    if (button == ButtonType.OK) {
                        stage.setScene(customerScene);
                    }
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Cash Payment");
                    alert.setHeaderText("Thank You For Shopping With Us");
                    alert.setContentText("Your Delivery fees is $80");
                    //alert.showAndWait();
                    Optional<ButtonType> result = alert.showAndWait();
                    ButtonType button = result.orElse(ButtonType.CANCEL);

                    if (button == ButtonType.OK) {
                        stage.setScene(customerScene);
                    }
                }

            }catch (ValidationException | InvalidNameException e){
                showError(e.getMessage());
            }

        });

        // Event handling for "Pay with Credit" (opens a new window)
        creditButton.setOnAction(event -> {
            try{
                validateFields(nameField1.getText(), addressField.getText(), emailField.getText(),numberField.getText()); // Validate fields
                validateName(nameField1.getText());
                // Update the Customer instance with user input
                customer.setCustomerName(nameField1.getText());
                customer.setCustomerAddress(addressField.getText());
                customer.setCustomerEmail(emailField.getText());

                Stage creditStage = new Stage();

                GridPane creditGrid = new GridPane();
                creditGrid.setVgap(10);
                creditGrid.setHgap(10);


                TextField cardHolderField = new TextField();
                cardHolderField.setStyle("-fx-border-color: #070707; -fx-border-width: 1px;");
                cardHolderField.setPromptText("Card Holder Name");

                PasswordField cvvField = new PasswordField();
                cvvField.setStyle("-fx-border-color: #070707; -fx-border-width: 1px;");
                cvvField.setPromptText("CVV");

                creditGrid.add(new Label("Card Number:"), 0, 0);
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
                    Optional<ButtonType> result = alert.showAndWait();
                    ButtonType button = result.orElse(ButtonType.CANCEL);

                    if (button == ButtonType.OK) {
                        stage.setScene(customerScene);
                    }
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

        scene = new Scene(gridPane1, 1100, 500);
        stage.setResizable(false);



        ///////////////////////////////////////////////////////////////////////////


        //launching
        stage.show();

    }

    public void Totalprice(double total){
        totalprice+=total;
    }


    //get all of the products
    public ObservableList<Laptops> get1product(){
        laptops= FXCollections.observableArrayList();
        laptops.add(new Laptops("hp",50000,1,"i7",15.6));
        laptops.add(new Laptops("lenovo",30000,2,"i5",14));
        laptops.add(new Laptops("Asus",60000,5,"i9",17));
        Product_initial.add(new Laptops("hp",50000,3,"i7",15.6));
        Product_initial.add(new Laptops("lenovo",30000,4,"i5",14));
        Product_initial.add(new Laptops("Asus",60000,5,"i9",17));
        return laptops;

    }
    public ObservableList<MobilePhones> get2product(){
        mobiles= FXCollections.observableArrayList();
        mobiles.add(new MobilePhones("iphone",10000,5,2,128,"4G"));
        mobiles.add(new MobilePhones("LC",6000,8,3,256,"3G"));
        Product_initial.add(new MobilePhones("iphone",10000,6,2,128,"4G"));
        Product_initial.add(new MobilePhones("iphone",10000,6,2,128,"4G"));
        return mobiles;

    }



   public ObservableList<PlayStation> get3product(){
        playstation= FXCollections.observableArrayList();
       playstation.add(new PlayStation("ps5",15000,7,"2020"));
       playstation.add(new PlayStation("ps4",14000,6,"2018"));
       Product_initial.add(new PlayStation("ps5",15000,8,"2020"));
       Product_initial.add(new PlayStation("ps4",14000,6,"2018"));
        return playstation;
    }



    public ObservableList<HeadSets> get4product(){
        headSets= FXCollections.observableArrayList();
        headSets.add(new HeadSets("p9",500,9,"wireless",true,true));
        headSets.add(new HeadSets("AppleMax",10000,5,"wireless",false,true));
        Product_initial.add(new HeadSets("p9",500,10,"wireless",true,true));
        Product_initial.add(new HeadSets("AppleMax",10000,5,"wireless",false,true));
        return headSets;

    }

    public ObservableList<Keyboard> get5product(){
        keyboards= FXCollections.observableArrayList();
         keyboards.add(new Keyboard("key1",200,3,"wired",true,"Black"));
         keyboards.add(new Keyboard("key2",700,5,"wireless",false,"Blue"));
        Product_initial.add(new Keyboard("key1",200,4,"wired",true,"Black"));
        Product_initial.add(new Keyboard("key2",700,5,"wireless",false,"Blue"));
        return keyboards;

    }
    public ObservableList<Mouse> get6product(){
        mouse= FXCollections.observableArrayList();
         mouse.add(new Mouse("mouse1",150,5,"wireless",true,7000));
         mouse.add(new Mouse("mouse2",300,4,"wireless",false,5000));
        Product_initial.add(new Mouse("mouse1",150,7,"wireless",true,7000));
        Product_initial.add(new Mouse("mouse2",300,4,"wireless",false,5000));
        return mouse;

    }


    private void additem_laptop(){
        Laptops laptop =new Laptops();     //new onject of laptops class
        laptop.setName(name1input.getText());
        laptop.setPrice(Double.parseDouble(price1input.getText()));
        laptop.setInStock(Integer.parseInt(quantity1input.getText()));
        laptop.setProcessor(processorinput.getText());
        laptop.setScreenSize(Double.parseDouble(screeninput.getText()));
        table1.getItems().add(laptop);
        //Admin.addItem(laptop);
        laptopsObservableList.add(laptop);
        name1input.clear();
        price1input.clear();
        quantity1input.clear();
        processorinput.clear();
        screeninput.clear();

    }

    public void deleteitem_laptop(){
        ObservableList<Laptops>allproducts,productsselected;
        Laptops lap=new Laptops();
        allproducts=table1.getItems();
        productsselected=table1.getSelectionModel().getSelectedItems();
        lap=productsselected.get(0);
        laptops.remove(productsselected);
        //laptopsObservableList.remove(productsselected);
        productsselected.forEach(allproducts::remove);

    }
    public void deleteitem_headsets(){
        ObservableList<HeadSets>allproducts,productsselected;
        allproducts=table4.getItems();
        productsselected=table4.getSelectionModel().getSelectedItems();
        headSets.remove(productsselected);
        productsselected.forEach(allproducts::remove);

    }
    public void deleteitem_keyboard(){
        ObservableList<Keyboard>allproducts,productsselected;
        allproducts=table5.getItems();
        productsselected=table5.getSelectionModel().getSelectedItems();
        keyboards.remove(productsselected);
        productsselected.forEach(allproducts::remove);

    }
    public void deleteitem_mouse(){
        ObservableList<Mouse>allproducts,productsselected;
        allproducts=table6.getItems();
        productsselected=table6.getSelectionModel().getSelectedItems();
        mouse.remove(productsselected);
        productsselected.forEach(allproducts::remove);

    }
    private void additem_mobiles(){
        MobilePhones mobile =new MobilePhones(); //new onject of laptops class
        mobile.setName(name2input.getText());
        mobile.setPrice(Double.parseDouble(price2input.getText()));
        mobile.setInStock(Integer.parseInt(quantity2input.getText()));
        mobile.setNumberOfCameras(Integer.parseInt(noofcamerasinput.getText()));
        mobile.setStorage(Integer.parseInt(storageinput.getText()));
        mobile.setCellular(cellinput.getText());

        table2.getItems().add(mobile);
        //laptops.add(laptop);
        mobilePhonesObservableList.add(mobile);
        name2input.clear();
        price2input.clear();
        quantity2input.clear();
        noofcamerasinput.clear();
        storageinput.clear();
        cellinput.clear();

    }

    public void deleteitem_mobiles(){
        ObservableList<MobilePhones>allproducts,productsselected;
        allproducts=table2.getItems();
        productsselected=table2.getSelectionModel().getSelectedItems();
        mobiles.remove(productsselected);
        productsselected.forEach(allproducts::remove);

    }

    private void additem_playstation(){
        PlayStation ps=new PlayStation() ;   //new onject of laptops class
        ps.setName(name3input.getText());
        ps.setPrice(Double.parseDouble(price3input.getText()));
        ps.setInStock(Integer.parseInt(quantity3input.getText()));
        ps.setModel(modelinput.getText());
        table3.getItems().add(ps);
        //laptops.add(laptop);
        playStationObservableList.add(ps);
        name3input.clear();
        price3input.clear();
        quantity3input.clear();
        modelinput.clear();

    }

    public void deleteitem_playstation(){
        ObservableList<PlayStation>allproducts,productsselected;
        allproducts=table3.getItems();
        productsselected=table3.getSelectionModel().getSelectedItems();
        playstation.remove(productsselected);
        productsselected.forEach(allproducts::remove);

    }
    public void additem_headsets(){
        HeadSets headSets=new HeadSets() ;   //new onject of laptops class
        headSets.setName(name4input.getText());
        headSets.setPrice(Double.parseDouble(price4input.getText()));
        headSets.setInStock(Integer.parseInt(quantity4input.getText()));
        headSets.setConnectionType(connection1input.getText());
        headSets.setLedRGB(Boolean.parseBoolean(led1input.getText()));
        headSets.setNoiseCancellation(Boolean.parseBoolean(Noiseinput.getText()));
        ///////////////////////////////////////////////////////////////////////
        table4.getItems().add(headSets);
        //laptops.add(laptop);
        HeadsetsObservableList.add(headSets);
        name4input.clear();
        price4input.clear();
        quantity4input.clear();
        modelinput.clear();
    }
    public void additem_keyboard(){
        Keyboard keyboard = new Keyboard();
        keyboard.setName(name5input.getText());
        keyboard.setPrice(Double.parseDouble(price5input.getText()));
        keyboard.setInStock(Integer.parseInt(quantity5input.getText()));
        keyboard.setConnectionType(connection2input.getText());
        keyboard.setLedRGB(Boolean.parseBoolean(led2input.getText()));
        keyboard.setSwitchesType(switchesinput.getText());
        table5.getItems().add(keyboard);
        //laptops.add(laptop);
        keyboardObservableList.add(keyboard);
        name5input.clear();
        price5input.clear();
        quantity5input.clear();
        modelinput.clear();
    }
    public void additem_mouse(){
       Mouse mouse=new Mouse();
        mouse.setName(name6input.getText());
        mouse.setPrice(Double.parseDouble(price6input.getText()));
        mouse.setInStock(Integer.parseInt(quantity6input.getText()));
        mouse.setConnectionType(connection3input.getText());
        mouse.setLedRGB(Boolean.parseBoolean(led3input.getText()));
        mouse.setSensitivity(Double.parseDouble(sensitivityinput.getText()));
        table6.getItems().add(mouse);
        //laptops.add(laptop);
        MouseObservableList.add(mouse);
        name6input.clear();
        price6input.clear();
        quantity6input.clear();
        modelinput.clear();
    }

    private TableView<Laptops> createTableView1(ObservableList<Laptops> data) {
        TableView<Laptops> tableView = new TableView<>();
        TableColumn<Laptops,String> name1column=new TableColumn<>("Name");
        name1column.setMinWidth(200);
        name1column.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Laptops,Double> pricecolumn=new TableColumn<>("price");
        pricecolumn.setMinWidth(100);
        pricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Laptops,Integer> quantitycolumn=new TableColumn<>("Quantity");
        quantitycolumn.setMinWidth(100);
        quantitycolumn.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        TableColumn<Laptops,String> processorcol =new TableColumn<>("Processor");
        processorcol.setMinWidth(100);
        processorcol.setCellValueFactory(new PropertyValueFactory<>("processor"));

        TableColumn<Laptops,Double> screencol =new TableColumn<>("ScreenSize");
        screencol.setMinWidth(100);
        screencol.setCellValueFactory(new PropertyValueFactory<>("screenSize"));


        tableView.getColumns().addAll(name1column,pricecolumn,quantitycolumn, processorcol,screencol);

        tableView.setItems(data);
        return tableView;
    }

    private TableView<MobilePhones> createTableView2(ObservableList<MobilePhones> data) {
        TableView<MobilePhones> tableView = new TableView<>();

        TableColumn<MobilePhones,String> name2column=new TableColumn<>("Name");
        name2column.setMinWidth(200);
        name2column.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<MobilePhones,Double> price2column=new TableColumn<>("price");
        price2column.setMinWidth(100);
        price2column.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<MobilePhones,Integer> quantity2column=new TableColumn<>("Quantity");
        quantity2column.setMinWidth(100);
        quantity2column.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        TableColumn<MobilePhones,Integer> camerano =new TableColumn<>("no of cameras");
        camerano.setMinWidth(100);
        camerano.setCellValueFactory(new PropertyValueFactory<>("numberOfCameras"));


        TableColumn<MobilePhones,Integer> storage =new TableColumn<>("Storage");
        storage.setMinWidth(100);
        storage.setCellValueFactory(new PropertyValueFactory<>("storage"));

        TableColumn<MobilePhones,String> cell =new TableColumn<>("cellular");
        cell.setMinWidth(100);
        cell.setCellValueFactory(new PropertyValueFactory<>("cellular"));


        tableView.getColumns().addAll(name2column,price2column,quantity2column, camerano,storage,cell);
        tableView.setItems(data);
        return tableView;
    }

    private TableView<PlayStation> createTableView3(ObservableList<PlayStation> data) {
        TableView<PlayStation> tableView = new TableView<>();

        TableColumn<PlayStation,String> name3column=new TableColumn<>("Name");
        name3column.setMinWidth(200);
        name3column.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<PlayStation,Double> price3column=new TableColumn<>("price");
        price3column.setMinWidth(100);
        price3column.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<PlayStation,Integer> quantity3column=new TableColumn<>("Quantity");
        quantity3column.setMinWidth(100);
        quantity3column.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        TableColumn<PlayStation,String> model =new TableColumn<>("ps model");
        model.setMinWidth(100);
        model.setCellValueFactory(new PropertyValueFactory<>("model"));


        tableView.getColumns().addAll(name3column,price3column,quantity3column, model);
        tableView.setItems(data);
        return tableView;
    }



    private TableView<HeadSets> createTableView4(ObservableList<HeadSets> data) {
        TableView<HeadSets> tableView = new TableView<>();
        TableColumn<HeadSets,String> name4column=new TableColumn<>("Name");   //Keyboard
        name4column.setMinWidth(200);
        name4column.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<HeadSets,Double> price4column=new TableColumn<>("price");
        price4column.setMinWidth(100);
        price4column.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<HeadSets,Integer> quantity4column=new TableColumn<>("Quantity");
        quantity4column.setMinWidth(100);
        quantity4column.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        TableColumn<HeadSets,String> connectiontype1 =new TableColumn<>("connection type");
        connectiontype1.setMinWidth(100);
        connectiontype1.setCellValueFactory(new PropertyValueFactory<>("connectionType"));

        TableColumn<HeadSets,Boolean> rgbled1 =new TableColumn<>("RGB LED");
        rgbled1.setMinWidth(100);
        rgbled1.setCellValueFactory(new PropertyValueFactory<>("ledRGB"));

        TableColumn<HeadSets,Boolean> noisecancellation =new TableColumn<>("noise cancellation");
        noisecancellation.setMinWidth(100);
        noisecancellation.setCellValueFactory(new PropertyValueFactory<>("noiseCancellation"));

        tableView.getColumns().addAll(name4column,price4column,quantity4column,connectiontype1,rgbled1,noisecancellation);
        //keyboards
        tableView.setItems(data);
        return tableView;
    }

    private TableView<Keyboard> createTableView5(ObservableList<Keyboard> data) {
        TableView<Keyboard> tableView = new TableView<>();

        TableColumn<Keyboard,String> name5column=new TableColumn<>("Name");   //Keyboard
        name5column.setMinWidth(200);
        name5column.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Keyboard,Double> price5column=new TableColumn<>("price");
        price5column.setMinWidth(100);
        price5column.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Keyboard,Integer> quantity5column=new TableColumn<>("Quantity");
        quantity5column.setMinWidth(100);
        quantity5column.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        TableColumn< Keyboard,String> connectiontype2 =new TableColumn<>("connection type");
        connectiontype2.setMinWidth(100);
        connectiontype2.setCellValueFactory(new PropertyValueFactory<>("connectionType"));

        TableColumn< Keyboard,Boolean> rgbled2 =new TableColumn<>("RGB LED");
        rgbled2.setMinWidth(100);
        rgbled2.setCellValueFactory(new PropertyValueFactory<>("ledRGB"));

        TableColumn<Keyboard,String> switchesType =new TableColumn<>("switches type");
        switchesType.setMinWidth(100);
        switchesType.setCellValueFactory(new PropertyValueFactory<>("switchesType"));

        tableView.getColumns().addAll(name5column,price5column,quantity5column,connectiontype2,rgbled2,switchesType);
        tableView.setItems(data);
        return tableView;
    }

    private TableView<Mouse> createTableView6(ObservableList<Mouse> data) {
        TableView<Mouse> tableView = new TableView<>();
        TableColumn<Mouse,String> name6column=new TableColumn<>("Name");  // Mouse
        name6column.setMinWidth(200);
        name6column.setCellValueFactory(new PropertyValueFactory<>("name"));



        TableColumn<Mouse,Double> price6column=new TableColumn<>("price");
        price6column.setMinWidth(100);
        price6column.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Mouse,Integer> quantity6column=new TableColumn<>("Quantity");
        quantity6column.setMinWidth(100);
        quantity6column.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        TableColumn<Mouse,String> connectiontype3 =new TableColumn<>("connection type");
        connectiontype3.setMinWidth(100);
        connectiontype3.setCellValueFactory(new PropertyValueFactory<>("connectionType"));

        TableColumn<Mouse,Boolean> rgbled3 =new TableColumn<>("RGB LED");
        rgbled3.setMinWidth(100);
        rgbled3.setCellValueFactory(new PropertyValueFactory<>("ledRGB"));

        TableColumn<Mouse,Double> sensitivity =new TableColumn<>("sensitivity");
        sensitivity.setMinWidth(100);
        sensitivity.setCellValueFactory(new PropertyValueFactory<>("Sensitivity"));
        tableView.getColumns().addAll(name6column,price6column,quantity6column,connectiontype3,rgbled3,sensitivity);
        tableView.setItems(data);
        return tableView;
    }

    public String increment(String s)
    {
        return String.valueOf(Integer.parseInt(s)+1);
    }
    public String decrement(String s)
    {
        return String.valueOf(Integer.parseInt(s)-1);
    }

    // Method to format color values for CSS
    private String formatColor(Color color) {
        return String.format("#%02X%02X%02X", (int) (color.getRed() * 255), (int) (color.getGreen() * 255), (int) (color.getBlue() * 255));
    }

    // Validate if any of the fields are empty
    private void validateFields(String name, String address, String email, String numberField) throws ValidationException {
        if (name.isEmpty() || address.isEmpty() || email.isEmpty() || numberField.isEmpty()) {
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

}
