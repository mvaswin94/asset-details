package com.asset.asset;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/asset")
public class AssetController {
	
	@RequestMapping(value = "/entry", method = RequestMethod.GET)
	public String assetForm() {
		//System.out.println("TEST NOW");
		return "asset-detail-entry";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String assetList() {
		//System.out.println("TEST NOW");
		return "asset-detail-list";
	}
}	
