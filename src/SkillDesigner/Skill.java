package SkillDesigner;

import java.util.List;
import java.util.Map;

public abstract class Skill {
    public String skillName;
    public void  printSkillName(){
        System.out.println("Skill name: "+skillName);
    };
    public Skill(String skill){
        this.skillName=skill;
        System.out.println("in SkillDesigner.Skill constructor, skill name: "+skill);
    }
    public abstract boolean validateMessage(String message);
    public abstract String getQuestionFormatMessage();
    public abstract String getResponseMessage(String[] messageParams);
    public abstract List<String> getResponseParams(String message);
}
