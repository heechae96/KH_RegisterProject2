package user.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import user.model.vo.User;

public class UserStoreImpl implements UserStore{

	// session.메소드()의 파라미터는 반드시 1개 또는 2개만 가능
	@Override
	public int insertUser(SqlSession session, User user) {
		int result = session.insert("userMapper.insertUser", user);
		return result;
	}

	@Override
	public int selectOneByIdCnt(SqlSession session, String id) {
		int result = session.selectOne("userMapper.selectOneByIdCnt", id);
		return result;
	}

	@Override
	public int selectLogin(SqlSession session, User user) {
		int result = session.selectOne("userMapper.selectLogin", user);
		return result;
	}

	@Override
	public int updateUser(SqlSession session, User user) {
		int result = session.update("userMapper.updateUser", user);
		return result;
	}

	@Override
	public User selectOneById(SqlSession session, String id) {
		User user = session.selectOne("userMapper.selectOneById", id);
		return user;
	}

	@Override
	public int deleteUser(SqlSession session, String id) {
		int result = session.delete("userMapper.deleteUser", id);
		return result;
	}

	@Override
	public int findPw(SqlSession session, User user) {
		int result = session.selectOne("userMapper.findPw", user);
		return result;
	}

	@Override
	public int updatePw(SqlSession session, User user) {
		int result = session.update("userMapper.updatePw", user);
		return result;
	}

	@Override
	public int plusCodeSubject(SqlSession session, User user) {
		int result = session.update("userMapper.plusCodeSubject", user);
		return result;
	}

	@Override
	public int minusCodeSubject(SqlSession session, String id) {
		int result = session.update("userMapper.minusCodeSubject", id);
		return result;
	}

	// 조인문 연산자가 필요했음
	@Override
	public List<User> selectAll(SqlSession session) {
		List<User> suList = session.selectList("userMapper.selectAll");
		return suList;
	}

}
