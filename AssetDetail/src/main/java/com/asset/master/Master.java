package com.asset.master;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "asset_master_detail")
public class Master {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="master_id", nullable=false)
	public Integer masterId;
	
	@Column(name="master_name")
	public String masterName;
	
	@Column(name="master_date")
	public Date masterDate;

}
