package com.main.project2211.GUI.fxelements;

import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
        PromptResponse pr2 = new PromptResponse(gridPane,"You:\n"+parseString("Ipsum consequat nisl vel pretium lectus. Elit scelerisque mauris pellentesque pulvinar pellentesque habitant morbi."), "Agent:\n"+parseString("Egestas dui id ornare arcu odio ut.Aliquam faucibus purus in massa tempor nec"));
        prList= new PromptResponseList(20);
        prList.add(pr2);
        prList.add(new PromptResponse(gridPane,"You:\n"+parseString("Ut lectus arcu bibendum at varius."), "Agent:\n"+parseString("Ut lectus arcu bibendum at varius.")));
        stage.setTitle("D.A.C.S Assistant v0.0.1");
        k=0;
        update();
    }

    public void update(){
        inputField = new TextArea();
        inputField.setMaxHeight(20);
        inputField.setMaxWidth(300);

        submitButton = new Button("Submit");
        returnButton = new Button("Menu");

        gridPane = new GridPane();

//        gridPane.setGridLinesVisible(true);

        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

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

        int sharedRowCount = gridPane.getRowCount()+1;


        HBox hbLayout = new HBox();
        hbLayout.setPadding(new Insets(10, 10, 10, 10));
        hbLayout.setSpacing(5);
        hbLayout.setStyle("-fx-background-color:#D97B38;");

        hbLayout.getChildren().addAll(inputField,submitButton,returnButton);
        submitButton.setTranslateY(5);
        returnButton.setTranslateY(5);

        gridPane.add(hbLayout,0,sharedRowCount);
        gridPane.setMinSize(450, 0 );
        ScrollPane sp = new ScrollPane(gridPane);

        VBox vbLayoutOuter = new VBox();
        vbLayoutOuter.getChildren().addAll(sp,hbLayout);
        sp.setMinSize(450, 0 );
        sp.setMaxHeight(500);
        sp.setFitToWidth(true);
        sp.setVvalue(1);

        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        gridPane.setStyle("-fx-background-color: #F3CDB2;");
        sp.setStyle("-fx-background-color: #F3CDB2;");
        vbLayoutOuter.setStyle("-fx-background-color: #F3CDB2;");

        scene = new Scene(vbLayoutOuter);
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

        prList.add(new PromptResponse(gridPane,"You:\n"+parseString(inputField.getText()),"Agent:\n"+parseString("asdasllkjhasd asd askjha;skd kajsdh askjdh kajsdhkjsh a;kjsdhk jsahdakjh a;ksjdhkja hsdkjh askjdh kajsdh ")));
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
        int maxLength = 60;

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
        System.out.println(out);
        return out.toString();
    }

}
