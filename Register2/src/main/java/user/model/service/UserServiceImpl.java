package user.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import user.model.store.UserStore;
import user.model.store.UserStoreImpl;
import user.model.vo.User;

public class UserServiceImpl implements UserService {

	private UserStore uStore;

	public UserServiceImpl() {
		uStore = new UserStoreImpl();
	}

	// 커밋은 트랜잭션 처리 부분만 할 것!
	@Override
	public int insertUser(User user) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = uStore.insertUser(session, user);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public int selectOneByIdCnt(String id) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = uStore.selectOneByIdCnt(session, id);
		return result;
	}

	@Override
	public int selectLogin(User user) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = uStore.selectLogin(session, user);
		return result;
	}

	@Override
	public int updateUser(User user) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = uStore.updateUser(session, user);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public User selectOneById(String id) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		User user = uStore.selectOneById(session, id);
		return user;
	}

	@Override
	public int deleteUser(String id) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = uStore.deleteUser(session, id);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public int findPw(User user) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = uStore.findPw(session, user);
		return result;
	}

	@Override
	public int updatePw(User user) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = uStore.updatePw(session, user);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public int plusCodeSubject(User user) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = uStore.plusCodeSubject(session, user);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public int minusCodeSubject(String id) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = uStore.minusCodeSubject(session, id);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public List<User> selectAll() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<User> suList = uStore.selectAll(session);
		return suList;
	}

}
