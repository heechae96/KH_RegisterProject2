package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/register/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		UserService uService = new UserService();
		int result = -1;
		result = uService.selectLogin(id, pw);

		if (result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			response.sendRedirect("/index.jsp");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/register/login";
			writer.println("<script>"); 
			writer.println("alert('아이디 또는 비밀번호를 다시 확인해주세요')"); 
			writer.println("location.href='"+pageURL+"'"); 
			writer.println("</script>"); 
			writer.close();
		}

	}

}
