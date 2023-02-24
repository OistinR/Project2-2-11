package com.main.project2211.GUI.fxelements;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class SkillEditor {
    private Button Menubutton;
    private Button addbutton;
    private Button resetAll;
    private Button removeLast;
    private Stage stage;
    TextArea current_skills = new TextArea();
    TextArea new_skills = new TextArea();

    public SkillEditor(Stage stage){

        this.stage = stage;
        stage.setX(350);
        stage.setY(300);
        Menubutton = new Button("Menu");
        Menubutton.setMinWidth(200); 
        addbutton = new Button("Add");
        addbutton.setMinWidth(200); 
        resetAll = new Button("Reset");
        resetAll.setMinWidth(75);
        removeLast = new Button("Remove last");
        removeLast.setMinWidth(75);
        VBox root = new VBox();
        HBox root2 = new HBox();
        HBox root3 = new HBox();
        current_skills.setEditable(false);
        textIntoTextField("skillsFile.txt");


        addbutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               
                if(new_skills.getText().equals("")){
                    Alert inputSize = new Alert(Alert.AlertType.WARNING);
                    inputSize.setTitle("Nothing has been written");
                    inputSize.setContentText("Please write a skill");
                    inputSize.showAndWait();
                    return;
                }else { 
                    String s = new_skills.getText();

                    for(int i = 0; i < s.length(); i++){
                        for(int j = i; j < s.length(); j++){
                            
                            if(s.charAt(j) == '.'){
                                if(s.charAt(i) == '\n'){
                                    String sub = s.substring(i, j+1);
                                    sub = sub.replace("\n", "").replace("\r", "");
                                    current_skills.appendText(sub + "\n");
                                    new_skills.clear();
                                    i = j+1;
                                    writeIntoTextFiles(); 
                                }
                                else if(s.charAt(i) == ' '){
                                    String sub = s.substring(i, j+1);
                                    current_skills.appendText(sub + "\n");
                                    new_skills.clear();
                                    i = j+1;
                                    writeIntoTextFiles();
                                }
                                else{
                                    String sub = s.substring(i, j+1);
                                    current_skills.appendText(sub + "\n");
                                    new_skills.clear();
                                    i = j+1;
                                    writeIntoTextFiles();
                                }
                                
                               
                            } 
                            else if(!s.contains(".")){ 
                                Alert inputSize = new Alert(Alert.AlertType.WARNING);
                                inputSize.setTitle("Do not know the end of the sentence");
                                inputSize.setContentText("Please finish your sentence with a dot");
                                inputSize.showAndWait();
                                return;
                            }
                        }
                    }
                }
            }
        });
        Menubutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                MainMenu menu = new MainMenu(stage);
                menu.update();
            }
        });
        resetAll.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                resetAllSkills();
            }

        });
        removeLast.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                removelast();
            }

        });


        root.setPadding(new Insets(10));
        root2.setPadding(new Insets(10));
        root3.setPadding(new Insets(10));
        root2.setSpacing(6);
        root3.setSpacing(157);
        root.setSpacing(5);
       
        root.getChildren().add(new Label("Enter message:"));
        root3.getChildren().addAll(Menubutton,resetAll,removeLast,addbutton);
        root2.getChildren().addAll(current_skills,new_skills);
        root.getChildren().addAll(root2, root3);
        
        Scene scene = new Scene(root);

        stage.setTitle("D.A.C.S Assistant v0.0.1");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    private void textIntoTextField(String FileName){
        String line;
        String text = "";
        try{
            FileReader fr = new FileReader(FileName); 
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null){
                text = text + line + "\n";
            }
            current_skills.setText(text);
            writeIntoTextFiles();

        
        }catch (Exception e) {
            System.out.println("LA");
        }
    
    }
    public void writeIntoTextFiles() {      
        
        try {
            FileWriter fw = new FileWriter("skillsFile.txt");
            fw.write(current_skills.getText());
            fw.close();
        } catch (IOException e) {
            System.out.println("ici");
            
        }
    }
    public void resetAllSkills(){
        current_skills.setText("");
        try{
            FileWriter fw = new FileWriter("skillsFile.txt");
            fw.write(current_skills.getText());
            fw.close();
        }catch( IOException e){
            System.out.println("LO");
        }

    }
    public void removelast(){
        String line;
        String text = "";
        try{
            FileReader fr = new FileReader("skillsFile.txt"); 
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null){
                text = text + line + "\n";
            }
            int i = text.length()-1;
            for(int j = i-1; j >= 0; j--){  
                if(text.charAt(j) == '\n'){
                    String sub = text.substring(j, i);
                    current_skills.setText(text.replace(sub, ""));
                    writeIntoTextFiles();
                    return;
                } 
                else if(j == 0){
                    resetAllSkills();

                }
            }
            
            
        }catch (IOException e) {
            System.out.println("LU");

        }
    }

}
