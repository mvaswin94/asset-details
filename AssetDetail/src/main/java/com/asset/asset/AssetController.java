package com.asset.asset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/asset")
public class AssetController {
	
	@Autowired
	AssetRepository repo;
	
	@RequestMapping(value = "/entry", method = RequestMethod.GET)
	public String assetEntry() {
		//System.out.println("TEST NOW");
		return "asset-detail-entry";
	}
	
	@PostMapping(value = "/entry/submit")
	public String assetEntrySubmit(@ModelAttribute Asset asset, Model model) {
		repo.save(asset);
		return "redirect:/asset/entry";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String assetList() {
		//System.out.println("TEST NOW");
		return "asset-detail-list";
	}
}	
