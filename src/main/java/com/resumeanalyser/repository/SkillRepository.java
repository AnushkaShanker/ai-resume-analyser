package com.resumeanalyser.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.resumeanalyser.entity.Skill;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    Optional<Skill> findBySkillNameIgnoreCase(String skillName);
}

