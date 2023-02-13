package com.main.project2211.GUI.fxelements;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu {
    private VBox verticalPane;
    private Stage stage;
    private Button chatButton;
    private Button skillsEditorButton;
    private Button exitButton;


    public MainMenu(Stage stage){
        this.stage = stage;
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
            Alert inputSize = new Alert(Alert.AlertType.INFORMATION);
            inputSize.setTitle("Not implemented");
            inputSize.setContentText("No method implemented");
            inputSize.showAndWait();
        });

        exitButton.setOnAction(e->{
            System.exit(0);
        });


        verticalPane.getChildren().addAll(chatButton, skillsEditorButton, exitButton);

        stage.setScene(new Scene(verticalPane));
    }

    private void gotoChat(){
        ChatScreen chat = new ChatScreen(stage);
        chat.update();
    }


}
