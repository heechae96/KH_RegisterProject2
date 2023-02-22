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

import com.hc.register.Elert;
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
	public String login(HttpServletRequest request, HttpServletResponse response, 
			String userId, String userPw, @ModelAttribute User user, Model model) {

		int result = -1;
		result = userService.checkLogin(user);

		if (result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "common/main";
		} else {
			response.setContentType("text/html; charset=UTF-8");
			try {
				Elert elert = new Elert("/user/login", "아이디 또는 비밀번호를 다시 확인해주세요");
				model.addAttribute("elert", elert);
				return "common/alert";
			} catch (Exception e) {
				model.addAttribute("msg", e.getMessage());
			}
			return "redirect:/user/login";
		}

	}
	
	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate(); 
		}
		return "common/main";
	}
	
}
