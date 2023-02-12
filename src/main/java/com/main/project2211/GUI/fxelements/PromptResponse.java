package com.main.project2211.GUI.fxelements;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

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

    public Text getResponse() {
        return response;
    }

    public PromptResponse(GridPane parentPane, String prompt, String response){
        this.parentPane = parentPane;
        this.prompt = new Text(prompt);
        this.response = new Text(response);
        update();

    }

    public void setPrompt(String prompt) {
        this.prompt = new Text(prompt);
    }

    public void setResponse(String response) {
        this.response = new Text(response);
    }

    public void update(){
        stackPrompt = new StackPane();
        stackResponse = new StackPane();
        //types of font
//        System.out.println(
//        Font.getFamilies());


        prompt.setStyle("-fx-font: "+fontSize+" arial;");
        response.setStyle("-fx-font: "+fontSize+" arial;");

        Rectangle backRectanglePrompt = new Rectangle(0,0,longestLineCount(prompt.getText())*7+ 20,newlineCount(prompt.getText())*20);
        backRectanglePrompt.setFill(Color.LIGHTGREEN);
        backRectanglePrompt.setStroke(Color.BLACK);
        backRectanglePrompt.setArcHeight(30);
        backRectanglePrompt.setArcWidth(30);

        Rectangle backRectangleResponse = new Rectangle(0,0,longestLineCount(response.getText())*7+20,newlineCount(response.getText())*20);
        backRectangleResponse.setFill(Color.PINK);
        backRectangleResponse.setStroke(Color.BLACK);
        backRectangleResponse.setArcHeight(30);
        backRectangleResponse.setArcWidth(30);

        stackPrompt.getChildren().addAll(backRectanglePrompt,this.prompt);
        stackResponse.getChildren().addAll(backRectangleResponse,this.response);
    }

    public void draw(int i, int i1, GridPane parentPane){
        update();
        parentPane.add(stackPrompt,i,i1);

        parentPane.add(stackResponse,i,i1+1);
        parentPane.add(new Text("\t"),i,i1+2);
        prompt.setTranslateX(10);
        response.setTranslateX(-10);
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

