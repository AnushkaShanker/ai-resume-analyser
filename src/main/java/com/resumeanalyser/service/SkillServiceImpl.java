package com.resumeanalyser.service;

import org.springframework.stereotype.Service;

import com.resumeanalyser.entity.Skill;
import com.resumeanalyser.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill getOrCreateSkill(String skillName) {
        return skillRepository.findBySkillNameIgnoreCase(skillName)
                .orElseGet(() -> {
                    Skill skill = new Skill();
                    skill.setSkillName(skillName);
                    return skillRepository.save(skill);
                });
    }
}


