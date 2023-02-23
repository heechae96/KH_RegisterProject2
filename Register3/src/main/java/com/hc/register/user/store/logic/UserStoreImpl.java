package com.hc.register.user.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hc.register.user.domain.User;
import com.hc.register.user.store.UserStore;

@Repository
public class UserStoreImpl implements UserStore{

	@Autowired
	private SqlSession session;
	
	@Override
	public int checkLogin(User user) {
		int result = session.selectOne("userMapper.checkLogin", user);
		return result;
	}

	@Override
	public User selectOneById(String userId) {
		User user = session.selectOne("userMapper.selectOneById", userId);
		return user;
	}

	@Override
	public int updateUser(User user) {
		int result = session.update("userMapper.updateUser", user);
		return result;
	}
}
