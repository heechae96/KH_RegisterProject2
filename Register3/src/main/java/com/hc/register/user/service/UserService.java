package com.hc.register.user.service;

import java.util.List;

import com.hc.register.user.domain.User;

public interface UserService {

	public int checkLogin(User user);

	public User selectOneById(String userId);

	public int updateUser(User user);

	public int findPw(User user);

	public int updatePw(User user);

	public int enroll(User user);

	public List<User> selectAll();

}
