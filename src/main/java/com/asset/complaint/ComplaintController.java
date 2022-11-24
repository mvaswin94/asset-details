package com.asset.complaint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/asset/feedback/")
public class ComplaintController {
	
	@Autowired
	ComplaintRepository complaintRepo;
	
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
		
//		String name="NA";
//		String mobileNo="9884209184";
//		String complaintDetail="TestDetail";
//		String url ="https://erp.chennaicorporation.gov.in/pgr/external/mobileservice?\r\n"
//				+ "serviceId=RegComplaint&\r\n"
//				+ "ComplainantName="+name+"&\r\n"
//				+ "ComplainantAddr=testingurladdrss&\r\n"
//				+ "MobileNo="+mobileNo+"&\r\n"
//				+ "Email=null&\r\n"
//				+ "ComplaintType=18&\r\n"
//				+ "ComplaintTitle=Mosquitomenace&\r\n"
//				+ "ComplaintDetails="+complaintDetail+"&\r\n"
//				+ "StreetId=25956&\r\n"
//				+ "Comp_Image=null&\r\n"
//				+ "latitude=null&\r\n"
//				+ "longtitude=null&\r\n"
//				+ "Landmark=null";
		
		return "asset-feedback-form-public-view";
	}
}
