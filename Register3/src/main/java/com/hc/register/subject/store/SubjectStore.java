package com.hc.register.subject.store;

import java.util.List;

import com.hc.register.subject.domain.Subject;

public interface SubjectStore {

	int insert(Subject subject);

	List<Subject> selectAll();

	int delete(int subjectCode);

	Subject select(int subjectCode);

	int update(Subject subject);

	int plusSubject(Subject subject);

	int minusSubject(Subject subject);

}
