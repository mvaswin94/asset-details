package com.asset.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/asset/api")
public class apiRestController {

	@GetMapping(value = "/getZoneNo")
	public String getZoneNo() {

		String urlString = "https://erp.chennaicorporation.gov.in/pgr/external/mobileservice?serviceId=getZones";
		//System.out.print("\n urlString---:  " + urlString);

		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		String bodyMessage = "";
		HttpHeaders headers = new HttpHeaders();
		try {
			HttpEntity<String> postData = new HttpEntity<String>(headers);
			response = restTemplate.exchange(urlString, HttpMethod.POST, postData, String.class);
			bodyMessage = response.getBody();
			//System.out.println("\n bodyMessage" + bodyMessage);

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.print("\n ERROR---:  " + e);
			bodyMessage = "Error";
		}
		return bodyMessage;
	}
}
