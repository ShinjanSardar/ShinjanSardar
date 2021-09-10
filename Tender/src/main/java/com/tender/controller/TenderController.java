package com.tender.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tender.entity.TenderData;
import com.tender.service.TenderService;

@RestController

public class TenderController {
	
	@Autowired
	TenderService tService;
	
	@GetMapping("/home")
	public String  homePage() {
	
		return "home";
		
	}
	@GetMapping("/lastid")
	public TenderData  viewPage() {
		
		TenderData tid=tService.getIdbyDate();
		
		return tid;
	}
	
	@PostMapping("/save")
	public void savetender(@RequestBody TenderData tdata) {
		tService.newTender(tdata);
		
	}
	@GetMapping("/view")
	public List<TenderData> getalltender() {
		List<TenderData> tenderlist=tService.getTender();
		return tenderlist;
		
	}
	@GetMapping("/getid")
	public TenderData getIdbyDate() {
	TenderData tenderlist=tService.getIdbyDate();
		return tenderlist;
		
	}
	
}

	
	

