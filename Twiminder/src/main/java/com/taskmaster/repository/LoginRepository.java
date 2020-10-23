package com.taskmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmaster.model.Login;
//import com.taskmaster.model.User;

public interface LoginRepository extends JpaRepository<Login, String> {

}
