package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/register/userInfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		UserService uService = new UserService();
		User user = uService.selectOneById(id);
		if (user != null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/views/user/infoChange.jsp").forward(request, response);
		} else {
			// 로그인 페이지처럼 alert창을 띄울수 없음
			// 로그인 페이지쪽은 doPost였음
			// id가 없을때 에러페이지로 이동
			
			request.setAttribute("title", "마이페이지로 가기 실패");
			request.setAttribute("msg", "해당하는 아이디가 존재하지 않습니다");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}

	}

}
