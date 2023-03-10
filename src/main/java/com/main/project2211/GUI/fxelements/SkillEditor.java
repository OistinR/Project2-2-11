package com.main.project2211.GUI.fxelements;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class SkillEditor {

    private String parentPath = "";
    private String parentDir ="";
    private Button Menubutton;
    private Button saveChanges;
    
    private Stage stage;
    static TextArea skills_area = new TextArea();

    private final Insets DEFAULTINSETS = new Insets(5, 5, 5, 5);
    Editor promptsEditor;
    Editor responsesEditor;
    Editor domainEditor;
    public SkillEditor(Stage stage){
        String[] temp = openFileChoser();
        parentPath = temp[1];
        parentDir = temp[0];
        skillName = temp[2];
        promptsEditor = new Editor("Prompts",parentPath+"\\Prompt");
        responsesEditor = new Editor("Responses", parentPath+"\\Response");
        domainEditor = new Editor("Domain",parentPath+"\\Domain");
        this.stage = stage;
        stage.setX(50);
        stage.setY(50);

        draw();
    }

    private void draw(){

        GridPane gp = new GridPane();
        gp.setPrefSize(600,400);

        gp.add(promptsEditor.draw(),0,0);
        gp.add(responsesEditor.draw(),1,0);
        gp.add(domainEditor.draw(),0,1);
        VBox menu = drawMenu();
        responsesEditor.root.setMaxHeight(300);
        GridPane.setMargin(menu,new Insets(0,25,25,25));
        gp.add(menu,1,1);

        Scene scene = new Scene(gp);

        stage.setTitle("Skills Editor: "+skillName);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

   private void fileTextToTextField(String FileName){
        String line;
        String text2 = "";
        try{
            FileReader fr = new FileReader(FileName); 
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null){
                text2 = text2 + line + "\n";
            }
            skills_area.setText(text2);
//            saveChangesMethode(skills_area.getText(),FileName);
        
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    
    }

    public static void saveChangesMethode(String text, String fileName){
        try {
            FileWriter fw = new FileWriter(fileName);
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
                        saveChangesMethode(text,null);
                    }
                    else if(s.charAt(i) == ' '){
                        System.out.println("quick2");
                        String sub = s.substring(i, j+1);
                        sub += "\n";
                        text += sub;
                        i = j+1;
                        saveChangesMethode(text,null);
                        
                    }
                    else{
                        System.out.println("quick3");
                        String sub = s.substring(i, j+1);
                        sub += "\n";
                        text += sub;
                        i = j+1;
                        saveChangesMethode(text,null);
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

    VBox outerVbox;
    HBox upperHbox;
    HBox lowerHbox;
    Label textFieldTitle;
    TextField skillNameTextField;
    Button loadButton;
    Button saveAllButton;
    Button newSkillButton;
    Button helpButton;
    Button returnButton;
    public VBox drawMenu(){
        outerVbox = new VBox();
        outerVbox.setPadding(DEFAULTINSETS);
        upperHbox = new HBox();
        upperHbox.setPadding(new Insets(5,5,5,0));
        lowerHbox = new HBox();
        lowerHbox.setPadding(new Insets(5,5,5,0));
        textFieldTitle = new Label("Skill Name:");
        skillNameTextField = new TextField();
        loadButton = new Button("Load Skill");
        saveAllButton = new Button("Save Skill");
        newSkillButton = new Button("New Skill");
        helpButton = new Button("Help");
        returnButton = new Button("returnButton");

        loadButton.setOnAction(e->{
            String[] out = openFileChoser();
            skillName = out[2];
            parentPath = out[1];
            parentDir = out[0];

            promptsEditor = new Editor("Prompts",parentPath+"\\Prompt");
            responsesEditor = new Editor("Responses", parentPath+"\\Response");
            domainEditor = new Editor("Domain",parentPath+"\\Domain");
            draw();

        });

        newSkillButton.setOnAction(e->{
            createNewSkill();
        });
        upperHbox.getChildren().addAll(loadButton,saveAllButton,newSkillButton);
        lowerHbox.getChildren().addAll(helpButton,returnButton);
        outerVbox.getChildren().addAll(textFieldTitle,skillNameTextField,upperHbox,lowerHbox);

        return outerVbox;
    }

    private String[] openFileChoser(){
        String[] output = new String[3];

        DirectoryChooser dChooser = new DirectoryChooser();
        dChooser.setTitle("Open Skill Folder");
        dChooser.setInitialDirectory(new File("skill"));
        output[0] = dChooser.getInitialDirectory().toString();
        File temp = dChooser.showDialog(stage);

        if(temp!=null){
            output[1] = temp.getPath();
            output[2] = temp.getName();
        }
        else {
            output[1]="skill/skill1";
            output[2]="skill1";
        }
        assert temp != null;

//        System.out.println(Arrays.toString(output));
        return output;
    }
    String skillName;
    private void createNewSkill(){
        TextInputDialog skillNameDialog = new TextInputDialog();
        skillNameDialog.setContentText("Enter a name for your new Skill");
        skillNameDialog.setTitle("Skill Name");
        skillNameDialog.showAndWait();
        skillName = skillNameDialog.getEditor().getText();

        new File(parentDir+"\\"+skillName).mkdir();

        try {
            PrintWriter s1 = new PrintWriter(parentDir+"\\"+skillName+"\\"+"Response");
            PrintWriter s2 = new PrintWriter(parentDir+"\\"+skillName+"\\"+"Prompt");
            PrintWriter s3 = new PrintWriter(parentDir+"\\"+skillName+"\\"+"Domain");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        parentPath = parentDir+"\\"+skillName;
        promptsEditor = new Editor("Prompts",parentPath+"\\Prompt");
        responsesEditor = new Editor("Responses", parentPath+"\\Response");
        domainEditor = new Editor("Domain",parentPath+"\\Domain");
        draw();
    }

}

class Editor{

    VBox root;
    HBox menu;
    TextArea textArea;
    Label nameOfElement;
    Button save;
    Button reset;
    String fileName;

    public Editor(String name,String filename){
        this.fileName = filename;
        nameOfElement = new Label(name);
        save = new Button("Save");
        reset = new Button("Reset");

        Insets defaultInsets = new Insets(5, 5, 5, 5);
        nameOfElement.setPadding(defaultInsets);
    }

    public VBox draw(){
        root = new VBox();
        menu = new HBox();
        menu.setSpacing(5);
        textArea = new TextArea();
        textArea.setWrapText(true);

        fileTextToTextField(fileName);

        save.setOnAction(e-> {
            saveChanges(textArea.getText(),fileName);
        });

        menu.getChildren().addAll(nameOfElement,save,reset);
        root.getChildren().addAll(menu,textArea);

        return root;
    }
    public static void saveChanges(String text, String fileName){
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public String getFileName() {
        return fileName;
    }

    private void fileTextToTextField(String FileName){
        String line;
        String text2 = "";
        try{
            FileReader fr = new FileReader(FileName);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null){
                text2 = text2 + line + "\n";
            }
            textArea.setText(text2);

        }catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
