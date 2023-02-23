package com.hc.register.user.service;

import com.hc.register.user.domain.User;

public interface UserService {

	public int checkLogin(User user);

	public User selectOneById(String userId);

	public int updateUser(User user);

}
