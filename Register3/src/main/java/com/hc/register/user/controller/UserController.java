package com.hc.register.user.controller;

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
import com.hc.register.user.domain.User;
import com.hc.register.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

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
				Alert alert = new Alert("/user/login", "로그인이 필요한 작업입니다");
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

}
