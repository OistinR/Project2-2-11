package com.main.project2211.GUI.fxelements;

import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenu {
    private VBox verticalPane;
    private Stage stage;
    private Button chatButton;
    private Button skillsEditorButton;
    private Button exitButton;


    public MainMenu(Stage stage){
        this.stage = stage;
        stage.setX(735);
        stage.setY(300);
        verticalPane = new VBox();
        chatButton = new Button("Assistant");
        skillsEditorButton = new Button("Skills Editor");
        exitButton = new Button("Exit");
    }

    public void update(){

        verticalPane.setMinSize(200,300);
        verticalPane.setAlignment(Pos.CENTER);
        verticalPane.setSpacing(20);

        chatButton.setOnAction(e->{
            gotoChat();
        });

        skillsEditorButton.setOnAction(e->{
            gotoSkills();
        });

        exitButton.setOnAction(e->{
            System.exit(0);
        });


        verticalPane.getChildren().addAll(chatButton, skillsEditorButton, exitButton);


        stage.setScene(new Scene(verticalPane));
        stage.setResizable(false);
    }

    private void gotoChat(){
        ChatScreen chat = new ChatScreen(stage);

    }
    private void gotoSkills(){
        SkillEditor skill = new SkillEditor(stage);
    }


}
