package com.taskmaster.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmaster.service.UserService;

@RestController
@RequestMapping("/user")
public class UserControllerImpl {
	
	@Autowired
	UserService us;
	
	@PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
	public boolean validateUser(@RequestBody Map<String, String> json) {
		return us.validateUser(json.get("pn"), json.get("pw"));
	}
	
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public String addUser(@RequestBody Map<String, String> json) {
		return us.addUser(json.get("pn"), json.get("pw"));
	}
	
	@PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
	public String deleteUserByPhone(@RequestBody Map<String, String> json) {
		return us.deleteUserByPhone(json.get("pn"));
	}
	
	@PostMapping(path = "/editPassword", consumes = "application/json", produces = "application/json")
	public String editUserPassword(@RequestBody Map<String, String> json) {
		return us.editUserPassword(json.get("pn"), json.get("newPw"));
	}
	
}
