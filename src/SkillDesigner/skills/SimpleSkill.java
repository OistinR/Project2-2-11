package SkillDesigner.skills;

import SkillDesigner.Skill;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SimpleSkill extends Skill {
    String[] questionArray1;
    public SimpleSkill(String skill) {
        super(skill);
        this.questionArray1= new String[5]; //Initialization after declaration with specific size
        questionArray1[0]= "which";
        questionArray1[1]= "course";
        questionArray1[2]= "is";
        questionArray1[3]= "on";
        questionArray1[4]= "";
        //which course is on friday
    }

    @Override
    public boolean validateMessage(String message) {
        //which course is on friday
        //remove second and last word
        String[] words = message.split("\\s+");
        if( words.length < 5 ) {
            return false;
        }
        /* source https://stackoverflow.com/questions/4674850/converting-a-sentence-string-to-a-string-array-of-words-in-java*/
        for (int i = 0; i < words.length; i++) {
            // You may want to check for a non-word character before blindly
            // performing a replacement
            // It may also be necessary to adjust the character class
            if(i== 4) {
                //words[i] = words[i].replaceAll("[^\\w]", "");
            }
            else{
                if(!words[i].equals(questionArray1[i])){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String getQuestionFormatMessage() {
        return "What is the course timetable for course <COURSENAME> ?";
    }

    @Override
    public String getResponseMessage(String[] messageParams) {
        return null;
    }

    @Override
    public List<String> getResponseParams(String message) {
        return null;
    }
}
