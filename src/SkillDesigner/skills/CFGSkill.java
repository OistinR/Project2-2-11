package SkillDesigner.skills;

import SkillDesigner.Skill;

import java.util.List;

public class CFGSkill extends Skill {
    public CFGSkill(String skill) {
        super(skill);
    }

    @Override
    public boolean validateMessage(String message) {
        return false;
    }

    @Override
    public String getQuestionFormatMessage() {
        return null;
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
