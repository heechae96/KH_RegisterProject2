package user.model.service;

import java.util.List;

import common.SubjectUser;
import user.model.vo.User;

public interface UserService {

	/**
	 * 회원가입 Service
	 * 
	 * @param user
	 * @return result
	 */
	public int insertUser(User user);

	/**
	 * 아이디 중복 체크 Service
	 * 
	 * @param userid
	 * @return
	 */
	public int selectOneByIdCnt(String id);

	/**
	 * 로그인 Service
	 * 
	 * @param id
	 * @param pw
	 * @return result
	 */
	public int selectLogin(String id, String pw);

	/**
	 * 정보변경 Service
	 * 
	 * @param user
	 * @return result
	 */
	public int updateUser(User user);

	/**
	 * 정보조회 Service
	 * 
	 * @param id
	 * @return user
	 */
	public User selectOneById(String id);
	
	/**
	 * 회원탈퇴 Service
	 * 
	 * @param id
	 * @return result
	 */
	public int deleteUser(String id);
	
	/**
	 * 비밀번호 찾기 Service
	 * 
	 * @param user
	 * @return result
	 */
	public int findPw(User user);

	/**
	 * 비밀번호 변경 Service
	 * 
	 * @param id
	 * @return
	 */
	public int updatePw(String id, String pwd);

	/**
	 * 수강신청 더하기 Service
	 * 
	 * @param id
	 * @param code
	 * @return result
	 */
	public int plusCodeSubject(int code, String id);
	
	/**
	 * 수강신청 빼기 Service
	 * 
	 * @param id
	 * @param code
	 * @return result
	 */
	public int minusCodeSubject(String id);

	/**
	 * 모든 학생 조회 Service
	 * 
	 * @return list
	 */
	public List<SubjectUser> selectAll();
	
}
