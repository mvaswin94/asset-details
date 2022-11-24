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
	  
			/* try { */
	  
	  String urlString = "https://erp.chennaicorporation.gov.in/pgr/external/mobileservice?serviceId=RegComplaint&ComplainantName="+name+"&ComplainantAddr="+address+"&MobileNo="+email+"&Email="+mobileNo+"&ComplaintType="+complaintType+"&ComplaintTitle="+complaintTitle+"&ComplaintDetails="+complaintDetail+"&StreetId="+streetId+"&Comp_Image="+image+"&latitude="+latitude+"&longtitude="+longtitude+"&Landmark="+landmark+"";
	  
	  System.out.print("urlString---:  "+urlString);
	  
	 
	  
//	  URL myurl = null; myurl = new URL(urlString ); 
//	  System.out.print("myurl---:  "+myurl);
//	  
//	  URLConnection connection = myurl.openConnection(); 
//	  System.out.print("connection---:  "+connection);
//	  System.out.print("Sending Sucess");
//	  
//	  HttpURLConnection conn = (HttpURLConnection)myurl.openConnection();
//	  	System.out.print("conn---:  "+conn);
//	  conn.connect(); 
//	  BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//	  	System.out.print("br---:  "+br);
//	  String line = ""; 
//	  String page_line = "";
//	  while( (line = br.readLine() ) != null ) {
//		  page_line += line+""; 
//	  } 
//	  System.out.println("page_line :" +page_line);
//	  
//	  String[] tempvalue = page_line.split("<br>");
//	  System.out.print("tempvalue"+tempvalue);
//	  
//	  //String outputvalue = "";
//		boolean isConnected = (conn.getContentLength() > 0);
//		java.util.Date dt=new java.util.Date();
//		System.out.print("Date"+dt);
//		if(isConnected)
//		{
//			System.out.print("Sending Sucess");
//			conn.disconnect();
//		}
	  
//	  }
//	  catch(Exception ex) { 
//		  System.out.println("\n Error "+ex); 
//	  }
	  
//	  RestTemplate restTemplate = new RestTemplate();
//	  HttpHeaders headers = new HttpHeaders();
//      //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//      HttpEntity<String> entity = new HttpEntity<String>(headers);
//      return restTemplate.exchange(urlString, HttpMethod.POST, entity, String.class).getBody();
	  
	  
	  ResponseEntity<String> response = null;
	  	System.out.print("\n ---1---");
      HttpHeaders headers = new HttpHeaders();
      	System.out.print("\n---2---"+headers);
      headers.add("Content-Type", "application/x-www-form-urlencoded");
      	System.out.print("\n ---3---"+headers);
      RestTemplate restTemplate = new RestTemplate();
      try {
          MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
          	System.out.print("\n ---4---"+parametersMap);
          HttpEntity<Object> postData = new HttpEntity<Object>(parametersMap, headers);
          	System.out.print("\n ---5---"+postData);
          response = restTemplate.exchange(urlString, HttpMethod.POST, postData, String.class);
          	System.out.print("\n ---6---"+response);
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println("\n Error "+e); 
      }
      String bodyMessage = response.getBody();
      return bodyMessage;
	  }
	 
}


