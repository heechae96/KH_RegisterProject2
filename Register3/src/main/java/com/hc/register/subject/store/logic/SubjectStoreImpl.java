package com.hc.register.subject.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hc.register.subject.domain.Subject;
import com.hc.register.subject.store.SubjectStore;

@Repository
public class SubjectStoreImpl implements SubjectStore{

	@Autowired
	private SqlSession session;

	@Override
	public int insert(Subject subject) {
		int result = session.insert("subjectMapper.insert", subject);
		return result;
	}

	@Override
	public List<Subject> selectAll() {
		List<Subject> list = session.selectList("subjectMapper.selectAll");
		return list;
	}

	@Override
	public int delete(int subjectCode) {
		int result = session.delete("subjectMapper.delete", subjectCode);
		return result;
	}

	@Override
	public Subject select(int subjectCode) {
		Subject subject = session.selectOne("subjectMapper.select", subjectCode);
		return subject;
	}

	@Override
	public int update(Subject subject) {
		int result = session.update("subjectMapper.update", subject);
		return result;
	}

	@Override
	public int plusSubject(Subject subject) {
		int result = session.update("subjectMapper.plusSubject", subject);
		return result;
	}

	@Override
	public int minusSubject(Subject subject) {
		int result = session.update("subjectMapper.minusSubject", subject);
		return result;
	}
	
}
