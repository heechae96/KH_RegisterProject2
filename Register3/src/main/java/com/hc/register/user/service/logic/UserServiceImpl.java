package com.hc.register.user.service.logic;

import java.util.List;

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

	@Override
	public User selectOneById(String userId) {
		User user = userStore.selectOneById(userId);
		return user;
	}

	@Override
	public int updateUser(User user) {
		int result = userStore.updateUser(user);
		return result;
	}

	@Override
	public int findPw(User user) {
		int result = userStore.findPw(user);
		return result;
	}

	@Override
	public int updatePw(User user) {
		int result = userStore.updatePw(user);
		return result;
	}

	@Override
	public int enroll(User user) {
		int result = userStore.enroll(user);
		return result;
	}

	@Override
	public List<User> selectAll() {
		List<User> list = userStore.selectAll();
		return list;
	}

	@Override
	public int addSubjectCode(User user) {
		int result = userStore.addSubjectCode(user);
		return result;
	}

	@Override
	public int removeSubjectCode(User user) {
		int result = userStore.removeSubjectCode(user);
		return result;
	}

	@Override
	public int delete(String userId) {
		int result = userStore.delete(userId);
		return result;
	}

}
