package com.asset.feedback;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Random;

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

import com.asset.complaint.Complaint;
import com.asset.complaint.ComplaintRepository;
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
	
	@Autowired
	ComplaintRepository complaintDetailRepo;
	
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
	public String feednbackFormEntry(Model model) {
//		Page<Feedback> obj = feedbackRepo.findAll(pageable);
//		model.addAttribute("page", obj);
//		System.out.println("obj"+obj);
		//List<FeedbackQuestion> obj = feedbackQuestionRepo.findAll();
		
		List<Complaint> obj1 = complaintDetailRepo.findAll();
		model.addAttribute("complaintObj", obj1);
		
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
	
	@GetMapping(value = "/sendOtp/mobileNo={mobileNo}")
	public String sendOTP(@PathVariable String mobileNo, Model model) {
		
		/*
		 * List<FeedbackQuestion> obj = feedbackQuestionRepo.findAll();
		 * model.addAttribute("page", obj);
		 */

		String MobileNo=mobileNo;
		Random rand = new Random();
		int otp = rand.nextInt(90000) + 10000;
		System.out.println("OTP sent successfully!");
		String generatedToken="Your OTP is " +otp+ ". OTP is valid for the next 5 minutes.%0aBy%0aGreater Chennai Corporation."; 
		try
		{
		generatedToken=generatedToken.replace(" ","%20");
			   
			  String urlString="http://api.onex-ultimo.in/api/pushsms?user=GCCtrans&authkey=92kOC1RBGBIws&sender=GCCCRP&mobile="+MobileNo+"&text="+generatedToken+"&rpt=1&summary=1&output=json&entityid=1401572690000011081&templateid=1407165856492044436";   
							URL myurl = null;
							myurl = new URL(urlString );
							URLConnection connection = myurl.openConnection();
								System.out.println("connection:"+connection);
							HttpURLConnection conn = (HttpURLConnection)myurl.openConnection();
							conn.connect();
							BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
							String line = "";
							String page_line = "";
							while( (line = br.readLine() ) != null )
								{
								page_line += line+"";
								}
							System.out.println("page_line :" +page_line);

							String[] tempvalue = page_line.split("<br>");
								System.out.println("Temp Value"+tempvalue);
							String outputvalue = "";
								System.out.println("Output Value"+outputvalue);
							boolean isConnected = (conn.getContentLength() > 0);
							java.util.Date dt=new java.util.Date();
								System.out.println("Date:"+dt);
							if(isConnected)
							{
								System.out.print("Sending Sucess");
								conn.disconnect();
							} 
						 		 
			}catch(Exception ex)
				{
				System.out.println("Error "+ex +" MobileNo"+MobileNo);
				}
		// storing otp in session
		//session.setAttribute("otp",otp);
		//System.out.println("assetObj---:"+assetObj);
		return "asset-feedback-form-public-view";
		
	}
	
	
	
	
}
