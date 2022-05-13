package com.fastech.springjunittest.repository;

import com.fastech.springjunittest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
