package user.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SubjectUser;
import user.model.vo.User;

public interface UserStore {
	/**
	 * 회원가입 Store
	 * 
	 * @param conn
	 * @param user
	 * @return int
	 */
	public int insertUser(SqlSession session, User user);

	/**
	 * 중복되는 아이디 확인 Store
	 * 
	 * @param conn
	 * @param id
	 * @return int
	 */
	public int selectOneByIdCnt(SqlSession session, String id);

	/**
	 * 로그인 Store
	 * 
	 * @param conn
	 * @param id
	 * @param pw
	 * @return int
	 */
	public int selectLogin(SqlSession session, String id, String pw);

	/**
	 * 정보변경 Store
	 * 
	 * @param conn
	 * @param user
	 * @return int
	 */
	public int updateUser(SqlSession session, User user);

	/**
	 * 아이디로 정보조회 Store
	 * 
	 * @param id
	 * @return User
	 */
	public User selectOneById(SqlSession session, String id);

	/**
	 * 아이디로 회원탈퇴 Store
	 * 
	 * @param conn
	 * @param id
	 * @return int
	 */
	public int deleteUser(SqlSession session, String id);

	/**
	 * 비밀번호 찾기 Store
	 * 
	 * @param conn
	 * @param user
	 * @return int
	 */
	public int findPw(SqlSession session, User user);

	/**
	 * 비밀번호 변경 Store
	 * 
	 * @param conn
	 * @param id
	 * @return int
	 */
	public int updatePw(SqlSession session, String id, String pwd);

	/**
	 * 수강신청 더하기 Store
	 * 
	 * @param conn
	 * @param code
	 * @return int
	 */
	public int plusCodeSubject(SqlSession session, int code, String id);

	/**
	 * 수강신청 빼기 Store
	 * 
	 * @param conn
	 * @param code
	 * @return int
	 */
	public int minusCodeSubject(SqlSession session, String id);

	/**
	 * 모든 학생 조회 Store
	 * 
	 * @param conn
	 * @return List<SubjectUser>
	 */
	public List<SubjectUser> selectAll(SqlSession session);

}
