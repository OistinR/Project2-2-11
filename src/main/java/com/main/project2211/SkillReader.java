 package com.main.project2211;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SkillReader {
    public void skillReader (String input) throws IOException{
        // TODO: go through the string input and find the keywords 
        File f = new File("skills.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String s;     
        String[] words=null;
        while((s=br.readLine())!= null) {
            words=s.split(" ");
            for (String word : words) {
                if (word.equals(input)) {
                    // TODO: look for desired timeslot 
                }
            }
        }
    }
}
