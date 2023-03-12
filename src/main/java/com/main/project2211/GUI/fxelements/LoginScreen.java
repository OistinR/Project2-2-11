package com.main.project2211.GUI.fxelements;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginScreen {


    static TextArea skills_area = new TextArea();

    private final Insets DEFAULTINSETS = new Insets(5, 5, 5, 5);
    Stage stage;
    public LoginScreen(Stage stage){
        this.stage = stage;
        stage.setX(50);
        stage.setY(50);
        GridPane gp = new GridPane();

        Scene scene = new Scene(gp);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
