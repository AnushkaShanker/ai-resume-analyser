package com.resumeanalyser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resumeanalyser.entity.JobDescription;
import com.resumeanalyser.entity.User;

import java.util.List;

public interface JobDescriptionRepository extends JpaRepository<JobDescription, Long> {

    List<JobDescription> findByUser(User user);
}

