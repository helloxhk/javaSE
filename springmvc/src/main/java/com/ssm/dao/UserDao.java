package com.ssm.dao;

import org.springframework.stereotype.Repository;

import com.ssm.domain.User;

@Repository
public interface UserDao {
	
	User get(int id);
	
}
