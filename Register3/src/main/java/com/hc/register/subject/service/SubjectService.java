package com.hc.register.subject.service;

import java.util.List;

import com.hc.register.subject.domain.Subject;

public interface SubjectService {

	int insert(Subject subject);

	List<Subject> selectAll();

	int delete(int subjectCode);

}
