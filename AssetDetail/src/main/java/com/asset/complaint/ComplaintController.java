package com.asset.complaint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asset.asset.Asset;
import com.asset.master.Master;


@Controller
@RequestMapping(value = "/asset")
public class ComplaintController {
	
	@Autowired
	ComplaintRepository complaintRepo;
	
	@Autowired
	ComplaintQuestionRepository complaintQuestionRepo;
	
	@GetMapping(value = "complaint/tracking")
	public String assetEntry(Model model) {
		model.addAttribute("complaintTrackingObj", new Complaint());
		
		return "asset-complaint-tracking";
	}

	@PostMapping(value = "/form/submit")
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
		
		String mobileNo = complaint.getMobileNo();
		
		//String url1 = "https://erp.chennaicorporation.gov.in/pgr/external/mobileservice?";
		
		String url = "https://erp.chennaicorporation.gov.in/pgr/external/mobileservice?\r\n"
				+ "serviceId=RegComplaint&\r\n"
				+ "serviceinput=\r\n"
				+ "{\r\n"
				+ "\"ComplainantName\":\"NA\",\r\n"
				+ "\"ComplainantAddr\":\"NA\",\r\n"
				+ "\"MobileNo\":\""+mobileNo+"\",\r\n"
				+ "\"Email\":\"NA\",\r\n"
				+ "\"ComplaintType\":\"18\",\r\n"
				+ "\"ComplaintTitle\":\"Mosquitomenace\",\r\n"
				+ "\"ComplaintDetails\":\"testingcomplaintdetails\",\r\n"
				+ "\"StreetId\":\"NA\",\r\n"
				+ "\"Comp_Image\":\"NA\",\r\n"
				+ "\"latitude\":\"NA\",\r\n"
				+ "\"longtitude\":\"NA\",\r\n"
				+ "\"Landmark\":\"testing\"\r\n"
				+ "}";
		
		return "redirect:/asset/feedback/creation";
	}
}
