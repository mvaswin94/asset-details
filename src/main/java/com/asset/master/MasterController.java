package com.asset.master;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/asset/master")
public class MasterController {
	
	@Autowired
	MasterRepository masterRepo;
	
	@Autowired
	MasterDetailRepository masterDetailRepo;
	
	@Autowired
	MasterParametersRepository masterParametersRepo;
	
	@Autowired
	MasterViewRepository masterViewRepo;
	
	@GetMapping(value = "entry")
	public String masterEntry(Model model, Master master, MasterDetail masterDetail, MasterParameters masterParameters) {
		//model.addAttribute("masterObj", new MasterView());
		model.addAttribute("masterList", new Master());
		
		//model.addAttribute("masterParametersList",  new MasterParameters());
		model.addAttribute("masterParametersList",  masterParameters.getMasterParameters());
		model.addAttribute("masterDetailList",  new MasterDetail());
		return "asset-master-entry";
	}
	
	@PostMapping(value = "/entry/submit")
	public String masterEntrySubmit(@ModelAttribute Master master, MasterDetail masterDetail, 
			MasterParameters masterParameters, @RequestBody ArrayList<MasterDetail> masterDetailList) {

		Master obj = new Master();
		obj.setMasterId(master.getMasterId());
		obj.setMasterName(master.getMasterName());
		masterRepo.saveAndFlush(obj);
		
		MasterDetail obj2 = new MasterDetail();
		obj2.setMasterId(master.getMasterId());
		obj2.setMasterName(master.getMasterName());
		obj2.setMasterQuestionTamil(masterDetail.getMasterQuestionTamil());
		obj2.setMasterQuestionEnglish(masterDetail.getMasterQuestionEnglish());
		obj2.setMasterQuestionType(masterDetail.getMasterQuestionType());
		masterDetailRepo.saveAndFlush(obj2);
		
		for (int i = 0; i < masterDetailList.size(); i++) {
			MasterDetail objLoop = masterDetailList.get(i);

			MasterDetail obj4 = new MasterDetail();
			obj4.setMasterId(master.getMasterId());
			obj4.setMasterName(master.getMasterName());
			obj4.setMasterQuestionTamil(objLoop.getMasterQuestionTamil());
			obj4.setMasterQuestionEnglish(objLoop.getMasterQuestionEnglish());
			obj4.setMasterQuestionType(objLoop.getMasterQuestionType());
			masterDetailRepo.saveAndFlush(obj4);

		}
		
		MasterParameters obj3 = new MasterParameters();
		obj3.setMasterId(master.getMasterId());
		obj3.setMasterName(master.getMasterName());
		obj3.setMasterParameters(masterParameters.getMasterParameters());
		masterParametersRepo.saveAndFlush(obj3);

		return "redirect:/asset/master/entry";
	}
	
	@GetMapping(value = "/list")
	public String masterList(Model model) {
		
		/* System.out.println("OBJ TEST2"); */
		/* List<MasterView> obj = masterVieRepo.findAllMasterDetail(); */
		List<Master> obj = masterRepo.findAll(); 
		/* System.out.println("OBJ TEST"+obj); */
		model.addAttribute("page", obj);
		
		model.addAttribute("masterSearchObj", new MasterView());
		
		model.addAttribute("masterList", obj);
		
		return "asset-master-list";
	}
	
	@GetMapping(value = "/list/edit/{keyword}")
	public String masterEdit(@PathVariable Integer keyword, Model model) {
		/*
		 * new MasterView(); Optional<MasterView> MasterView =
		 * masterViewRepo.findById(keyword); MasterView masterObj = MasterView.get();
		 * model.addAttribute("page", masterObj);
		 */
		
		new Master();
		Optional<Master> Master = masterRepo.findById(keyword);
		Master masterObj = Master.get();
		model.addAttribute("masterList", masterObj);
		
		new MasterParameters();
		Optional<MasterParameters> MasterParameters = masterParametersRepo.findById(keyword);
		MasterParameters masterParametersObj = MasterParameters.get();
		model.addAttribute("masterParametersList", masterParametersObj);
		
		new MasterDetail();
		Optional<MasterDetail> MasterDetail = masterDetailRepo.findById(keyword);
		MasterDetail masterDetailObj = MasterDetail.get();
		model.addAttribute("masterDetailList", masterDetailObj);
		
		return "asset-master-entry";
	}
	
	@GetMapping(value = "/list/delete/{keyword}")
	public String masterDelete(@PathVariable Integer keyword, Model model) {

		masterRepo.deleteById(keyword);

		return "redirect:/asset/master/list";
	}
}