package com.resumeanalyser.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AnalysisResponseDTO {
	private double atsScore;
    private List<String> matchedSkills;
    public double getAtsScore() {
		return atsScore;
	}
	public void setAtsScore(double atsScore) {
		this.atsScore = atsScore;
	}
	public List<String> getMatchedSkills() {
		return matchedSkills;
	}
	public void setMatchedSkills(List<String> matchedSkills) {
		this.matchedSkills = matchedSkills;
	}
	public List<String> getMissingSkills() {
		return missingSkills;
	}
	public void setMissingSkills(List<String> missingSkills) {
		this.missingSkills = missingSkills;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	private List<String> missingSkills;
    private LocalDateTime createdAt;

}
