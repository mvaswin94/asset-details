package com.asset.asset;

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
@Table(name = "asset_detail")
public class Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="asset_id", nullable=false)
	public Integer assetId;
	
	@Column(name="zone_no")
	public String zoneNo;
	
	@Column(name="div_no")
	public String divNo;
	
	@Column(name="asset_type")
	public String assetType;

	@Column(name="asset_name")
	public String assetName;
	
	@Column(name="asset_address")
	public String assetAddress;
	
	@Column(name="asset_opening_time")
	public String assetOpeningTime;
	
	@Column(name="asset_closing_time")
	public String assetClosingTime;
	
	@Column(name="asset_area")
	public String assetArea;
	
	@Column(name="asset_locality")
	public String assetLocality;
	
	@Column(name="asset_street")
	public String assetStreet;
	
	@Column(name="asset_file")
	public String assetFile;
}
