package com.asset.complaint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/asset/feedback")
public class ComplaintRestController {

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
		  String image="null";
		  String latitude="null";
		  String longtitude="null";
		  String landmark="null";
	  
	  String urlString = "https://erp.chennaicorporation.gov.in/pgr/external/mobileservice?serviceId=RegComplaint&ComplainantName="+name+"&ComplainantAddr="+address+"&MobileNo="+email+"&Email="+mobileNo+"&ComplaintType="+complaintType+"&ComplaintTitle="+complaintTitle+"&ComplaintDetails="+complaintDetail+"&StreetId="+streetId+"&Comp_Image="+image+"&latitude="+latitude+"&longtitude="+longtitude+"&Landmark="+landmark+"";
	  //System.out.print("urlString---:  "+urlString);
      
      ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
      HttpHeaders headers = new HttpHeaders();
      try {
          HttpEntity<String> postData = new HttpEntity<String>(headers);
          response = restTemplate.exchange(urlString, HttpMethod.POST, postData, String.class);
          
      } catch (Exception e) {
          e.printStackTrace();
      }

      String bodyMessage = response.getBody();
      return bodyMessage;
      
      
	  }
	 
}


