package subject.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import subject.model.vo.Subject;

public interface SubjectStore {

	/**
	 * 과목 추가 Store
	 * 
	 * @param conn
	 * @param subject
	 * @return int
	 */
	public int insertSubject(SqlSession session, Subject subject);

	/**
	 * 과목 조회 Store
	 * 
	 * @param conn
	 * @return List<Subject>
	 */
	public List<Subject> selectAll(SqlSession session);

	/**
	 * 과목 삭제 Store
	 * 
	 * @param conn
	 * @param codeNum
	 * @return int
	 */
	public int deleteSubject(SqlSession session, int codeNum);

	/**
	 * 과목 수정 Store
	 * 
	 * @param conn
	 * @param subject
	 * @return int
	 */
	public int updateSubject(SqlSession session, Subject subject);

	/**
	 * 해당 과목 조회 Store
	 * 
	 * @param conn
	 * @param code
	 * @return Subject
	 */
	public Subject selectSubject(SqlSession session, int code);

	/**
	 * 수강신청 인원 더하기 Store
	 * 
	 * @param conn
	 * @param code
	 * @param enrollNum
	 * @return int
	 */
	public int plusSubject(SqlSession session, Subject subject);

	/**
	 * 수강신청 인원 빼기 Store
	 * 
	 * @param conn
	 * @param code
	 * @param enrollNum
	 * @return int
	 */
	public int minusSubject(SqlSession session, Subject subject);

	/**
	 * 수강신청한 과목 조회 Store
	 * 
	 * @param conn
	 * @param id
	 * @return Subject
	 */
	public Subject selectUserSubject(SqlSession session, String id);

}
