package com.resumeanalyser.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "resumes")
public class Resume {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private Long resumeId;
	
	@Column(name = "file_path")
    private String filePath;
	
	@Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;
	
	 @OneToOne
	 @JoinColumn(name = "user_id", unique = true)
    private User user;

	 @ManyToMany
	 @JoinTable(
	     name = "resume_skills",
	     joinColumns = @JoinColumn(name = "resume_id"),
	     inverseJoinColumns = @JoinColumn(name = "skill_id")
	 )
	 private Set<Skill> skills = new HashSet<>();

    public Resume() {
    }

    public Resume(Long resumeId, String filePath, LocalDateTime uploadedAt, User user) {
        this.resumeId = resumeId;
        this.filePath = filePath;
        this.uploadedAt = uploadedAt;
        this.user = user;
    }

    public Long getResumeId() {
        return resumeId;
    }

    public void setResumeId(Long resumeId) {
        this.resumeId = resumeId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}

