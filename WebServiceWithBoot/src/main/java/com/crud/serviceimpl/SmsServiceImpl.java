package com.crud.serviceimpl;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.crud.entity.SmsEntity;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.crud.service.SmsService;
import com.twilio.Twilio;
@Service
public class SmsServiceImpl implements SmsService {

	final String ACCOUNT_SID ="AC8e1233003286b0c2bcf3abd1af0a8873";

    final String AUTH_TOKEN = "71c74d02feae6eeb0947ef653b23cd61";

    final String FROM_NUMBER = "+19198872584";

	@Override
	public void send(SmsEntity sms) {
		System.out.println("Message:::::"+sms.getMessage());
		System.out.println("No:::::"+sms.getTo());
		
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
	                .create();
	        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

	    
	}

	@Override
	public void receive(MultiValueMap<String, String> smscallback) {
		// TODO Auto-generated method stub
		
	}

}
