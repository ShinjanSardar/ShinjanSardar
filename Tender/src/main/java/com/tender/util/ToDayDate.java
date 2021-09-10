package com.tender.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDayDate {

	public String getDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");
		String strDate = formatter.format(date);
		System.out.println(strDate);
		return strDate;
	}
}
