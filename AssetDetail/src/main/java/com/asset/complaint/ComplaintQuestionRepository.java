package com.asset.complaint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintQuestionRepository extends JpaRepository<ComplaintQuestion, Integer> {

}
