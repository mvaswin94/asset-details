package com.asset.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "asset_master_detail")
public class MasterDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="master_detail_id")
	public Integer masterDetailId;
	
	@Column(name="master_id")
	public Integer masterId;
		
	@Column(name="master_name")
	public String masterName;
	
	@Column(name="master_characteristic")
	public String masterCharacteristic;
	
	@Column(name="master_question")
	public String masterQuestion;

	@Column(name="master_question_type")
	public String masterQuestionType;
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "master_id", nullable = false, insertable=false,
	 * updatable=false) private Master master;
	 */
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "master_id", nullable = false, insertable=false,
	 * updatable=false) private Master master;
	 */
	
}
