package com.resumeanalyser.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long skillId;
	@Column(name = "skill_name", unique = true)
    private String skillName;

    public Skill() {
    }

    public Skill(Long skillId, String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
