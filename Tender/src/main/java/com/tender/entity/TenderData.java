package com.tender.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.sun.istack.NotNull;

@Entity
public class TenderData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int serialID;
	@NotNull
	private int tenderID;
	@NotNull
	private String date;
	@NotNull
	private String workname;
	@NotNull
	private String tendername;
	@NotNull
	private String extention;
	
	
	
	
	public int getSerialID() {
		return serialID;
	}
	public void setSerialID(int serialID) {
		this.serialID = serialID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getExtention() {
		return extention;
	}
	public void setExtention(String extention) {
		this.extention = extention;
	}
	public int getTenderID() {
		return tenderID;
	}
	public void setTenderID(int tenderID) {
		this.tenderID = tenderID;
	}
	public String getWorkname() {
		return workname;
	}
	public void setWorkname(String workname) {
		this.workname = workname;
	}
	public String getTendername() {
		return tendername;
	}
	public void setTendername(String tendername) {
		this.tendername = tendername;
	}
	
	

}
