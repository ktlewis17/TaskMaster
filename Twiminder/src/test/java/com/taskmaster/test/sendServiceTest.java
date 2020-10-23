//package com.taskmaster.test;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.catchThrowable;
//import static org.hamcrest.CoreMatchers.startsWith;
//import static org.junit.Assert.*;
//import java.io.IOException;
//
//import org.junit.Test;
//import org.junit.platform.commons.annotation.Testable;
//import org.junit.runner.RunWith;
//import org.junit.runners.Suite;
//import org.junit.runners.Suite.SuiteClasses;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.taskmaster.service.sendService;
//import com.taskmaster.service.sendServiceImpl;
//import com.taskmaster.*;
//
//
//@RunWith(SpringRunner.class)
//public class sendServiceTest {
//
//	 private sendServiceImpl service = new sendServiceImpl();
//	
//	
//	@Test 
//	public void send() {
//		
//		final String sendMsg = service.toString();
//		assertThat(sendMsg).isNotNull();
//	}
//}