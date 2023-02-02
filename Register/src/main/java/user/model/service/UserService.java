package user.model.service;

import java.sql.Connection;
import java.util.HashSet;

import common.JDBCTemplate;
import user.model.dao.UserDAO;
import user.model.vo.User;

public class UserService {

	private UserDAO userDao;

	public UserService() {
		userDao = new UserDAO();
	}

	/**
	 * 회원가입 Service
	 * 
	 * @param user
	 * @return result
	 */
	public int insertUser(User user) {
		Connection conn = JDBCTemplate.getConnection();
		int result = -1;
		result = userDao.insertUser(conn, user);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	/**
	 * 아이디 중복 체크 Service
	 * 
	 * @param userid
	 * @return
	 */
	public int selectOneByIdCnt(String id) {
		Connection conn = JDBCTemplate.getConnection();
		int result = -1;
		result = userDao.selectOneByIdCnt(conn, id);
		return result;
	}

	/**
	 * 로그인 Service
	 * 
	 * @param id
	 * @param pw
	 * @return result
	 */
	public int selectLogin(String id, String pw) {
		Connection conn = JDBCTemplate.getConnection();
		int result = -1;
		result = userDao.selectLogin(conn, id, pw);
		return result;
	}

	/**
	 * 정보변경 Service
	 * 
	 * @param user
	 * @return result
	 */
	public int updateUser(User user) {
		Connection conn = JDBCTemplate.getConnection();
		int result = -1;
		result = userDao.updateUser(conn, user);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	/**
	 * 정보조회 Service
	 * 
	 * @param id
	 * @return user
	 */
	public User selectOneById(String id) {
		Connection conn = JDBCTemplate.getConnection();
		User user = null;
		user = userDao.selectOneById(conn, id);
		return user;
	}

	/**
	 * 회원탈퇴 Service
	 * 
	 * @param id
	 * @return result
	 */
	public int deleteUser(String id) {
		Connection conn = JDBCTemplate.getConnection();
		int result = -1;
		result = userDao.deleteUser(conn, id);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	/**
	 * 비밀번호 찾기 Service
	 * 
	 * @param user
	 * @return result
	 */
	public int findPw(User user) {
		Connection conn = JDBCTemplate.getConnection();
		int result = -1;
		result = userDao.findPw(conn, user);
		return result;
	}

	/**
	 * 비밀번호 변경 Service
	 * 
	 * @param id
	 * @return
	 */
	public int updatePw(String id, String pwd) {
		Connection conn = JDBCTemplate.getConnection();
		int result = -1;
		result = userDao.updatePw(conn, id, pwd);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

}
