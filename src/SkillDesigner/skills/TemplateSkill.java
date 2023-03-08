package SkillDesigner.skills;

import SkillDesigner.IOLoader;
import SkillDesigner.Skill;
import builders.RuleParser;

import java.util.HashMap;
import java.util.List;

public class TemplateSkill extends Skill {
    public TemplateSkill(String skill) {
        super(skill);
    }

    @Override
    public boolean validateMessage(String message) {
        return false;
    }

    @Override
    public String getQuestionFormatMessage() {
        return "Which lectures are there on <DAY> at <TIME> ?";
    }

    @Override
    public String getResponseMessage(String[] messageParams) {
                /*not found: There are no lectures on 1
        found: On 1 at 2hrs we have rp1
        found only 1: On 1 we have the whole day rp1
        found only 2: Every day at 2 we have rp1/*
        ----------
        Monday,9: math
        Monday, 11: Theoratical Computer Science
         */
        Integer inputParamCount = RuleParser.getParamCount(getQuestionFormatMessage());
        HashMap<Integer,String[]> outputParams = IOLoader.getInputParamMatchValue(messageParams, this);
        // call SentenceBuilder
        return null;
    }

    @Override
    public List<String> getResponseParams(String message) {
                /*not found: There are no lectures on 1
        found: On 1 at 2hrs we have rp1
        found only 1: On 1 we have the whole day rp1
        found only 2: Every day at 2 we have rp1/*
        ----------
        Monday,9: math
        Monday, 11: Theoratical Computer Science
         */
        return null;
    }
}
