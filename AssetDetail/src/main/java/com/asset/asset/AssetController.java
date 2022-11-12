package com.asset.asset;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/asset")
public class AssetController {
	
	AssetRepository repo;
	
	//@RequestMapping(value = "/entry", method = RequestMethod.GET)
	@GetMapping(value = "entry")
	public String assetEntry(Model model) {
		//System.out.println("TEST NOW");
		model.addAttribute("assetEntryObj", new Asset());
		return "asset-detail-entry";
	}
	
	@PostMapping(value = "/entry/submit")
	public String assetEntrySubmit(@ModelAttribute Asset asset) {
		if (asset != null) {
			System.out.println("Asset"+asset);
		    System.out.println("result not null");
		    if (repo == null) {
		    	System.out.println("Asset"+asset);
		    	System.out.println("repo is null");
		    }else {
		    	System.out.println("Asset"+asset);
		    }
		    repo.save(asset);
		}
		return "redirect:/asset/entry";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String assetList() {
		//System.out.println("TEST NOW");
		return "asset-detail-list";
	}
}	
