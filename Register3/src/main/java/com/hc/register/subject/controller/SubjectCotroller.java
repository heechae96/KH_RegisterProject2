package com.hc.register.subject.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hc.register.Alert;
import com.hc.register.subject.domain.Subject;
import com.hc.register.subject.service.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectCotroller {

	@Autowired
	private SubjectService subjectService;

	// 과목 추가
	@RequestMapping("insert")
	public String insert() {
		return "admin/addSubject";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute Subject subject, String subjectName, String name, int maxNo, Date startDate,
			Date endDate, Model model) {
		try {
			int result = -1;
			result = subjectService.insert(subject);
			if (result > 0) {
				Alert alert = new Alert("/subject/insert", "과목추가에 성공했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			} else {
				Alert alert = new Alert("/subject/insert", "과목추가에 실패했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 과목 조회
	@RequestMapping("select")
	public String selectAll(Model model) {
		try {
			List<Subject> list = subjectService.selectAll();
			if (list.size() == 0) {
				Alert alert = new Alert("/home", "개설한 과목이 존재하지 않습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			} else {
				model.addAttribute("list", list);
				return "admin/selectSubject";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 과목 삭제
	@RequestMapping("delete")
	public String delete(int subjectCode, Model model) {
		try {
			int result = -1;
			result = subjectService.delete(subjectCode);
			if (result > 0) {
				Alert alert = new Alert("/subject/select", "과목삭제에 성공했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			} else {
				Alert alert = new Alert("/subject/select", "과목삭제에 실패했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 과목 수정
	@RequestMapping("update")
	public String update(int subjectCode, Model model) {
		try {
			Subject subject = subjectService.select(subjectCode);
			if (subject != null) {
				model.addAttribute("subject", subject);
				return "admin/modifySubject";
			} else {
				Alert alert = new Alert("/subject/select", "해당 과목이 존재하지 않습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute Subject subject, String subjectName, String name, int maxNo, Date startDate,
			Date endDate, int subjectCode, Model model) {
		try {
			int result = -1;
			result = subjectService.update(subject);
			if (result > 0) {
				Alert alert = new Alert("/subject/select", "과목수정에 성공했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			} else {
				Alert alert = new Alert("/subject/update", "과목수정에 실패했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

}