package com.main.project2211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SkillReader {
    public static void main(String[] args) throws IOException {
        skillReader("monday");

        String [] a = {"a", "b", "c"};
        addSkill("name", a, 5);
    }

    public static String skillReader (String input) throws IOException{

        // TODO: go through the string input and find the keywords 

        String day = "monday";
        int hour = 11; 
        int slot = -1; 
        switch (hour) {
            case 9: 
                slot = 0;
                break; 
            case 11: 
                slot = 1; 
                break; 
            case 13: 
                slot = 2; 
                break; 
            case 15: 
                slot = 3; 
                break; 
        }

        FileReader fr = new FileReader("src/main/java/com/main/project2211/skills.txt");
        BufferedReader br = new BufferedReader(fr);
        String s;     
        String[] words=null;
        while((s=br.readLine())!= null) {
            words=s.split(" ");
            for (String word : words) {
                if (slot == -1) {
                    return "no clue"; 
                }
                if (word.equals(day)) {
                    String line = br.readLine();
                    List<String> schedule = Arrays.asList(line.split("\\s*,\\s*"));
                    return schedule.get(slot);
                }
            }
        }
        return "no clue";
    }

    public static void addSkill(String name, String[] vars, int domainSize) throws IOException{
        FileWriter fw = new FileWriter("src/main/java/com/main/project2211/skills.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.newLine();
        bw.write("skill : " + name);
        for (int i = 0; i < vars.length; i++){
            bw.newLine();
            bw.write("< " + vars[i] + " >");
            bw.newLine();
            for (int j = 0; i < domainSize ; i++){
                bw.write(", ");
            }
        }
        bw.close();
    }

    public static void editSkill(String name){
    }
}
