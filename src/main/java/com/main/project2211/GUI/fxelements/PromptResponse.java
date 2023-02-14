package com.main.project2211.GUI.fxelements;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class PromptResponse {
    private int fontSize =12;
    private GridPane parentPane;
    private Text prompt;
    private Text response;
    private StackPane stackPrompt = new StackPane();
    private StackPane stackResponse = new StackPane();

    public Text getPrompt() {
        return prompt;
    }

    public StackPane getStackPrompt() {
        return stackPrompt;
    }

    public Text getResponse() {
        return response;
    }

    public PromptResponse(GridPane parentPane, String prompt, String response){
        this.parentPane = parentPane;
        this.prompt = new Text(prompt);
        this.response = new Text(response);

    }

    public void setPrompt(String prompt) {
        this.prompt = new Text(prompt);
    }

    public void setResponse(String response) {
        this.response = new Text(response);
    }
    Rectangle backRectanglePrompt;
    Rectangle backRectangleResponse;
    public void update(){
        stackPrompt = new StackPane();
        stackResponse = new StackPane();

        backRectanglePrompt = new Rectangle(0, 0, longestLineCount(prompt.getText()) * 7 + 20, newlineCount(prompt.getText()) * 20);
        backRectanglePrompt.setFill(Color.LIGHTGREEN);
        backRectanglePrompt.setStroke(Color.BLACK);
        backRectanglePrompt.setArcHeight(10);
        backRectanglePrompt.setArcWidth(15);

        backRectangleResponse = new Rectangle(0, 0, longestLineCount(response.getText()) * 7 + 20, newlineCount(response.getText()) * 20);
        backRectangleResponse.setFill(Color.PINK);
        backRectangleResponse.setStroke(Color.BLACK);
        backRectangleResponse.setArcHeight(10);
        backRectangleResponse.setArcWidth(15);

        stackPrompt.getChildren().addAll(backRectanglePrompt, this.prompt);
        stackResponse.getChildren().addAll(backRectangleResponse, this.response);


        prompt.setStyle("-fx-font: "+fontSize+" arial;");
        response.setStyle("-fx-font: "+fontSize+" arial;");

    }

    public void animate(double time){

        ParallelTransition parallelTransition = new ParallelTransition();

        FadeTransition fadeTransition =
                new FadeTransition(Duration.millis(time), backRectanglePrompt);
        fadeTransition.setFromValue(0.4);
        fadeTransition.setToValue(1.0f);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(false);

        TranslateTransition translateTransition =
                new TranslateTransition(Duration.millis(time), backRectanglePrompt);
        translateTransition.setFromX(-500);
        translateTransition.setToX(0);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(false);

        FadeTransition fadeTransition1 =
                new FadeTransition(Duration.millis(time), this.prompt);
        fadeTransition1.setFromValue(0.4);
        fadeTransition1.setToValue(1.0f);
        fadeTransition1.setCycleCount(1);
        fadeTransition1.setAutoReverse(true);

        TranslateTransition translateTransition1 = new TranslateTransition(Duration.millis(time), this.prompt);
        translateTransition1.setFromX(-500);
        translateTransition1.setToX(10);
        translateTransition1.setCycleCount(1);
        translateTransition1.setAutoReverse(true);



        FadeTransition fadeTransitionResponse =
                new FadeTransition(Duration.millis(time), backRectangleResponse);
        fadeTransitionResponse.setFromValue(0.4);
        fadeTransitionResponse.setToValue(1.0f);
        fadeTransitionResponse.setCycleCount(1);
        fadeTransitionResponse.setAutoReverse(false);

        TranslateTransition translateTransitionResponse =
                new TranslateTransition(Duration.millis(time), backRectangleResponse);
        translateTransitionResponse.setFromX(500);
        translateTransitionResponse.setToX(0);
        translateTransitionResponse.setCycleCount(1);
        translateTransitionResponse.setAutoReverse(false);

        FadeTransition fadeTransition1Response =
                new FadeTransition(Duration.millis(time), this.response);
        fadeTransition1Response.setFromValue(0.4);
        fadeTransition1Response.setToValue(1.0f);
        fadeTransition1Response.setCycleCount(1);
        fadeTransition1Response.setAutoReverse(true);

        TranslateTransition translateTransition1Response = new TranslateTransition(Duration.millis(time), this.response);
        translateTransition1Response.setFromX(500);
        translateTransition1Response.setToX(-10);
        translateTransition1Response.setCycleCount(1);
        translateTransition1Response.setAutoReverse(true);


        parallelTransition.getChildren().addAll(
                fadeTransition,
                translateTransition,
                fadeTransition1,
                translateTransition1,
                fadeTransitionResponse,
                translateTransitionResponse,
                fadeTransition1Response,
                translateTransition1Response
        );

        parallelTransition.setCycleCount(1);
        parallelTransition.play();


    }

    public void draw(int i, int i1, GridPane parentPane){
        update();
        parentPane.add(stackPrompt,i,i1);
        parentPane.add(stackResponse,i,i1+1);
        parentPane.add(new Text("\t"),i,i1+2);

//        prompt.setTranslateX(10);
//        response.setTranslateX(-10);
        stackPrompt.setAlignment(Pos.CENTER_LEFT);
        stackResponse.setAlignment(Pos.CENTER_RIGHT);

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

    @Override
    public String toString() {
        return "PromptResponse{" +
                "parentPane=" + parentPane +
                ", prompt=" + prompt +
                ", response=" + response +
                ", stackPrompt=" + stackPrompt +
                ", stackResponse=" + stackResponse +
                '}';
    }
}

