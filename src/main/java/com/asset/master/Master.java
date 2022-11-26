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
@Table(name = "asset_master")
public class Master {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="master_id")
	public Integer masterId;
	
	@Column(name="master_name")
	public String masterName;
	
	
	/*
	 * @OneToMany(mappedBy = "master", fetch = FetchType.LAZY, cascade =
	 * CascadeType.ALL) public List<MasterDetail> masterDetail = new
	 * ArrayList<MasterDetail>();
	 */
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL) public List<MasterDetail> masterDetail;
	 */
	
	/*
	 * @OneToMany(mappedBy = "master", fetch = FetchType.LAZY, cascade
	 * =CascadeType.ALL) private List<MasterDetail> masterDetailList;
	 */
	
}


