package com.resumeanalyser.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "job_descriptions")
public class JobDescription {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jd_id")
    private Long jdId;
	@Column(name = "jd_text", columnDefinition = "TEXT")
    private String jdText;
	@Column(name = "created_at")
    private LocalDateTime createdAt;
	 @ManyToOne
	 @JoinColumn(name = "user_id")
    private User user;

	 @ManyToMany
	 @JoinTable(
	     name = "jd_skills",
	     joinColumns = @JoinColumn(name = "jd_id"),
	     inverseJoinColumns = @JoinColumn(name = "skill_id")
	 )
	 private Set<Skill> requiredSkills = new HashSet<>();;

    public JobDescription() {
    }

    public JobDescription(Long jdId, String jdText, LocalDateTime createdAt, User user) {
        this.jdId = jdId;
        this.jdText = jdText;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Long getJdId() {
        return jdId;
    }

    public void setJdId(Long jdId) {
        this.jdId = jdId;
    }

    public String getJdText() {
        return jdText;
    }

    public void setJdText(String jdText) {
        this.jdText = jdText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Skill> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(Set<Skill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
}

