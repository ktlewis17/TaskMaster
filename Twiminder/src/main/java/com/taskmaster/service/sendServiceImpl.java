package com.taskmaster.service;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class sendServiceImpl implements sendService {

	public void sendAlert(String phone, String message ) {

		String ACCOUNT_SID ="AC164aa94a9faad88eb5fbc15932d944b8";
	    String AUTH_TOKEN ="f38a875955d2bd05e39e191588b9b5bb";
		 
		
	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message mesage = Message
                .creator(new PhoneNumber(phone), // to
                        new PhoneNumber("+12058393453"), // from Twilio number
                        message)
                .create();

        System.out.println(mesage.getUri());		
}
	
	
	
	
	
	
	
	
}
