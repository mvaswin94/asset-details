package com.asset.complaint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "asset_complaint_question")
public class ComplaintQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="complaint_question_id", nullable=false)
	public Integer complaintQuestionId;
	
	@Column(name="complaint_id")
	public Integer complaintId;
	
	@Column(name="question")
	public String question;
	
	@Column(name="feedback")
	public String feedback;

}
