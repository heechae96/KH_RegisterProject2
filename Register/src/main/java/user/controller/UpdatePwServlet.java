package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class UpdatePwServlet
 */
@WebServlet("/register/updatePw")
public class UpdatePwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePwServlet() {
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
			request.getRequestDispatcher("/WEB-INF/views/user/changePassWord.jsp").forward(request, response);
		} else {
			// 임의로 잘못된 쿼리스트링 값을 넘겨받은 경우..
			// 비밀번호 찾기 페이지에서 팝업창으로 유효성이 검사된 상태
			request.setAttribute("title", "비밀번호 찾기 실패");
			request.setAttribute("msg", "해당하는 정보가 존재하지 않습니다");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		UserService uService = new UserService();

		int result = -1;
		result = uService.updatePw(id, pwd);
		if (result > 0) {
			// 로그인 페이지로
			response.sendRedirect("/register/login");
		} else {
			request.setAttribute("title", "비밀번호 변경 실패");
			request.setAttribute("msg", "비밀번호 변경이 완료되지 않았습니다");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}

	}

}
