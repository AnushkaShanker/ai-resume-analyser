package service;

import entity.Skill;
import repository.SkillRepository;
import org.springframework.stereotype.Service;

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


