package com.taskmaster.test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.taskmaster.model.Alert;
import com.taskmaster.service.AlertService;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {AlertService.class})

class AlertServiceTest {

	@Autowired
	private AlertService as;
	
	@MockBean
	private Alert findAllAlertsByDatetime;
	
	@Test
	public void Alert() {
	     final addAlert notify = new addAlert();
		
		Mockito.when(findAllAlertsByDatetime.getDateTime()).thenReturn()
				.getPhone(al)).thenReturn(new Alert("+18325555555, 03/09/2019 08:15 AM, 3, 1"));
		
	final Alert findbyPhone = as.findAllAlertsByPhone("+18325555555");
	  assertThat(addAler
	}
	
	
	
	
	@Test
	
	
	
	
	
	

}
