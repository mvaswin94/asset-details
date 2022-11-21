package com.asset.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "v_master")
public class MasterView {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="master_id")
	public Integer masterId;
	
	@Column(name="master_name")
	public String masterName;
	
	@Column(name="master_parameters")
	public String masterParameters;
	
	@Column(name="master_question_tamil")
	public String masterQuestionTamil;
	
	@Column(name="master_question_english")
	public String masterQuestionEnglish;

	@Column(name="master_question_type")
	public String masterQuestionType;
}
