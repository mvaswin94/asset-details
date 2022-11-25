package com.asset.complaint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/asset/feedback")
public class ComplaintRestController {
	
	@GetMapping(value = "/sendOtp")
	public String sendOtp(HttpServletRequest request, @RequestParam String mobileNo) {
		String MobileNo=mobileNo;
		System.out.print("\n MobileNo---:"+mobileNo);
	Random rand = new Random();
	int otp = rand.nextInt(90000) + 10000;
		System.out.print("\n otp---:"+otp);
	
	String generatedToken="Your OTP is " +otp+ ". OTP is valid for the next 5 minutes.%0aBy%0aGreater Chennai Corporation."; 
	
	String urlString="http://api.onex-ultimo.in/api/pushsms?user=GCCtrans&authkey=92kOC1RBGBIws&sender=GCCCRP&mobile="+MobileNo+"&text="+generatedToken+"&rpt=1&summary=1&output=json&entityid=1401572690000011081&templateid=1407165856492044436";
		System.out.print("\n urlString---:  "+urlString);
      
      ResponseEntity<String> response = null;
	  RestTemplate restTemplate = new RestTemplate();
	  String bodyMessage = "";
      HttpHeaders headers = new HttpHeaders();
      try {
          HttpEntity<String> postData = new HttpEntity<String>(headers);
          response = restTemplate.exchange(urlString, HttpMethod.POST, postData, String.class);
          bodyMessage = response.getBody();
          	System.out.println("\n bodyMessage"+bodyMessage);
          
      } catch (Exception e) {
          e.printStackTrace();
          	System.out.print("\n ERROR---:  "+e);
          bodyMessage = "Error";
      }
      System.out.println("\n OTP sent successfully!");
      
      HttpSession session = request.getSession();
      session.setAttribute("otp", otp);
		return bodyMessage;
	}
	
	@GetMapping(value = "/verifyOtp")
	public String verifyOtp(HttpServletRequest request, @RequestParam String otp) {
		
		HttpSession session = request.getSession();
		String message = "";
		
		int session_otp = (Integer) session.getAttribute("otp");
			System.out.println("session_otp---:"+session_otp);
		String string_entered_otp = otp;
		int entered_otp = Integer.parseInt(string_entered_otp);
		if(session_otp == entered_otp)
		{
			System.out.println("Entered OTP Correct");
			message = "Success";
		}
		else
		{
			System.out.println("Incorrect OTP. Please enter correct OTP.");
			message = "Error";
		}
		
	      return message;
	}
	
	 @GetMapping(value = "/entry/complaint") 
	 public String feedbackFormSubmit(@ModelAttribute Complaint complaint, ComplaintQuestion complaintQuestion) {
	  
		 String complaintId=""; 
		  String name="null";
		  String address="null";
		  String email="null";
		  String mobileNo="9789332040"; 
		  String complaintType="18";
		  String complaintTitle="Mosquitomenace";
		  String complaintDetail="TestDetail";
		  String streetId="25956";
		  String image="";
		  String imageTest="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";
		  
		  String latitude="13.00";
		  String longtitude="null";
		  String landmark="Test Landmark";
	  
	  String urlString = "https://erp.chennaicorporation.gov.in/pgr/external/mobileservice?serviceId=RegComplaint&ComplainantName="+name+"&ComplainantAddr="+address+"&MobileNo="+email+"&Email="+mobileNo+"&ComplaintType="+complaintType+"&ComplaintTitle="+complaintTitle+"&ComplaintDetails="+complaintDetail+"&StreetId="+streetId+"&Comp_Image="+image+"&latitude="+latitude+"&longtitude="+longtitude+"&Landmark="+landmark+"";
	  System.out.print("urlString---:  \n"+urlString);
      
      ResponseEntity<String> response = null;
	  RestTemplate restTemplate = new RestTemplate();
	  String bodyMessage = "";
      HttpHeaders headers = new HttpHeaders();
      try {
          HttpEntity<String> postData = new HttpEntity<String>(headers);
          response = restTemplate.exchange(urlString, HttpMethod.POST, postData, String.class);
          bodyMessage = response.getBody();
          
      } catch (Exception e) {
          e.printStackTrace();
          System.out.print("ERROR---:  "+e);
          bodyMessage = "ERROR";
      }
      return bodyMessage;
      
	  }
}


