package user.model.service;

import java.util.List;

import common.SubjectUser;
import user.model.vo.User;

public class UserServiceImpl implements UserService{

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectOneByIdCnt(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectLogin(String id, String pw) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectOneById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findPw(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePw(String id, String pwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int plusCodeSubject(int code, String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int minusCodeSubject(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SubjectUser> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
