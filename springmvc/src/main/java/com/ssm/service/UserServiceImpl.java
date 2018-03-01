package com.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.dao.UserDao;
import org.springframework.stereotype.Service;

import com.ssm.domain.User;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUser(int id) {
		return userDao.get(id);
	}

}
