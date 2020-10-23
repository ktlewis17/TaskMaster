package com.taskmaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taskmaster.model.Alert;

public interface AlertRepository extends JpaRepository<Alert, Integer>{
	public List<Alert> findAllByPhone(String phone);
	public List<Alert> findAllByDatetime(String datetime);
}
