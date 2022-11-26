package com.asset.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends JpaRepository<Master, Integer> {

	/*
	 * @Query( 
	 * value="SELECT a.masterId, a.masterName, b.masterCharacteristic, b.masterQuestionType, \r\n"
	 * +"b.masterQuestion FROM Master a INNER JOIN MasterDetail b ON a.masterId=b.masterId"
	 * ,nativeQuery = false) public List<Master> findAllMasterDetail();
	 */
	/*public List findAllMasterDetail();*/
	
	
}
	