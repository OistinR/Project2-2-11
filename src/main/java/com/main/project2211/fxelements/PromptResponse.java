package com.main.project2211.fxelements;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PromptResponse {
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

        Rectangle backRectanglePrompt = new Rectangle(newlineCount(prompt.getText())*20,longestLineCount(prompt.getText())*6,longestLineCount(prompt.getText())*6,newlineCount(prompt.getText())*20);
        backRectanglePrompt.setFill(Color.LIGHTGREY);
        backRectanglePrompt.setStroke(Color.BLACK);
        Rectangle backRectangleResponse = new Rectangle(newlineCount(response.getText())*20,longestLineCount(response.getText())*6,longestLineCount(response.getText())*6,newlineCount(response.getText())*20);
        backRectangleResponse.setFill(Color.LIGHTGREY);
        backRectangleResponse.setStroke(Color.BLACK);

        stackPrompt.getChildren().addAll(backRectanglePrompt,this.prompt);
        stackResponse.getChildren().addAll(backRectangleResponse,this.response);
    }

    public void draw(int i, int i1, GridPane parentPane){
        update();
        parentPane.add(stackPrompt,i,i1);
        parentPane.add(new Text("->"),i+1,i1);
        parentPane.add(stackResponse,i+2,i1);
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

