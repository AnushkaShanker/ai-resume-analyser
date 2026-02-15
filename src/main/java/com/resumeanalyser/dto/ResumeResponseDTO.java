package com.resumeanalyser.dto;

import java.time.LocalDateTime;

public class ResumeResponseDTO {
	 private Long resumeId;
	    private String filePath;
	    private LocalDateTime uploadedAt;
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
}
