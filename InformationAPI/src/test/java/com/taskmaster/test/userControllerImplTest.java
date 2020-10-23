package com.taskmaster.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import com.taskmaster.controller.UserControllerImpl;



	@RunWith(SpringRunner.class)
	public class userControllerImplTest {

		
		 private UserControllerImpl uc = new UserControllerImpl();
		
//		@Test 
//		public void ucontrol() {
//				uctrl =uc.addUser(pn, pw)
//				assertThat(uctrl)
//		}
		
		@Test 
		public void ucontrol() {
		 uctrl = uc.validateUser();
			assertThat(uctrl).isNotNull();
			
			
			
	
		}
//		
//		
//		@Test
//		public void ucontrol() {
//			boolean ucontrol = uc.deleteUserByPhone(pn)(pn, pw)
//			assertThat(ctrlsend).isNotEqualTo("");
//		}
//		
//		@Test 
//		public void ucontrol() {
//			boolean ucontrol = uc.editUserPassword(pn, newPw)(pn)(pn, pw)
//			assertThat(ctrlsend).isNotEqualTo("");
//		}
////		@Test 
////		public void ucontrol() {
////			boolean ucontrol = uc.equals("")
////			assertThat(ucontrol).isNotEqualTo("");
////		}
////		
////		
//		
//
	


}
