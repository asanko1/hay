package com.tredence.hay.model;

import java.math.BigInteger;

public class Skills {
    String Skill_Name, Skill_Type;
    BigInteger SkillId;

    public BigInteger getSkillId() {
        return SkillId;
    }

    public void setSkillId(BigInteger skillId) {
        SkillId = skillId;
    }

    public String getSkill_Name() {
        return Skill_Name;
    }

    public void setSkill_Name(String skill_Name) {
        Skill_Name = skill_Name;
    }

    public String getSkill_Type() {
        return Skill_Type;
    }

    public void setSkill_Type(String skill_Type) {
        Skill_Type = skill_Type;
    }
}
