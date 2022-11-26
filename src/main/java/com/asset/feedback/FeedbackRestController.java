package com.asset.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/asset")
public class FeedbackRestController {
	
	
	@Autowired
	FeedbackRepository feedbackRepo;
	
	/*
	 * @PostMapping(value = "/feedback/creation/submit") public List<Feedback>
	 * getIcList(@PathVariable("keyword") Long keyword) { List<Feedback> obj =
	 * feedbackRepo.findAllByCoverId(keyword); return obj; }
	 */

}
