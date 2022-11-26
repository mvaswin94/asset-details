package com.asset.asset;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asset.master.Master;
import com.asset.master.MasterRepository;

@Controller
@RequestMapping(value = "/asset")
public class AssetController {

	@Autowired
	AssetRepository assetRepo;
	
	@Autowired
	MasterRepository masterRepo;

	@GetMapping(value = "entry")
	public String assetEntry(Model model) {
		model.addAttribute("assetEntryObj", new Asset());
		
		List<Master> obj = masterRepo.findAll();
		model.addAttribute("masterObj", obj);
		
		return "asset-detail-entry";
	}

	@PostMapping(value = "/entry/submit")
	public String assetEntrySubmit(@ModelAttribute Asset asset) {

		Asset obj = new Asset();

		obj.setAssetId(asset.getAssetId());
		obj.setZoneNo(asset.getZoneNo());
		obj.setDivNo(asset.getDivNo());
		obj.setAssetType(asset.getAssetType());
		obj.setAssetName(asset.getAssetName());
		obj.setAssetAddress(asset.getAssetAddress());
		obj.setAssetOpeningTime(asset.getAssetOpeningTime());
		obj.setAssetClosingTime(asset.getAssetClosingTime());
		obj.setAssetArea(asset.getAssetArea());
		obj.setAssetLocality(asset.getAssetLocality());
		obj.setAssetStreet(asset.getAssetStreet());
		obj.setAssetFile(asset.getAssetFile());
		
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
		
		model.addAttribute("assetSearchObj", new Asset());

		System.out.println("OBJ---:"+obj);
		return "asset-detail-list";
	}
	
	@GetMapping(value = "/list/edit/{assetId}")
	public String proMasterClientListGet(@PathVariable Integer assetId, Model model) {

		new Asset();
		Optional<Asset> asset = assetRepo.findById(assetId);
		Asset assetObj = asset.get();
		model.addAttribute("assetEntryObj", assetObj);
		
		System.out.println("assetObj---:"+assetObj);
		return "asset-detail-entry";
		
	}
	
	@GetMapping(value = "/list/search")
	public String assetListSearch(Model model,@PageableDefault(size = 1000) Pageable pageable) {
		Page<Asset> obj = assetRepo.findAll(pageable);
		model.addAttribute("page", obj);
		
		model.addAttribute("assetSearchObj", new Asset());

		System.out.println("OBJ---:"+obj);
		return "asset-detail-list";
	}
}
