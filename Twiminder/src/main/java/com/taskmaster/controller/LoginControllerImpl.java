package com.taskmaster.controller;
import com.taskmaster.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginControllerImpl {

	@Autowired
	LoginService ls;
	
	
	@GetMapping(path="/phone/{phone}", consumes = "application/json", produces = "application/json")
    public String Login(@PathVariable String phone, String password) {
        return ls.Login(phone, password);
	}
	
	
}