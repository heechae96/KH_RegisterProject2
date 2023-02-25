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
	
}
