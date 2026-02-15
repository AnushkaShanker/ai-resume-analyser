package com.resumeanalyser.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "analysis_results")
public class AnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @ManyToOne
    @JoinColumn(name = "jd_id")
    private JobDescription jobDescription;

    @Column(name = "ats_score")
    private double atsScore;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Transient 
    private List<Skill> matchedSkills;

    @Transient
    private List<Skill> missingSkills;



    public AnalysisResult() {
    }

    public AnalysisResult(Long resultId, Resume resume, JobDescription jobDescription,
                          double atsScore, List<Skill> matchedSkills,
                          List<Skill> missingSkills, LocalDateTime createdAt) {
        this.resultId = resultId;
        this.resume = resume;
        this.jobDescription = jobDescription;
        this.atsScore = atsScore;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
        this.createdAt = createdAt;
    }

	public Long getResultId() {
		return resultId;
	}

	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public JobDescription getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(JobDescription jobDescription) {
		this.jobDescription = jobDescription;
	}

	public double getAtsScore() {
		return atsScore;
	}

	public void setAtsScore(double atsScore) {
		this.atsScore = atsScore;
	}

	public List<Skill> getMatchedSkills() {
		return matchedSkills;
	}

	public void setMatchedSkills(List<Skill> matchedSkills) {
		this.matchedSkills = matchedSkills;
	}

	public List<Skill> getMissingSkills() {
		return missingSkills;
	}

	public void setMissingSkills(List<Skill> missingSkills) {
		this.missingSkills = missingSkills;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

    
}
