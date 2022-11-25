package com.asset.complaint;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping(value = "/asset/feedback/")
public class ComplaintController {
	
	@Autowired
	ComplaintRepository complaintRepo;
	
	ComplaintService complaintSer;
	
	@Autowired
	ComplaintQuestionRepository complaintQuestionRepo;
	
	@GetMapping(value = "/complaint/tracking")
	public String assetEntry(Model model) {
		model.addAttribute("complaintTrackingObj", new Complaint());
		
		return "asset-complaint-tracking";
	}

	@PostMapping(value = "/entry/complaintTEST")
	public String feedbackFormSubmit(@ModelAttribute Complaint complaint, ComplaintQuestion complaintQuestion) {
		
		Complaint obj = new Complaint();
		obj.setComplaintId(complaint.getComplaintId());
		obj.setMobileNo(complaint.getMobileNo());
		obj.setOtp(complaint.getOtp());
		obj.setComplaintFile(complaint.getComplaintFile());
		
		complaintRepo.saveAndFlush(obj);
		
		ComplaintQuestion obj2 = new ComplaintQuestion();
		obj2.setComplaintQuestionId(complaintQuestion.getComplaintQuestionId());
		obj2.setComplaintId(complaintQuestion.getComplaintId());
		obj2.setQuestion(complaintQuestion.getQuestion());
		obj2.setFeedback(complaintQuestion.getFeedback());
		complaintQuestionRepo.saveAndFlush(obj2);
		
		return "asset-feedback-form-public-view";
	}
}
