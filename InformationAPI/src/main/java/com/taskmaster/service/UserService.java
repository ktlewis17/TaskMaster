package com.taskmaster.service;

public interface UserService {

	boolean validateUser(String pn, String pw);
	
	String deleteUserByPhone(String pn);
	
	String addUser(String pn, String pw);
	
	String editUserPassword(String pn, String newPw);

}