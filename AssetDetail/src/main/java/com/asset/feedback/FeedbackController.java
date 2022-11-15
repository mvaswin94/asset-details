package com.asset.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/asset/feedback")
public class FeedbackController {

	@Autowired
	FeedbackRepository feedbackRepo;
	
	@GetMapping(value = "/creation")
	public String feedbackForm(Model model) {
		model.addAttribute("feedbackFormCreationObj", new Feedback());

		return "asset-feedback-creation";
	}
	
	@PostMapping(value = "/creation/submit")
	public String assetEntrySubmit(@ModelAttribute Feedback feedback) {

		Feedback obj = new Feedback();

		obj.setFeedbackQuestionId(feedback.getFeedbackQuestionId());
		obj.setAssetId(feedback.getAssetId());
		obj.setAssetType(feedback.getAssetType());
		obj.setQuestion(feedback.getQuestion());
		
		feedbackRepo.saveAndFlush(obj);

		return "redirect:/asset/feedback/creation";
	}
	
	@GetMapping(value = "/qrcode")
	public String qrCode(Model model) {
		model.addAttribute("qrCodeObj", new Feedback());

		return "asset-feedback-qrcode";
	}
	
	@PostMapping(value = "/qrcode/submit")
	public String qrCodeSubmit(Model model, @PageableDefault(size = 1000) Pageable pageable) {
		Page<Feedback> obj = feedbackRepo.findAll(pageable);
		model.addAttribute("page", obj);
		
		model.addAttribute("qrCodeObj", new Feedback());

		return "asset-feedback-qrcode";
		
	}
	
	@GetMapping(value = "/list")
	public String feedbackList(Model model, @PageableDefault(size = 1000) Pageable pageable) {
		Page<Feedback> obj = feedbackRepo.findAll(pageable);
		model.addAttribute("page", obj);
		System.out.println("obj"+obj);
		return "asset-feedback-list";
	}
	
	@RequestMapping(value = "/entry", method = RequestMethod.GET)
	public String feednbackEntry() {
		//System.out.println("TEST NOW");
		return "asset-feedback-creation";
	}
}
