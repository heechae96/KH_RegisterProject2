package com.hc.register.user.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hc.register.user.domain.User;
import com.hc.register.user.service.UserService;

@Controller
public class UserController {

//	@Autowired
//	private SubjectService subjectService;

	@Autowired
	private UserService userService;

	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		User user = new User(id, pw);

		int result = -1;
		result = userService.checkLogin(user);

		if (result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "common/main";
		} else {
			response.setContentType("text/html; charset=UTF-8");
			try {
				PrintWriter writer = response.getWriter();
				String pageURL = "/register/login";
				writer.println("<script>");
				writer.println("alert('아이디 또는 비밀번호를 다시 확인해주세요')");
				writer.println("location.href='" + pageURL + "'");
				writer.println("</script>");
				writer.close();
			} catch (Exception e) {
				model.addAttribute("msg", e.getMessage());
			}
			return "redirect:/login";
		}

	}
	
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate(); 
		}
		return "common/main";
	}
}
