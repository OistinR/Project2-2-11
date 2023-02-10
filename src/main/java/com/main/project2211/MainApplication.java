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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TextField textField2 = new TextField();
        Button button1 = new Button("Submit");
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.TOP_LEFT);

        PromptResponse pr = new PromptResponse(gridPane,"the quick brown fox jumps over the lazy dossssssssssssssssg\nnew line\nnewerline", "test2");
        PromptResponse pr2 = new PromptResponse(gridPane,"test3", "the quick brown fox jumps over the lazy dog\nnew line\nnewerline");
        PromptResponse pr3 = new PromptResponse(gridPane,"test3", "test4");
        PromptResponseList prList= new PromptResponseList(4);
        prList.add(pr);
        prList.add(pr2);
        prList.add(pr3);
        prList.add(new PromptResponse(gridPane,"test6", "test7"));

        prList.update(0,0);
        //Creating a scene object
        Scene scene = new Scene(gridPane);

        //Setting title to the Stage
        stage.setTitle("Grid Pane Example");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}