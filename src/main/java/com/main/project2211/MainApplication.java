package com.main.project2211;

import com.main.project2211.fxelements.PromptResponse;
import com.main.project2211.fxelements.PromptResponseList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    private PromptResponseList prList;
    private GridPane gridPane;
    private TextField inputField;
    Button submitButton;
    Text promptsTitle;
    Text ResponseTitle;
    Scene scene;
    Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        //this is for display only
        PromptResponse pr1 = new PromptResponse(gridPane,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do \neiusmod tempor incididunt ut labore et dolore magna aliqua.\nNullam eget felis eget nunc. Morbi tincidunt augue interdum\n velit euismod. Enim ut sem viverra aliquet eget sit amet tellus.\n Sodales neque sodales ut etiam sit.", "Viverra suspendisse potenti nullam ac.");
        PromptResponse pr2 = new PromptResponse(gridPane,"Ipsum consequat nisl vel pretium lectus. Elit scelerisque mauris\n pellentesque pulvinar pellentesque habitant morbi.", "Egestas dui id ornare arcu odio ut.\n Aliquam faucibus purus in massa tempor nec");
        PromptResponse pr3 = new PromptResponse(gridPane,"Egestas dui id ornare arcu odio ut.\n Aliquam faucibus purus in massa tempor nec", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do \neiusmod tempor incididunt ut labore et dolore magna aliqua.\nNullam eget felis eget nunc. Morbi tincidunt augue interdum\n velit euismod. Enim ut sem viverra aliquet eget sit amet tellus.\n Sodales neque sodales ut etiam sit.");
        prList= new PromptResponseList(4);
        prList.add(pr1);
        prList.add(pr2);
        prList.add(pr3);
        prList.add(new PromptResponse(gridPane,"Ut lectus arcu bibendum at varius.", "Ut lectus arcu bibendum at varius."));

        stage.setTitle("D.A.C.S Assistant v0.0.1");
        update();
        stage.show();
    }

    public void update(){
        inputField = new TextField();
        submitButton = new Button("Submit");
        gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.TOP_LEFT);
        promptsTitle = new Text("Prompts: ");
        ResponseTitle = new Text("Responses: ");
        promptsTitle.setStyle("-fx-font: 16 arial;");
        gridPane.add(promptsTitle,0,0);
        ResponseTitle.setStyle("-fx-font: 16 arial;");
        gridPane.add(ResponseTitle,2,0);

        prList.update(0,1,gridPane);

        submitButton.setOnAction(event ->{
            submitPrompt();
        });

        System.out.println(prList.getList().get(0));
        gridPane.add(inputField,0,prList.getSize()+1);
        gridPane.add(submitButton,2,prList.getSize()+1);
        scene = new Scene(gridPane);
        stage.setScene(scene);
    }

    public void submitPrompt(){
        prList.add(new PromptResponse(gridPane,inputField.getText(),"no responses."));
        update();
    }

    public static void main(String[] args) {
        launch();
    }
}