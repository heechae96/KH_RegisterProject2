package com.hc.register.user.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.register.user.domain.User;
import com.hc.register.user.service.UserService;
import com.hc.register.user.store.UserStore;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserStore userStore;
	
	@Override
	public int checkLogin(User user) {
		int result = userStore.checkLogin(user);
		return result;
	}

}