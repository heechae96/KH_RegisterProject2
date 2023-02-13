package subject.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import subject.model.vo.Subject;

public class SubjectStoreImpl implements SubjectStore{

	@Override
	public int insertSubject(SqlSession session, Subject subject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Subject> selectAll(SqlSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteSubject(SqlSession session, int codeNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSubject(SqlSession session, Subject subject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Subject selectSubject(SqlSession session, int code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int plusSubject(SqlSession session, int code, Subject subject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int minusSubject(SqlSession session, int code, Subject subject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Subject selectUserSubject(SqlSession session, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
