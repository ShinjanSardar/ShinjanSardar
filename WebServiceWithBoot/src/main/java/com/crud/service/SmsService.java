package com.crud.service;

import org.springframework.util.MultiValueMap;

import com.crud.entity.SmsEntity;

public interface SmsService {
	
	
	

    public void send(SmsEntity sms);

    public void receive(MultiValueMap<String, String> smscallback);


}
