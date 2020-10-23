package com.taskmaster.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
//import java.util.Scanner;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmaster.model.Alert;
import com.taskmaster.repository.AlertRepository;
@Service
public class AlertServiceImpl implements AlertService {
	@Autowired
	AlertRepository ar;
	/* (non-Javadoc)
	 * @see com.taskmaster.service.AlertService#findAlertByID(int)
	 */
	@Override
	public Alert findAlertByID(int id){
		try {
			return ar.findById(id).get();	
		} catch(NoSuchElementException e) {
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see com.taskmaster.service.AlertService#findAllAlertsByPhone(java.lang.String)
	 */
	@Override
	public List<Alert> findAllAlertsByPhone(String phone){
		List<Alert> al = new ArrayList<Alert>();
		al = ar.findAllByPhone(phone);
		return al;
	}
	/* (non-Javadoc)
	 * @see com.taskmaster.service.AlertService#findAllAlertsByDatetime(java.lang.String)
	 */
	@Override
	public List<Alert> findAllAlertsByDatetime(){
		List<Alert> al = new ArrayList<Alert>();
		Calendar cal = Calendar.getInstance();
		Date now = new Date();
		String ampm;
		cal.setTime(now);
		if(cal.get(Calendar.AM_PM) == 0) {
			ampm = "AM";
		}
		else {
			ampm = "PM";
		}
		String zeroes[] = {"", "", ""};
		if(cal.get(Calendar.MONTH) < 10)
		{
			zeroes[0] = "0"; 
		}
		if(cal.get(Calendar.DATE) < 10)
		{
			zeroes[1] = "0";
		}
		if(cal.get(Calendar.MINUTE) < 10) {
			zeroes[2] = "0";
		}
		int month = cal.get(Calendar.MONTH)+1;
		String datetime = zeroes[0] + month + "/" + zeroes[1] + cal.get(Calendar.DATE) + "/" + cal.get(Calendar.YEAR) + " " + cal.get(Calendar.HOUR) + ":" + zeroes[2] + cal.get(Calendar.MINUTE) + " " + ampm;
//		System.out.println(datetime);
		al = ar.findAllByDatetime(datetime);
		for(Alert alert : al) {
			if(alert.getRepeatNum() == 1) {
				deleteAlertById(alert.getId());
			}
			else if(alert.getRepeatNum() > 1) {
				alert.setDateTime(incrementDate(alert));
				editAlertById(alert.getId(), "datetime", alert.getDateTime());
				editAlertById(alert.getId(), "repeatcount", "" + (alert.getRepeatNum() - 1));
			}
		}
		return al;
	}

	public void addAlert(String phone, String message, String datetime, int repeatincrement, int repeatcount) {
		Alert x = new Alert();
		x.setPhone(phone);
		x.setMessage(message);
		x.setDateTime(datetime);
		x.setRepeatNum(repeatcount);
		x.setRepeatTime(repeatincrement);
		ar.save(x);
	}
	@Override
	public void deleteAlertById(int id){
		ar.deleteById(id);
	}
	@Override
	public void editAlertById(int id, String column, String value) {
		Alert selectedRow = ar.findById(id).get();
		int numvalue;
		switch(column) {
			case "message":
				selectedRow.setMessage(value);
				break;
			case "datetime":
				selectedRow.setDateTime(value);
				break;
			case "repeatincrement":
				numvalue = Integer.parseInt(value);
				selectedRow.setRepeatTime(numvalue);
				break;
			case "repeatcount":
				numvalue = Integer.parseInt(value);
				selectedRow.setRepeatNum(numvalue);
				break;
		};
		ar.save(selectedRow);
	}
	public String incrementDate(Alert alert) {
		String[] times = alert.getDateTime().split("[/| |:]");
		int minutes = Integer.parseInt(times[4]);
		int hours = Integer.parseInt(times[3]);
		int days = Integer.parseInt(times[1]);
		int month = Integer.parseInt(times[0]);
		int year = Integer.parseInt(times[2]);
		minutes += alert.getRepeatTime();
		while(minutes >= 60) {
			hours = Integer.parseInt(times[3]);
			minutes -= 60;
			hours++;
			if(hours > 12 && times[5].equals("AM")) {
				hours -= 12;
				times[5] = "PM";
			}
			else if(hours > 12 && times[5].equals("PM")) {
				hours -= 12;
				times[5] = "AM";
				days++;
			}
			if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if(days > 31) {
					days -= 31;
					if(month == 12) {
						month -= 12;
						year++;
					}
					month++;
				}
			}
			else if(month == 4 || month == 6 || month == 9 || month == 11) {
				if(days > 30) {
					days -= 30;
					month++;
				}
			}
			else if(month == 2 && (year % 4) == 0) {
				if(days > 29) {
					days -= 29;
					month++;
				}
			}
			else if(month == 2) {
				if(days > 28) {
					days -= 28;
					month++;
				}
			}
		}
		String monthS = ""+month;
		String dayS = ""+days;
		String minuteS = ""+minutes;
		if(month < 10) {
			monthS = "0" + month;
		}
		else {
			monthS = String.valueOf(month);
		}
		
		if(days < 10) {
			dayS = "0" + days;
		}
		if(minutes < 10) {
			minuteS = "0" + minutes;
		}
		return monthS + "/" + dayS + "/" + year + " " + hours + ":" + minuteS + " " + times[5];

	}
}
