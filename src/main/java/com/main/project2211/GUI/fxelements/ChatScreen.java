package com.main.project2211.GUI.fxelements;

import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ChatScreen {
    private PromptResponseList prList;
    private GridPane gridPane;
    private TextArea inputField;
    private Button submitButton;
    private Button returnButton;
    private Scene scene;
    private Stage stage;
    private int k;

    public ChatScreen(Stage stage){
        this.stage = stage;
        PromptResponse pr2 = new PromptResponse(gridPane,"You:\n"+"Ipsum consequat nisl vel pretium lectus. Elit scelerisque mauris \npellentesque pulvinar pellentesque habitant morbi.", "Agent:\nEgestas dui id ornare arcu odio ut.\nAliquam faucibus purus in massa tempor nec");
        prList= new PromptResponseList(4);
        prList.add(pr2);
        prList.add(new PromptResponse(gridPane,"You:\n"+"Ut lectus arcu bibendum at varius.", "Agent:\nUt lectus arcu bibendum at varius."));
        stage.setTitle("D.A.C.S Assistant v0.0.1");
        k=0;
        update();
    }

    public void update(){
        inputField = new TextArea();
        inputField.setMaxHeight(20);
        inputField.setMaxWidth(400);

        submitButton = new Button("Submit");
        returnButton = new Button("Menu");

        gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: #b8cee0;");
//        gridPane.setGridLinesVisible(true);
        gridPane.setMinSize(700, 650);
        gridPane.setMaxSize(700,650);
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        System.out.println(k);

        prList.update(0,0,gridPane, k);

        if(k==0){
            k=1;
        }

        inputField.setWrapText(true);
        submitButton.setOnAction(event ->{
            submitPrompt();
        });

        returnButton.setOnAction(e->{
            MainMenu menu = new MainMenu(stage);
            menu.update();
        });
        inputField.setTranslateY(10);

        int sharedRowCount = gridPane.getRowCount()+1;

        VBox vbLayout = new VBox();
        vbLayout.setSpacing(5);

        vbLayout.getChildren().addAll(submitButton,returnButton);

        HBox hbLayout = new HBox();
        hbLayout.setPadding(new Insets(10, 10, 10, 10));
        hbLayout.setSpacing(5);
        hbLayout.setStyle("-fx-background-color: #9bcbef;-fx-border-color: black;");

        hbLayout.getChildren().addAll(inputField,vbLayout);

        gridPane.add(hbLayout,0,sharedRowCount);

        submitButton.setAlignment(Pos.CENTER_LEFT);
        scene = new Scene(gridPane);
        stage.setScene(scene);
    }

    public void submitPrompt(){
        if (inputField.getText().length()>150){
            Alert inputSize = new Alert(Alert.AlertType.WARNING);
            inputSize.setTitle("Input length too long");
            inputSize.setContentText("Please use a shorter message.");
            inputSize.showAndWait();
            return;
        }

        if (inputField.getText().length()<2){
            Alert inputSize = new Alert(Alert.AlertType.WARNING);
            inputSize.setTitle("Input length too short");
            inputSize.setContentText("Please use a longer message");
            inputSize.showAndWait();
            return;
        }

        prList.add(new PromptResponse(gridPane,"You:\n"+parseString(inputField.getText()),"Agent:\n"+parseString("No Response")));
        update();
    }

    /** TODO the text from inputfield sometimes cuts words in half. minor issue.
     * @param inputField the textArea we are reading from
     * @return a string which is compatible with PromptResponse
     */
    private String parseString(String inputField){
        String[] lines = inputField.split("\r\n|\r|\n");
        StringBuilder out = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int maxLength = 75;

        for (String str:lines) {
            if (str.length()>=maxLength){
                while(temp.length()<str.length()) {
                    temp.append(str.substring(0,maxLength)).append("\n");
                    str = str.substring(maxLength);
                }
                out.append(temp);
                out.append(str);
                temp = new StringBuilder();
            }

            else
                out.append(str);
        }
        return out.toString();
    }

}
