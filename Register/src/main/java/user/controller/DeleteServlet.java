package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/register/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
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
		int result = -1;
		result = uService.deleteUser(id);
		if (result > 0) {
			// 세션을 종료하는게 로그아웃쪽에서도 사용되고 있다
			// 내부적으로 세션 반환
			response.sendRedirect("/register/logout");
		} else {
			request.setAttribute("title", "회원 탈퇴 실패");
			request.setAttribute("msg", "회원탈퇴가 완료되지 않았습니다");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}

	}

}
