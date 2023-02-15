package com.main.project2211;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SkillReader {
    public static void main(String[] args) throws IOException {
        skillReader("monday");
    }

    // when calling the method will possibly have to add
    // 'throws IOException' to the method that calls it 
    // or surround the line w a try/catch 
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

        File f = new File("src/main/java/com/main/project2211/skills.txt");
        FileReader fr = new FileReader(f);
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
}
