package subject.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import subject.model.dao.SubjectDAO;
import subject.model.vo.Subject;

public class SubjectService {

	private SubjectDAO subjectDao;

	public SubjectService() {
		subjectDao = new SubjectDAO();
	}

	/**
	 * 과목 추가 Service
	 * 
	 * @param subject
	 * @return result
	 */
	public int insertSubject(Subject subject) {
		Connection conn = JDBCTemplate.getConnection();
		int result = -1;
		result = subjectDao.insertSubject(conn, subject);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	/**
	 * 과목 조회 Service
	 * 
	 * @return list
	 */
	public List<Subject> selectAll() {
		Connection conn = JDBCTemplate.getConnection();
		List<Subject> list = new ArrayList<Subject>();
		list = subjectDao.selectAll(conn);
		return list;
	}

	/**
	 * 과목 삭제 Service
	 * 
	 * @param codeNum
	 * @return result
	 */
	public int deleteSubject(int codeNum) {
		Connection conn = JDBCTemplate.getConnection();
		int result = -1;
		result = subjectDao.deleteSubject(conn, codeNum);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	/**
	 * 과목 수정 Service
	 * 
	 * @param subject
	 * @return result
	 */
	public int updateSubject(Subject subject) {
		Connection conn = JDBCTemplate.getConnection();
		int result = -1;
		result = subjectDao.updateSubject(conn, subject);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	/**
	 * 해당 과목 조회 Service
	 * 
	 * @param code
	 * @return subject
	 */
	public Subject selectSubject(int code) {
		Connection conn = JDBCTemplate.getConnection();
		Subject subject = null;
		subject = subjectDao.selectSubject(conn, code);
		return subject;
	}

	/**
	 * 수강신청 더하기 Service
	 * 
	 * @param code
	 * @param enrollNum
	 * @return result
	 */
	public int plusSubject(int code, Subject subject) {
		Connection conn = JDBCTemplate.getConnection();
		int result = -1;
		result = subjectDao.plusSubject(conn, code, subject);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;

	}
	
	/**
	 * 수강신청 빼기 Service
	 * 
	 * @param code
	 * @param enrollNum
	 * @return result
	 */
	public int minusSubject(int code, Subject subject) {
		Connection conn = JDBCTemplate.getConnection();
		int result = -1;
		result = subjectDao.minusSubject(conn, code, subject);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;

	}

	/**
	 * 수강신청한 과목 조회 Service
	 * @param id
	 * @return subject
	 */
	public Subject selectUserSubject(String id) {
		Connection conn = JDBCTemplate.getConnection();
		Subject subject = null;
		subject = subjectDao.selectUserSubject(conn, id);
		return subject;
	}

}
