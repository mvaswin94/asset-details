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
@Table(name = "asset_feedback")
public class Feedback {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="feedback_id", nullable=false)
		public Integer feedbackId;
		
		@Column(name="asset_id")
		public String assetId;

		@Column(name="asset_type")
		public String assetType;
		
		//@OneToMany(mappedBy = "FeedbackQuestion", fetch = FetchType.LAZY, cascade=CascadeType.ALL) 
		//private List<FeedbackQuestion> feedbackQuestionList;

		//@OneToMany(mappedBy = "FeedbackQuestion", fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
		//public List<FeedbackQuestion> feedbackQuestionList = new ArrayList<FeedbackQuestion>();
	}