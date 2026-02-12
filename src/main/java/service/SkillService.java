package service;

import entity.Skill;

public interface SkillService {

    Skill getOrCreateSkill(String skillName);
}

