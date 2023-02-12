package com.main.project2211.GUI;

import com.main.project2211.GUI.fxelements.PromptResponse;
import com.main.project2211.GUI.fxelements.PromptResponseList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    private PromptResponseList prList;
    private GridPane gridPane;
    private TextArea inputField;
    private Button submitButton;
    private Text promptsTitle;
    private Scene scene;
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        PromptResponse pr2 = new PromptResponse(gridPane,"You:\n"+"Ipsum consequat nisl vel pretium lectus. Elit scelerisque mauris \npellentesque pulvinar pellentesque habitant morbi.", "Agent:\nEgestas dui id ornare arcu odio ut.\nAliquam faucibus purus in massa tempor nec");
        prList= new PromptResponseList(4);
        prList.add(pr2);
        prList.add(new PromptResponse(gridPane,"You:\n"+"Ut lectus arcu bibendum at varius.", "Agent:\nUt lectus arcu bibendum at varius."));
        stage.setTitle("D.A.C.S Assistant v0.0.1");
        update();
        stage.show();
    }

    public void update(){
        inputField = new TextArea();
        inputField.setMaxHeight(20);
        inputField.setMaxWidth(400);

        submitButton = new Button("Submit");
        gridPane = new GridPane();
        gridPane.setMinSize(600, 720);
        gridPane.setMaxSize(600,720);
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        promptsTitle = new Text("Chat: ");
        promptsTitle.setStyle("-fx-font: 12 arial;");
        gridPane.add(promptsTitle,0,0);

        prList.update(0,1,gridPane);
        inputField.setWrapText(true);
        submitButton.setOnAction(event ->{
            submitPrompt();
        });

        int sharedRowCount = gridPane.getRowCount()+1;
        gridPane.add(inputField,0, sharedRowCount);
        gridPane.add(submitButton,1,sharedRowCount);
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

    public static void main(String[] args) {
        launch();
    }
}






