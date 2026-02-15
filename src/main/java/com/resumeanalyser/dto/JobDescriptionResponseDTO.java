package com.resumeanalyser.dto;

import java.time.LocalDateTime;

public class JobDescriptionResponseDTO {

	 private Long jdId;
	    private String jdText;
	    private LocalDateTime createdAt;
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
}
