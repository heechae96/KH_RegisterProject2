package com.hc.register.user.store.logic;

import java.util.List;

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

	@Override
	public int findPw(User user) {
		int result = session.selectOne("userMapper.findPw", user);
		return result;
	}

	@Override
	public int updatePw(User user) {
		int result = session.update("userMapper.updatePw", user);
		return result;
	}

	@Override
	public int enroll(User user) {
		int result = session.insert("userMapper.enroll", user);
		return result;
	}

	@Override
	public List<User> selectAll() {
		List<User> list = session.selectList("userMapper.selectAll");
		return list;
	}

}
