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
@Table(name = "asset_complaint")
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="complaint_id", nullable=false)
	public Integer complaintId;
	
	@Column(name="mobile_no")
	public String mobileNo;
	
	@Column(name="otp")
	public String otp;
	
	@Column(name="complaint_file")
	public String complaintFile;
	
	@Column(name="status")
	public String status;
	
}
