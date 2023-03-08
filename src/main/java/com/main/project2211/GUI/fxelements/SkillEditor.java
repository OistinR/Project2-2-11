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
    private Button saveChanges;
    
    private Stage stage;
    TextArea skills_area = new TextArea();

    public SkillEditor(Stage stage){

        this.stage = stage;
        stage.setX(350);
        stage.setY(300);
        Menubutton = new Button("Menu");
        Menubutton.setMinWidth(200);
        saveChanges = new Button("Save Changes"); 
        saveChanges.setMinWidth(200);
        VBox root = new VBox();
        HBox root2 = new HBox();
        HBox root3 = new HBox();
        textIntoTextField("skillsFile.txt");

        Menubutton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                MainMenu menu = new MainMenu(stage);
                menu.update();
            }
        });

        saveChanges.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                rewriteTextFile();
                textIntoTextField("skillsFile.txt");
            }
        });


        root.setPadding(new Insets(10));
        root2.setPadding(new Insets(10));
        root3.setPadding(new Insets(10));
        root2.setSpacing(6);
        root3.setSpacing(115);
        root.setSpacing(5);
       
        root.getChildren().add(new Label("Enter message:"));
        root3.getChildren().addAll(Menubutton,saveChanges);
        root2.getChildren().addAll(skills_area);
        root.getChildren().addAll(root2, root3);
        
        Scene scene = new Scene(root);

        stage.setTitle("D.A.C.S Assistant v0.0.1");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    

    private void textIntoTextField(String FileName){
        String line;
        String text2 = "";
        try{
            FileReader fr = new FileReader(FileName); 
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null){
                text2 = text2 + line + "\n";
            }
            skills_area.setText(text2);
            saveChangesMethode(skills_area.getText());
        
        }catch (Exception e) {
            System.out.println("LA");
        }
    
    }

    
    public void saveChangesMethode(String text){
        
        try {
            FileWriter fw = new FileWriter("skillsFile.txt");
            fw.write("");
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            System.out.println("ici");
            
        }
    }

    public void rewriteTextFile(){
        String s = skills_area.getText();
        String text ="";

        if(skills_area.getText().equals("")){
            

        }

        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                System.out.println("quick");
                if(s.charAt(j) == '.'){
                    if(s.charAt(i) == '\n'){
                        String sub = s.substring(i, j+1);
                        sub = sub.replace("\n", "").replace("\r", "");
                        sub += "\n";
                        text += sub;
                        i = j+1;
                        saveChangesMethode(text); 
                    }
                    else if(s.charAt(i) == ' '){
                        System.out.println("quick2");
                        String sub = s.substring(i, j+1);
                        sub += "\n";
                        text += sub;
                        i = j+1;
                        saveChangesMethode(text);
                        
                    }
                    else{
                        System.out.println("quick3");
                        String sub = s.substring(i, j+1);
                        sub += "\n";
                        text += sub;
                        i = j+1;
                        saveChangesMethode(text);
                    }
                } 
                else if (!s.contains(".")) { 
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
