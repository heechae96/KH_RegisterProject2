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

}
