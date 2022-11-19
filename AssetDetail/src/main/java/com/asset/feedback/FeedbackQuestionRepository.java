
package com.asset.feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackQuestionRepository extends JpaRepository<FeedbackQuestion, Integer> {


}
