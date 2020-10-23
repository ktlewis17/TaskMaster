package com.taskmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taskmaster.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
