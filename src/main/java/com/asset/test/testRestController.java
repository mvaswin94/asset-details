package com.asset.test;

import java.math.BigDecimal;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/asset")
public class testRestController {
	
	@RequestMapping(value = "/test/map", method = RequestMethod.GET)
	public String testMap(HttpServletRequest request, @RequestParam String locationName) {
		
		String sSearchLocation ="";
		//String sTmp = request.getParameter("locname");
		String sTmp = locationName;
		String sLATITUDE = "";
		String sLONGITUDE = ""; 
		if ( sTmp != null && !sTmp.equals("") ) sSearchLocation = sTmp;
		System.out.println("sSearchLocation---: "+ sSearchLocation);
		String str=request.getParameter("serviceinput");
		
	 	if (str==null )
			{
			}
		else
			{
		 
			JSONObject lg = new JSONObject(str);
			System.out.println("latitude : "+ lg.get("latitude"));
			System.out.println("longitude : "+ lg.get("longitude"));
			
			sLATITUDE =""+ (Double)lg.get("latitude");
			sLONGITUDE = ""+ (Double)lg.get("longitude");
			}

		if ( (sLATITUDE==null ||  sLATITUDE.equals("")) && ( sLONGITUDE==null || sLONGITUDE.equals("") ) )
			{
		if (!sSearchLocation.equals("")) {
		try{
				String urlString ="http://10.1.0.122/geocode_api.php?address="+ URLEncoder.encode( sSearchLocation, "UTF-8" );
				System.out.println(urlString);
			 
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
				
				JSONObject object = new JSONObject(bodyMessage);
				
				if ( (Boolean)object.get("status")) 
				{
					JSONObject dataObject = (JSONObject) object.get("data");
					System.out.println("latitude  1 : "+ dataObject.get("latitude"));
					System.out.println("longitude 1 : "+ dataObject.get("longitude"));
					
					sLATITUDE = ""+ (BigDecimal)dataObject.get("latitude");
					sLONGITUDE = ""+ (BigDecimal)dataObject.get("longitude");
				}
			}
			catch(Exception e)
			{ 	System.out.println(e); }
			
		}
		else if(request.getParameter("latitude")!=null && request.getParameter("longitude")!=null)
		{
			sLATITUDE = request.getParameter("latitude");
			sLONGITUDE = request.getParameter("longitude");	
		}
		else
		{
			sLATITUDE = "13.0827";
			sLONGITUDE = "80.2707";
		}
		}
		
		if ( sLATITUDE == null || sLATITUDE.equals("") || sLONGITUDE == null || sLONGITUDE.equals("")  ) 
		{ 	
			//out.println("<br><br><center><b>No Data Found</b></center>"); 
			System.out.println("Record Not Found"); 
			//return;
		}
		String bodyMessage = sLATITUDE;
		System.out.println("sLATITUDE---:"+sLATITUDE);		
		System.out.println("sLONGITUDE---:"+sLONGITUDE);
		
		return bodyMessage;
	}
}
