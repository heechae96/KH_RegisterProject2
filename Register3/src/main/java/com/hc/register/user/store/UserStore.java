package com.hc.register.user.store;

import com.hc.register.user.domain.User;

public interface UserStore {

	public int checkLogin(User user);

	public User selectOneById(String userId);

	public int updateUser(User user);

	public int findPw(User user);

	public int updatePw(User user);

	public int enroll(User user);

}
