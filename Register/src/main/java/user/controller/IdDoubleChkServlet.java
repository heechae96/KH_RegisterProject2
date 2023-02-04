package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;

/**
 * Servlet implementation class IdDoubleChkServlet
 */
@WebServlet("/register/idChk")
public class IdDoubleChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IdDoubleChkServlet() {
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
		result = uService.selectOneByIdCnt(id);

		request.setAttribute("id", id);
		request.setAttribute("result", result);

		// 회원가입 화면을 표시한다.
		request.getRequestDispatcher("/WEB-INF/views/user/idDoubleChk.jsp").forward(request, response);

	}

}
