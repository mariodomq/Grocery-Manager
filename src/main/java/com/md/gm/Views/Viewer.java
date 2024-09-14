package com.md.gm.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Viewer {
    // Client Views

    private AnchorPane dashboardView;

    public Viewer() {}

     //Checker fo already built Views
    public AnchorPane getDashboardView() {


        if (dashboardView == null) {

            try {
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Client/Dashboard.fxml")).load();

            } catch (IOException e) {
                //prints found exceptions
                e.printStackTrace();
            }
        }
         //returns built view
        return dashboardView;
    }

    //login window
    public void showLoginWindow() {

        //loads Login.fxml
        FXMLLoader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        Scene scene = null;

        //basic error catcher
        try {

            scene = new Scene(loader.Load());
        } catch (Exception e) {

            e.printStackTrace();
        }

        //New scene creation
        Stage stage = new Stage();
        stage .setScene(scene);
        stage.setTitle("Login");
        stage.show();

    }


}
