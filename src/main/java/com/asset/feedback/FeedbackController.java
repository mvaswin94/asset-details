package com.asset.feedback;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asset.asset.Asset;
import com.asset.master.MasterDetail;
import com.asset.master.MasterDetailRepository;

@Controller
@RequestMapping(value = "/asset/feedback")
public class FeedbackController {

	@Autowired
	FeedbackRepository feedbackRepo;
	
	@Autowired
	FeedbackQuestionRepository feedbackQuestionRepo;
	
	@Autowired
	MasterDetailRepository masterDetailRepo;
	
	@GetMapping(value = "/creation")
	public String feedbackForm(Model model) {
		model.addAttribute("feedbackFormCreationObj", new FeedbackQuestion());

		return "asset-feedback-creation";
	}
	
	@PostMapping(value = "/creation/submit")
	public String assetEntrySubmit(@ModelAttribute Feedback feedback, @ModelAttribute FeedbackQuestion feedbackQuestion) {

		Feedback obj = new Feedback();
		obj.setAssetId(feedback.getAssetId());
		obj.setAssetType(feedback.getAssetType());
		feedbackRepo.saveAndFlush(obj);
		
		FeedbackQuestion obj2 = new FeedbackQuestion();
		obj2.setFeedbackQuestionId(feedbackQuestion.getFeedbackQuestionId());
		obj2.setAssetId(feedbackQuestion.getAssetId());
		obj2.setAssetType(feedbackQuestion.getAssetType());
		obj2.setQuestion(feedbackQuestion.getQuestion());
		obj2.setQuestionType(feedbackQuestion.getQuestionType());
		feedbackQuestionRepo.saveAndFlush(obj2);

		return "redirect:/asset/feedback/creation";
	}
	
	@GetMapping(value = "/qrcode")
	public String qrCode(Model model, @PageableDefault(size = 1000) Pageable pageable) {
		model.addAttribute("qrCodeObj", new Feedback());

		Page<Feedback> obj = feedbackRepo.findAll(pageable);
		model.addAttribute("page", obj);
		
		//Page<FeedbackQuestion> obj2 = feedbackQuestionRepo.findAll(pageable);
		//model.addAttribute("page", obj2);
		
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
		//Page<MasterDetail> obj = masterDetailRepo.findAll(pageable);
		model.addAttribute("page", obj);
		System.out.println("obj"+obj);
		return "asset-feedback-list";
	}
	
	@GetMapping(value = "/entry")
	public String feednbackFormEntry(Model model, @PageableDefault(size = 1000) Pageable pageable) {
//		Page<Feedback> obj = feedbackRepo.findAll(pageable);
//		model.addAttribute("page", obj);
//		System.out.println("obj"+obj);
		//List<FeedbackQuestion> obj = feedbackQuestionRepo.findAll();
		List<MasterDetail> obj = masterDetailRepo.findAll();
		model.addAttribute("page", obj);
		return "asset-feedback-form-public-view";
	}
	
	@GetMapping(value = "/qrCode/assetType={assetType}/assetId={assetId}")
	public String feedbackFormPublicView(@PathVariable Integer assetId, String assetType, Model model) {

		//new Asset();
		//Optional<FeedbackQuestion> asset = feedbackQuestionRepo.findAll();
		//Asset assetObj = asset.get();
		//model.addAttribute("assetEntryObj", assetObj);
		
		List<FeedbackQuestion> obj = feedbackQuestionRepo.findAll();
		model.addAttribute("page", obj);
		
		//System.out.println("assetObj---:"+assetObj);
		return "asset-feedback-form-public-view";
		
	}
	
}
