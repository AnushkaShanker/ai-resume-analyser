package com.resumeanalyser.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.resumeanalyser.entity.Resume;
import com.resumeanalyser.entity.User;

import java.util.Optional;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    Optional<Resume> findByUser(User user);
}

