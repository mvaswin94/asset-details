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
	public String asset_name;
	
	@Column(name="asset_type")
	public String asset_type;
	
	@Column(name="asset_address")
	public String asset_address;
	
	@Column(name="div_no")
	public String div_no;
	
	@Column(name="region")
	public String region;
	
	@Column(name="zone_no")
	public String zone_no;
	
}
