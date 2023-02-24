package com.main.project2211.GUI.fxelements;

import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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

        final Rectangle rect1 = new Rectangle(10, 10, 100, 100);
        rect1.setArcHeight(20);
        rect1.setArcWidth(20);
        rect1.setFill(Color.RED);
        verticalPane.getChildren().add(rect1);

        ParallelTransition parallelTransition = new ParallelTransition();

        FadeTransition fadeTransition =
                new FadeTransition(Duration.millis(3000), rect1);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(true);
        TranslateTransition translateTransition =
                new TranslateTransition(Duration.millis(2000), rect1);
        translateTransition.setFromY(50);
        translateTransition.setToY(-100);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);

        parallelTransition.getChildren().addAll(
                fadeTransition,
                translateTransition

        );

        parallelTransition.setCycleCount(1);
        parallelTransition.play();


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
