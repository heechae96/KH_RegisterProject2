package com.hc.register.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hc.register.Alert;
import com.hc.register.subject.domain.Subject;
import com.hc.register.subject.service.SubjectService;
import com.hc.register.user.domain.User;
import com.hc.register.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SubjectService subjectService;

	// 관리자 전용
	// 이용자 조회
	@RequestMapping("/select")
	public String selectAll(Model model) {
		try {
			List<User> list = userService.selectAll();
			if (list.size() == 0) {
				Alert alert = new Alert("/home", "이용자가 존재하지 않습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			} else {
				model.addAttribute("list", list);
				return "admin/selectUser";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 이용자 삭제
	@RequestMapping("/deleteUser")
	public String deleteUser(String userId, Model model) {
		try {
			int result = -1;
			result = userService.delete(userId);
			if (result > 0) {
				Alert alert = new Alert("/user/select", "이용자 삭제 완료했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			} else {
				Alert alert = new Alert("/user/select", "이용자 삭제 실패했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 이용자 전용
	// 회원가입
	@RequestMapping("/enroll")
	public String enroll() {
		return "user/enroll";
	}

	@RequestMapping(value = "/enroll", method = RequestMethod.POST)
	public String enroll(@ModelAttribute User user, String userId, String userPw, String userName, String userPhoneNo,
			Model model) {
		try {
			int result = -1;
			result = userService.enroll(user);
			if (result > 0) {
				Alert alert = new Alert("/user/login", "회원가입에 성공했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			} else {
				Alert alert = new Alert("/user/enroll", "회원가입에 실패했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 회원가입시 아이디 중복 확인
	@RequestMapping("/idChk")
	public String idChk(String userId, @ModelAttribute User user, Model model) {
		try {
			// user가 null이든 null이 아니든 일단 결과를 보냄
			// 새로 열리는 창에 결과를 반환
			user = userService.selectOneById(userId);
			model.addAttribute("id", userId);
			model.addAttribute("user", user);
			return "user/idDoubleChk";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 회원탈퇴
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req, Model model) {
		try {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("user");

			int userResult = -1;
			int subjectResult = -1;

			if (user != null) {
				String userId = user.getUserId();
				user = userService.selectOneById(userId);
				int subjectCode = user.getSubjectCode();
				if (subjectCode == 0) {
					// 수강 신청 기록이 없기 때문에
					// 회원탈퇴후 세션까지 반환 이후 마무리
					userResult = userService.delete(userId);
					if (userResult > 0) {
						Alert alert = new Alert("/user/logout", "회원탈퇴 성공했습니다");
						model.addAttribute("alert", alert);
						return "common/alert";
					} else {
						Alert alert = new Alert("/user/update", "회원탈퇴 실패했습니다");
						model.addAttribute("alert", alert);
						return "common/alert";
					}
				} else {
					// 수강 신청 기록이 존재하기 때문에
					// 회원탈퇴후 기록 삭제, 세션까지 반환 이후 마무리
					Subject subject = subjectService.select(subjectCode);
					subjectResult = subjectService.minusSubject(subject);

					userResult = userService.delete(userId);
					if (subjectResult > 0 && userResult > 0) {
						Alert alert = new Alert("/user/logout", "회원탈퇴 성공했습니다");
						model.addAttribute("alert", alert);
						return "common/alert";
					} else {
						Alert alert = new Alert("/user/update", "회원탈퇴 실패했습니다");
						model.addAttribute("alert", alert);
						return "common/alert";
					}
				}

			} else {
				Alert alert = new Alert("/user/login", "로그인이 필요합니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}

	}

	// 비밀번호 찾기
	@RequestMapping("/findPw")
	public String findPw() {
		return "user/findPassword";
	}

	@RequestMapping(value = "/findPw", method = RequestMethod.POST)
	public String findPw(@ModelAttribute User user, String userId, String userName, String userPhoneNo, Model model) {
		try {
			int result = -1;
			result = userService.findPw(user);
			if (result > 0) {
				model.addAttribute("user", user);
				return "user/changePassWord";
			} else {
				Alert alert = new Alert("/user/findPw", "해당 정보가 일치하지 않습니다 \\n다시 확인하고 시도해주세요");
				model.addAttribute("alert", alert);
				return "common/alert";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 비밀번호 수정
	@RequestMapping("/updatePw")
	public String updatePw() {
		return "user/changePassWord";
	}

	@RequestMapping(value = "/updatePw", method = RequestMethod.POST)
	public String updatePw(String userId, String userPw, @ModelAttribute User user, Model model) {
		try {
			int result = -1;
			result = userService.updatePw(user);
			if (result > 0) {
				Alert alert = new Alert("/user/login", "비밀번호 수정에 성공했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			} else {
				Alert alert = new Alert("/user/updatePw", "비밀번호 수정에 실패했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 로그인
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, String userId, String userPw,
			@ModelAttribute User user, Model model) {
		try {
			int result = -1;
			result = userService.checkLogin(user);

			if (result > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				return "common/main";
			} else {
				Alert alert = new Alert("/user/login", "아이디 또는 비밀번호를 다시 확인해주세요");
				model.addAttribute("alert", alert);
				return "common/alert";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		try {
			HttpSession session = request.getSession();
			if (session != null) {
				session.invalidate();
				return "common/main";
			} else {
				return "common/main";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 정보변경
	@RequestMapping("/update")
	public String update(HttpSession session, Model model) {
		try {
			User user = (User) session.getAttribute("user");
			if (user != null) {
				String userId = user.getUserId();
				user = userService.selectOneById(userId);
				model.addAttribute("user", user);
				return "user/changeInfo";
			} else {
				Alert alert = new Alert("/user/login", "로그인이 필요합니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(String userId, String userPw, String userName, String userPhoneNo, @ModelAttribute User user,
			Model model) {
		try {
			int result = -1;
			result = userService.updateUser(user);
			if (result > 0) {
				Alert alert = new Alert("/user/update", "정보수정에 성공했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			} else {
				Alert alert = new Alert("/user/update", "정보수정에 실패했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 수강 신청
	@RequestMapping("/selectSubject")
	public String selectSubject(Model model, HttpServletRequest req) {
		try {
			List<Subject> list = new ArrayList<Subject>();
			list = subjectService.selectAll();
			model.addAttribute("list", list);
			if (list.size() == 0) {
				Alert alert = new Alert("/home", "개설된 과목이 존재하지 않습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			} else {
				HttpSession session = req.getSession();
				User user = (User) session.getAttribute("user");
				user = userService.selectOneById(user.getUserId());
				if (user.getSubjectCode() == 0) {
					return "user/selectSubject";
				} else {
					Alert alert = new Alert("/user/updateSubject", "수강신청을 이미 완료했습니다");
					model.addAttribute("alert", alert);
					return "common/alert";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	@RequestMapping(value = "/selectSubject", method = RequestMethod.POST)
	public String selectSubject(Model model, String userId, int subjectCode, @ModelAttribute User user) {
		try {
			int userResult = -1;

			Subject subject = subjectService.select(subjectCode);
			int subjectResult = -1;
			int enrollNo = subject.getEnrollNo();
			int maxNo = subject.getMaxNo();

			// 추가로 신청을 받을수 있는 경우
			if (enrollNo < maxNo) {
				subjectResult = subjectService.plusSubject(subject);
				userResult = userService.addSubjectCode(user);

				if (userResult > 0 && subjectResult > 0) {
					Alert alert = new Alert("/user/updateSubject", "수강신청에 성공했습니다");
					model.addAttribute("alert", alert);
					return "common/alert";
				} else {
					Alert alert = new Alert("/user/selectSubject", "수강신청에 실패했습니다");
					model.addAttribute("alert", alert);
					return "common/alert";
				}
			} else { // 추가로 신청을 받지 못하는 경우
				Alert alert = new Alert("/user/selectSubject", "해당과목은 인원초과로 신청 불가합니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	// 수강 정정(삭제)
	@RequestMapping("/updateSubject")
	public String updateSubject(HttpServletRequest req, Model model) {
		try {
			List<Subject> list = new ArrayList<Subject>();
			list = subjectService.selectAll();
			model.addAttribute("list", list);

			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("user");
			user = userService.selectOneById(user.getUserId());

			Subject subject = subjectService.select(user.getSubjectCode());
			model.addAttribute("subject", subject);

			if (subject != null) {
				return "user/subjectChkUpdate";
			} else {
				Alert alert = new Alert("/user/selectSubject", "수강신청을 먼저 진행해주세요");
				model.addAttribute("alert", alert);
				return "common/alert";
			}

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}

	@RequestMapping(value = "/updateSubject", method = RequestMethod.POST)
	public String updateSubject(HttpServletRequest req, String userId, int subjectCode, Model model) {
		try {
			User user = userService.selectOneById(userId);
			Subject subject = subjectService.select(subjectCode);

			int subjectResult = -1;
			subjectResult = subjectService.minusSubject(subject);

			int userResult = -1;
			userResult = userService.removeSubjectCode(user);

			if (subjectResult > 0 && userResult > 0) {
				Alert alert = new Alert("/user/selectSubject", "해당과목 삭제에 성공했습니다");
				model.addAttribute("alert", alert);
				return "common/alert";
			} else {
				Alert alert = new Alert("/user/updateSubject", "해당과목 삭제에 실패했습니다");
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
