package com.tender.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tender.entity.TenderData;
import com.tender.entity.TenderID;
import com.tender.repository.TenderRepository;
import com.tender.service.TenderService;
import com.tender.util.ToDayDate;

@Service
public class TenderServiceIMPL implements TenderService {
	@Autowired
	TenderRepository repository;
	
	

	@Override
	public TenderData getIdbyDate() {
		System.out.println("execited  getIdbyDate");
		TenderData tdata=new TenderData();
		
		TenderData lastId = repository.getLastid();
		
		System.out.println("lastId::::"+lastId.getTenderID());
		if (Objects.isNull(lastId)) {
			System.out.println("execited if getIdbyDate");
			tdata.setTenderID(01);
		} else {
			System.out.println("execited else getIdbyDate");
			ToDayDate today = new ToDayDate();

			String strDate = today.getDate();
			String lastdate = lastId.getDate();
			if (lastdate.equals(strDate) || lastdate.equals(null)) {
				
				String str = String.format("%02d",lastId.getTenderID());
				System.out.println("str::::"+(str));
				Integer.parseInt(str);
				tdata.setTenderID( lastId.getTenderID()+ 01);
			} else {
				tdata.setTenderID(01);
			}
		}
		return tdata;
	}

	@Override
	public void newTender(TenderData tdata) {

		String workname = tdata.getWorkname();
		System.out.println("workname:::"+workname);
		// get 1st word
		String arr[] = workname.split(" ", 2);

		String firstWord = arr[0];
		String tender_name_prefix = "Tender_";
		System.out.println("tender_name_prefix:::"+tender_name_prefix);
		// date
		ToDayDate today = new ToDayDate();

		String strDate = today.getDate();
		System.out.println("strDate:::"+strDate);
		tdata.setDate(strDate);

		// tender id

		TenderData data = getIdbyDate();
		int tender_id = data.getTenderID();
		System.out.println("tender_id:::"+tender_id);
		tdata.setTenderID(tender_id);
		// extention

		String ext = tdata.getExtention();

		String tender_name = tender_name_prefix + firstWord + "_" + tender_id + "_" + strDate + ext;
		System.out.println("tender_name:::"+tender_name);
		tdata.setTendername(tender_name);
		TenderData td=repository.save(tdata);
		System.out.println("TenderData after insert:::"+td.getTenderID());

	}

	@Override
	public List<TenderData> getTender() {
		List<TenderData> teList = (List<TenderData>) repository.findAll();
		return teList;
	}

}
