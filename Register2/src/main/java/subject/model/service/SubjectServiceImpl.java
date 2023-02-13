package subject.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import subject.model.store.SubjectStore;
import subject.model.store.SubjectStoreImpl;
import subject.model.vo.Subject;

public class SubjectServiceImpl implements SubjectService {

	private SubjectStore sStore;

	public SubjectServiceImpl() {
		sStore = new SubjectStoreImpl();
	}

	// 커밋은 트랜잭션 처리 부분만 할 것!
	@Override
	public int insertSubject(Subject subject) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = sStore.insertSubject(session, subject);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public List<Subject> selectAll() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Subject> sList = sStore.selectAll(session);
		return sList;
	}

	@Override
	public int deleteSubject(int codeNum) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = sStore.deleteSubject(session, codeNum);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public int updateSubject(Subject subject) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = sStore.updateSubject(session, subject);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public Subject selectSubject(int code) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Subject subject = sStore.selectSubject(session, code);
		return subject;
	}

	@Override
	public int plusSubject(Subject subject) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = sStore.plusSubject(session, subject);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public int minusSubject(Subject subject) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = sStore.minusSubject(session, subject);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public Subject selectUserSubject(String id) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Subject subject = sStore.selectUserSubject(session, id);
		return subject;
	}

}
