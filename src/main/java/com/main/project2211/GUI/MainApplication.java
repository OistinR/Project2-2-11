package com.main.project2211.GUI;

import com.main.project2211.GUI.fxelements.ChatScreen;
import com.main.project2211.GUI.fxelements.MainMenu;
import com.main.project2211.GUI.fxelements.PromptResponse;
import com.main.project2211.GUI.fxelements.PromptResponseList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        MainMenu mainMenu = new MainMenu(stage);
        mainMenu.update();

//        ChatScreen cs = new ChatScreen(stage);
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}






