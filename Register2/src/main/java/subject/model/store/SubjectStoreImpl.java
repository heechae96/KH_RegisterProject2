package subject.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import subject.model.vo.Subject;

public class SubjectStoreImpl implements SubjectStore{

	// session.메소드()의 파라미터는 반드시 1개 또는 2개만 가능 
	@Override
	public int insertSubject(SqlSession session, Subject subject) {
		int result = session.insert("subjectMapper.insertSubject", subject);
		return result;
	}

	@Override
	public List<Subject> selectAll(SqlSession session) {
		List<Subject> sList = session.selectList("subjectMapper.selectAll");
		return sList;
	}

	@Override
	public int deleteSubject(SqlSession session, int codeNum) {
		int result = session.delete("subjectMapper.deleteSubject", codeNum);
		return result;
	}

	@Override
	public int updateSubject(SqlSession session, Subject subject) {
		int result = session.update("subjectMapper.updateSubject", subject);
		return result;
	}

	@Override
	public Subject selectSubject(SqlSession session, int code) {
		Subject subject = session.selectOne("subjectMapper.selectSubject", code);
		return subject;
	}

	@Override
	public int plusSubject(SqlSession session, Subject subject) {
		int result = session.update("subjectMapper.plusSubject", subject);
		return result;
	}

	@Override
	public int minusSubject(SqlSession session, Subject subject) {
		int result = session.update("subjectMapper.minusSubject", subject);
		return result;
	}

	// 조인문 연산자가 필요했음
	@Override
	public Subject selectUserSubject(SqlSession session, String id) {
		Subject subject = session.selectOne("subjectMapper.selectUserSubject", id);
		return subject;
	}

}
