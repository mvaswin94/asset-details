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
@Table(name = "asset_master_parameters")
public class MasterParameters {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="master_parameters_id")
	public Integer masterParametersId;
	
	@Column(name="master_id")
	public Integer masterId;
		
	@Column(name="master_name")
	public String masterName;
	
	@Column(name="master_parameters")
	public String masterParameters;
	
}
