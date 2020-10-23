package com.taskmaster.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taskmaster.model.User;
import com.taskmaster.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
		@Autowired
		UserService us;
		
		@Test
		public void add() {
			User me = new User("+17048130888", "admin");
			us.addUser(me.getPhoneNum(), me.getPassword());
			assertThat(us.validateUser("+17048130888", "admin"));
		}
		
		@Test
		public void edit() {
			us.editUserPassword("+17048130888", "notAdmin");
			assertThat(us.validateUser("+17048130888", "notAdmin"));
		}
		
		@Test
		public void delete() {
			String deletion = us.deleteUserByPhone("+17048130888");
			assertThat(deletion, equalTo("User Deleted"));
		}
}
