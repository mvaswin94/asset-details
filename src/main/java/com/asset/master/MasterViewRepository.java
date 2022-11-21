package com.asset.master;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterViewRepository extends JpaRepository<MasterView, Integer> {

	/*
	 * @Query(
	 * value="SELECT a.masterId, a.masterName, b.masterCharacteristic, b.masterQuestionType, \r\n"
	 * +"b.masterQuestionTamil b.masterQuestionEnglish FROM Master a INNER JOIN MasterDetail b ON a.masterId=b.masterId"
	 * ,nativeQuery = false) public List<MasterView> findAllMasterDetail();
	 */
}
