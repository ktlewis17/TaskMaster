package com.taskmaster.service;

import java.util.List;

//import org.springframework.web.bind.annotation.PathVariable;

import com.taskmaster.model.Alert;

public interface AlertService {

	Alert findAlertByID(int id);

	List<Alert> findAllAlertsByPhone(String phone);

	List<Alert> findAllAlertsByDatetime();
	
	void addAlert(String phone, String message, String datetime, int repeatincrement, int repeatcount);

	void deleteAlertById(int id);

	void editAlertById(int id, String column, String value);

}