package subject.model.service;

import java.util.List;

import subject.model.vo.Subject;

public interface SubjectService {

	/**
	 * 과목 추가 Service
	 * 
	 * @param subject
	 * @return result
	 */
	public int insertSubject(Subject subject);

	/**
	 * 과목 조회 Service
	 * 
	 * @return list
	 */
	public List<Subject> selectAll();

	/**
	 * 과목 삭제 Service
	 * 
	 * @param codeNum
	 * @return result
	 */
	public int deleteSubject(int codeNum);

	/**
	 * 과목 수정 Service
	 * 
	 * @param subject
	 * @return result
	 */
	public int updateSubject(Subject subject);

	/**
	 * 해당 과목 조회 Service
	 * 
	 * @param code
	 * @return subject
	 */
	public Subject selectSubject(int code);
	
	/**
	 * 수강신청 더하기 Service
	 * 
	 * @param code
	 * @param enrollNum
	 * @return result
	 */
	public int plusSubject(int code, Subject subject);
	
	/**
	 * 수강신청 빼기 Service
	 * 
	 * @param code
	 * @param enrollNum
	 * @return result
	 */
	public int minusSubject(int code, Subject subject);

	/**
	 * 수강신청한 과목 조회 Service
	 * @param id
	 * @return subject
	 */
	public Subject selectUserSubject(String id);

}
