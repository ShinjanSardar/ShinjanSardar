package com.tender.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TenderID {
	@Id
	private int ID;
	private int tenderID;
	
	private String date;

	public int getTenderID() {
		return tenderID;
	}

	public void setTenderID(int tenderID) {
		this.tenderID = tenderID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
