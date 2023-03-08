package SkillDesigner;

import SkillDesigner.skills.SimpleSkill;

import java.util.Iterator;
import java.util.List;
//DigitalAssstantBackend

public class SkillFinder {
    public static Skill find(String message){
            Skill skillFound = null;// = SkillFinder.find(this.chatState);

                List<String> skills = IOLoader.getSkillList();
                for (Iterator<String> iter = skills.iterator(); iter.hasNext(); ) {

                    String element = iter.next();
                    String[] splits = element.split(",");

                    for (String s: splits) {
                        if(message.trim().equals(s)){
                            String skillType = splits[1];
                            System.out.println("in SkillFinder, skill found: "+s);
                            //construct skill object
                            skillFound = buildSkill( s,  skillType);
                            System.out.println("in skill finder2, skillname found: ");
                            //skillFound.printSkillName();
                        }
                        //System.out.println(s);
                    }

                    //System.out.println(element);
                    // 1 - can call methods of element
                    // 2 - can use iter.remove() to remove the current element from the list

                    // ...
                }
        System.out.println("in skill finder, skillname found: ");
                return skillFound;
    }

    private static Skill buildSkill(String skillname, String skillType){
        Skill newSkill = null;
        if(skillType.trim().equals( "simple skill")){
            newSkill = new SimpleSkill(skillname);
            System.out.println("in skill finder, skill type found .............. ");
        }
        return newSkill;
    }
}
