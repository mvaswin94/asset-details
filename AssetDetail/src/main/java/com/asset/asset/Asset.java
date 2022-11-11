package com.asset.asset;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="asset_id")
	public int assetId;

	@Column(name="asset_name")
	public String assetName;
	
	@Column(name="asset_type")
	public String assetType;
	
	@Column(name="asset_address")
	public String assetAddress;
	
	@Column(name="div_no")
	public String divNo;
	
	@Column(name="region")
	public String region;
	
	@Column(name="zone_no")
	public String zoneNo;
	
	@Column(name="asset_date")
	public String assetDate;
	
}
