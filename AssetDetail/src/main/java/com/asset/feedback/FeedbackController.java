package com.asset.feedback;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/asset/feedback")
public class FeedbackController {

	@RequestMapping(value = "/creation", method = RequestMethod.GET)
	public String feedbackForm() {
		/* System.out.println("TEST NOW3"); */
		return "asset-feedback-creation";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String feedbackList() {
		//System.out.println("TEST NOW");
		return "asset-feedback-list";
	}
	
	@RequestMapping(value = "/entry", method = RequestMethod.GET)
	public String feednbackEntry() {
		//System.out.println("TEST NOW");
		return "asset-feedback-creation";
	}
}
