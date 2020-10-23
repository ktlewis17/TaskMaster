package com.taskmaster.test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taskmaster.model.Alert;
import com.taskmaster.service.AlertServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlertTest {
	
	@Autowired
	private AlertServiceImpl as;

	@Test
	public void add() {
		as.addAlert("+12087948890", "aaaa", "03/08/2020 9:00 PM", 1, 1);
		assertThat(as.findAllAlertsByPhone("+12087948890"), not(IsEmptyCollection.empty()));
	}
	@Test
	public void edit() {
		Alert al = as.findAllAlertsByPhone("+12087948890").get(0);
		as.editAlertById(al.getId(), "message", "bbbb");
		al = as.findAlertByID(al.getId());
		assertThat(al.getMessage(), equalTo("bbbb"));
	}
	@Test
	public void delete() {
		Alert al = as.findAllAlertsByPhone("+12087948890").get(0);
		as.deleteAlertById(al.getId());
		assertNull(as.findAlertByID(al.getId()));
	}
	@Test
	public void increment() {
		Alert al = new Alert(1, "123", "aaaa", "03/11/2020 8:59 AM", 5, 5);
		al.setDateTime(as.incrementDate(al));
		assertThat(al.getDateTime(), equalTo("03/11/2020 9:04 AM"));
	}
}
