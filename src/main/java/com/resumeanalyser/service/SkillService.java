package com.resumeanalyser.service;

import com.resumeanalyser.entity.Skill;

public interface SkillService {

    Skill getOrCreateSkill(String skillName);
}

