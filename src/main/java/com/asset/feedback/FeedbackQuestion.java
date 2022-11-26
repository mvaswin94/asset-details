package com.asset.feedback;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "asset_feedback_question")
public class FeedbackQuestion {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="feedback_question_id", nullable=false)
		public Integer feedbackQuestionId;
		
		@Column(name="asset_id")
		public String assetId;

		@Column(name="asset_type")
		public String assetType;
		
		@Column(name="question")
		public String question;
		
		@Column(name="question_type")
		public String questionType;
		
		//@JoinColumn(name = "asset_id", nullable = false, insertable=false, updatable=false) 
		//private Feedback feedback;

	}