package com.main.project2211.GUI.fxelements;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MessagePopUp{

    private Rectangle backgroundRect;
    private Label messageText;
    //this is not working need to rework it but alot of ground work is done.
    public StackPane displayPopUp(String message, Stage stage){
        messageText = new Label(message);
        double scalePrompt = (longestLineCount(messageText.getText())+4)*5.5 ;
        backgroundRect = new Rectangle(0, 0, scalePrompt , (newlineCount(messageText.getText()) * 20)+5);
        StackPane defaultSP = new StackPane();

        backgroundRect.setFill(Color.LIGHTGRAY);
        backgroundRect.setArcHeight(10);
        backgroundRect.setArcWidth(10);
        backgroundRect.setOpacity(1);

        defaultSP.getChildren().addAll(backgroundRect,messageText);

        TranslateTransition tt = new TranslateTransition(Duration.millis(1000),defaultSP);

        tt.setFromY(0);
        tt.setFromX(-200);
        tt.setToX(-30);
        tt.setToY(0);


        FadeTransition ft = new FadeTransition(Duration.millis(4000), defaultSP);
        ft.setFromValue(1);
        ft.setToValue(0);

        SequentialTransition st = new SequentialTransition(tt,ft);
        st.play();

       return defaultSP;

    }

    private int newlineCount(String string){
        String[] lines = string.split("\r\n|\r|\n");
        return  lines.length;
    }

    private int longestLineCount(String string){
        String[] lines = string.split("\r\n|\r|\n");
        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length()>max){
                max = lines[i].length();
            }
        }
        return  max;
    }

}
