package com.tender.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tender.entity.TenderData;


public interface TenderService {
	 
	public void newTender(TenderData tdata);
	public List<TenderData> getTender();
	public TenderData getIdbyDate();
	

}
