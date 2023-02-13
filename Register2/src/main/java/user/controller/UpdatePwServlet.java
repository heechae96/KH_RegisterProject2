package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import user.model.service.UserServiceImpl;
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
		UserService uService = new UserServiceImpl();
		User user = uService.selectOneById(id);
		if (user != null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/views/user/changePassWord.jsp").forward(request, response);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/register/findPw";
			writer.println("<script>"); 
			writer.println("alert('해당 아이디가 존재하지 않습니다.')"); 
			writer.println("location.href='"+pageURL+"'"); 
			writer.println("</script>"); 
			writer.close();
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
		UserService uService = new UserServiceImpl();

		int result = -1;
		result = uService.updatePw(id, pwd);
		if (result > 0) {
			// 로그인 페이지로
			response.sendRedirect("/register/login");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/";
			writer.println("<script>"); 
			writer.println("alert('비밀번호 변경에 실패하였습니다')"); 
			writer.println("location.href='"+pageURL+"'"); 
			writer.println("</script>"); 
			writer.close();
		}

	}

}
