package com.asset.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterParametersRepository extends JpaRepository<MasterParameters, Integer> {

}
