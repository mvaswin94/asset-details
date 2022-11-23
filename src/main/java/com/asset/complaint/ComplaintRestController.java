package com.asset.complaint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/asset/")
public class ComplaintRestController {

	
	 @PostMapping(value = "feedback/form/submitComplaint") 
	 public String feedbackFormSubmit(@ModelAttribute Complaint complaint, ComplaintQuestion complaintQuestion) {
	  
		 String complaintId=""; 
		  String name="NA";
		  String address="NA";
		  String email="NA";
		  String mobileNo="9789332040"; 
		  String complaintType="18";
		  String complaintTitle="Mosquitomenace";
		  String complaintDetail="TestDetail";
		  String streetId="25956";
		  String image="NA";
		  String latitude="NA";
		  String longtitude="NA";
		  String landmark="NA";
	  
	  try { 
	  
	  String urlString = "https://erp.chennaicorporation.gov.in/pgr/external/mobileservice?\r\n" +
	  "serviceId=RegComplaint&\r\n" + "ComplainantName="+name+"&\r\n" +
	  "ComplainantAddr="+address+"&\r\n" + "MobileNo="+mobileNo+"&\r\n" +
	  "Email="+email+"&\r\n" + "ComplaintType="+complaintType+"&\r\n" +
	  "ComplaintTitle="+complaintTitle+"&\r\n" +
	  "ComplaintDetails="+complaintDetail+"&\r\n" + "StreetId="+streetId+"&\r\n" +
	  "Comp_Image="+image+"&\r\n" + "latitude="+latitude+"&\r\n" + "longtitude="+longtitude+"&\r\n" +
	  "Landmark="+landmark+"";
	  
	  System.out.print("urlString"+urlString);
	  
	  URL myurl = null; myurl = new URL(urlString ); 
	  
	  URLConnection connection = myurl.openConnection(); 
	  System.out.print("Sending Sucess");
	  
	  HttpURLConnection conn = (HttpURLConnection)myurl.openConnection(); 
	  conn.connect(); BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
	  String line = ""; String page_line = ""; 
	  while( (line = br.readLine() ) != null ) {
		  page_line += line+""; 
	  } 
	  System.out.println("page_line :" +page_line);
	  
	  String[] tempvalue = page_line.split("<br>");
	  System.out.print("tempvalue"+tempvalue);
	  
	  //String outputvalue = "";
		boolean isConnected = (conn.getContentLength() > 0);
		java.util.Date dt=new java.util.Date();
		System.out.print("Date"+dt);
		if(isConnected)
		{
			System.out.print("Sending Sucess");
			conn.disconnect();
		}
	  
	  }catch(Exception ex) { 
		  System.out.println("Error "+ex+" MobileNo"+mobileNo); 
	  }
	  
	 return null; 
	  }
	 
}
