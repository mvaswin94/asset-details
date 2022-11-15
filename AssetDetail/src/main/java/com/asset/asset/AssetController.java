package com.asset.asset;

import java.sql.Date;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/asset")
public class AssetController {

	@Autowired
	AssetRepository assetRepo;

	/*
	 * public AssetController(AssetRepository repo) { this.repo = repo; }
	 */

	// @RequestMapping(value = "/entry", method = RequestMethod.GET)
	@GetMapping(value = "entry")
	public String assetEntry(Model model) {
		// System.out.println("TEST NOW");
		model.addAttribute("assetEntryObj", new Asset());
		return "asset-detail-entry";
	}

	@PostMapping(value = "/entry/submit")
	public String assetEntrySubmit(@ModelAttribute Asset asset) {

		Asset obj = new Asset();

		obj.setAssetId(asset.getAssetId());
		obj.setRegion(asset.getRegion());
		obj.setZoneNo(asset.getZoneNo());
		obj.setDivNo(asset.getDivNo());
		obj.setAssetName(asset.getAssetName());
		obj.setAssetType(asset.getAssetType());
		obj.setAssetAddress(asset.getAssetAddress());
		obj.setAssetTimingFrom(asset.getAssetTimingFrom());
		obj.setAssetTimingTo(asset.getAssetTimingTo());
		obj.setAssetDate(asset.getAssetDate());
		obj.setAssetFile(asset.getAssetFile());

		/* System.out.println("OBJ---:"+obj); */
		
		assetRepo.saveAndFlush(obj);

		return "redirect:/asset/entry";
	}

	/*
	 * @RequestMapping(value = "/list", method = RequestMethod.GET) public String
	 * assetList() { // System.out.println("TEST NOW"); return "asset-detail-list";
	 * }
	 */
	
	@GetMapping(value = "/list")
	public String assetList(Model model, @PageableDefault(size = 1000) Pageable pageable) {
		Page<Asset> obj = assetRepo.findAll(pageable);
		model.addAttribute("page", obj);

		System.out.println("OBJ---:"+obj);
		return "asset-detail-list";
	}
}
