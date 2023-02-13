package user.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SubjectUser;
import user.model.vo.User;

public class UserStoreImpl implements UserStore{

	@Override
	public int insertUser(SqlSession session, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectOneByIdCnt(SqlSession session, String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectLogin(SqlSession session, String id, String pw) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(SqlSession session, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectOneById(SqlSession session, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser(SqlSession session, String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findPw(SqlSession session, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePw(SqlSession session, String id, String pwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int plusCodeSubject(SqlSession session, int code, String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int minusCodeSubject(SqlSession session, String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SubjectUser> selectAll(SqlSession session) {
		// TODO Auto-generated method stub
		return null;
	}

}
