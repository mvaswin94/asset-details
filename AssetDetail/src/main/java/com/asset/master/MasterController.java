package com.asset.master;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/asset/master")
public class MasterController {
	
	@Autowired
	MasterRepository masterRepo;
	
	@Autowired
	MasterDetailRepository masterDetailRepo;
	
	@Autowired
	MasterViewRepository masterVieRepo;
	
	@GetMapping(value = "entry")
	public String masterEntry(Model model) {
		model.addAttribute("masterObj", new Master());
		return "asset-master-entry";
	}
	
	@PostMapping(value = "/entry/submit")
	public String masterEntrySubmit(@ModelAttribute Master master) {

		Master obj = new Master();
			obj.setMasterId(master.getMasterId());
			obj.setMasterName(master.getMasterName());
			/* obj.setMasterDate(master.getMasterDate()); */
			masterRepo.saveAndFlush(obj);

		return "redirect:/asset/master/entry";
	}
	
	@GetMapping(value = "/list")
	public String masterList(Model model) {
		
		System.out.println("OBJ TEST2");
		/* List<MasterView> obj = masterVieRepo.findAllMasterDetail(); */
		List<Master> obj = masterRepo.findAll(); 
		System.out.println("OBJ TEST"+obj);
		model.addAttribute("page", obj);
		
		return "asset-master-list";
	}
	
	@GetMapping(value = "/list/edit/{keyword}")
	public String masterEdit(@PathVariable Integer keyword, Model model) {
		new Master();
		Optional<Master> Master = masterRepo.findById(keyword);
		Master masterObj = Master.get();
		model.addAttribute("page", masterObj);
		
		model.addAttribute("masterObj", masterObj);
		
		return "asset-master-entry";
	}
	
	@GetMapping(value = "/list/delete/{keyword}")
	public String masterDelete(@PathVariable Integer keyword, Model model) {

		masterRepo.deleteById(keyword);

		return "redirect:/asset/master/list";
	}
}