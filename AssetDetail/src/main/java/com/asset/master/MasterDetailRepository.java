package com.asset.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterDetailRepository extends JpaRepository<MasterDetail, Integer> {

}
