package com.asset.complaint;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class ComplaintService {

	public String registerPgrComplaint() {
		
		 // URLs
	    //private String INTEGRATION_URL = "http://freedomris.ddns.net:8001/FreedomRisNotificationApp";
	    //private String INTEGRATION_TOKEN_URL = INTEGRATION_URL + "/token";
	    //private String INTEGRATION_CLIENT_URL = INTEGRATION_URL + "/api/v1/GetClient";
	    //private String INTEGRATION_BILL_URL = INTEGRATION_URL + "/api/v1/GetBill";
		
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
        //headers.add("Content-Type", "application/x-www-form-urlencoded");
        try {
            HttpEntity<String> postData = new HttpEntity<String>(headers);
           // response = restTemplate.exchange(INTEGRATION_TOKEN_URL, HttpMethod.POST, postData, String.class);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        String bodyMessage = response.getBody();
        return bodyMessage;
    }

}
