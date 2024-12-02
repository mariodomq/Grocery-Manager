package com.md.gm.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.awt.*;


public class MainController {
    @FXML
    private Button menuButton;
    @FXML
    private TextField searchTextField;
    @FXML
    private Button viewProfile;
    @FXML
    private VBox sideMenu;
    @FXML
    private AnchorPane mainPage;



    @FXML
    public void initialize() {
        //opens menu panel
        menuButton.setOnAction(event -> openMenu());
        searchTextField.setOnAction(actionEvent -> searchQuery());
        viewProfile.setOnAction(actionEvent -> profileScreen());

    }


    private void searchQuery() {
        //Incorporates search function to search items

    }

    private void openMenu() {
        //Opens side menu
        sideMenu.setVisible(true);
        mainPage.setVisible(false);

    }

    private void profileScreen() {
        //changes screen to view/edit profile

    }




}