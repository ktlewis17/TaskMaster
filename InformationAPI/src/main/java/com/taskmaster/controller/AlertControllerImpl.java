package com.taskmaster.controller;

import com.taskmaster.model.Alert;
import com.taskmaster.service.AlertService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alert")
public class AlertControllerImpl {
	@Autowired
	AlertService as;
	
	@GetMapping("/id/{id}")
	public Alert getAlertById(@PathVariable int id) {
		return as.findAlertByID(id);
	}
	@GetMapping("/phone/{phone}")
	public List<Alert> getAllAlertsByPhone(@PathVariable String phone){
		return as.findAllAlertsByPhone(phone);
	}
	@GetMapping("/run")
	public List<Alert> getAllAlertsByDatetime(){
		return as.findAllAlertsByDatetime();
	}
	/*@PostMapping("/edit/{id}/{column}/{newvalue}")
	public String edit(@PathVariable int id, @PathVariable Optional<String> column, @PathVariable Optional<String> newvalue) {
		String columnGet = column.orElseGet(() -> "not provided");
		String valueGet = newvalue.orElseGet(() -> "not provided");
		String response = "column is " + columnGet + '\n' + "newvalue is " + valueGet;
		
		if(!columnGet.equals("not provided") || !valueGet.equals("not provided")) {
			as.editAlertById(id, columnGet, valueGet);
		}
		return response;
	}*/
	@PostMapping(path = "/edit", consumes = "application/json", produces = "application/json")
		public String editAlert(@RequestBody Map<String, String> json) {
			String idstring = json.get("id");
			int id = Integer.parseInt(idstring);
			String column = json.get("column");
			String newvalue = json.get("new value");
			as.editAlertById(id, column, newvalue);
			return "The new value of alert " + id + "'s " + column + " is " + newvalue;
		}
	
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		as.deleteAlertById(id);
	}

	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public String addAlert(@RequestBody Map<String, String> json) {
		String ri = json.get("repeatincrement");
		String rc = json.get("repeatcount");
		int repeatincrement = Integer.parseInt(ri);
		int repeatcount = Integer.parseInt(rc);
		
		as.addAlert(json.get("phone"),json.get("message") , json.get("datetime"), repeatincrement, repeatcount);
		
		return "Alert Added";
	}
}
