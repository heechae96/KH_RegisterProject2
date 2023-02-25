package com.hc.register.user.controller;

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
import com.hc.register.user.domain.User;
import com.hc.register.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

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
	@RequestMapping("idChk")
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
	@RequestMapping("updatePw")
	public String updatePw() {
		return "user/changePassWord";
	}

	@RequestMapping(value = "updatePw", method = RequestMethod.POST)
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
	public String modify(HttpSession session, Model model) {
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
	public String modify(String userId, String userPw, String userName, String userPhoneNo, @ModelAttribute User user,
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

	// 관리자 전용
	
	// 이용자 조회
	@RequestMapping("select")
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
}
