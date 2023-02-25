package com.hc.register.subject.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.register.subject.domain.Subject;
import com.hc.register.subject.service.SubjectService;
import com.hc.register.subject.store.SubjectStore;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectStore subjectStore;
	
	@Override
	public int insert(Subject subject) {
		int result = subjectStore.insert(subject);
		return result;
	}

	@Override
	public List<Subject> selectAll() {
		List<Subject> list = subjectStore.selectAll();
		return list;
	}

	@Override
	public int delete(int subjectCode) {
		int result = subjectStore.delete(subjectCode);
		return result;
	}

}
