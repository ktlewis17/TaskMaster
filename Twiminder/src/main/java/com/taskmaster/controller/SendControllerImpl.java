package com.taskmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taskmaster.service.sendService;



@RestController
@RequestMapping("/twilio")
public class SendControllerImpl {
	
	@Autowired
	sendService ss;
	
	@GetMapping ("/send")
	public String sendAlert(@RequestParam String phone, @RequestParam String message) {
		ss.sendAlert(phone, message);
		return "Alert Sent";
	}
	
}
