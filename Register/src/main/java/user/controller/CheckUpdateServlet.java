package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import subject.model.service.SubjectService;
import subject.model.vo.Subject;
import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class CheckUpdateServlet
 */
@WebServlet("/register/chkUpdate")
public class CheckUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService uService = new UserService();
		String id = request.getParameter("id");
		User user = uService.selectOneById(id);

		if (user.getSubjectCode() != 0) {
			// 개설 과목
			SubjectService sService = new SubjectService();
			List<Subject> list = new ArrayList<Subject>();
			list = sService.selectAll();
			request.setAttribute("list", list);

			// 신청 과목
			Subject subject = sService.selectUserSubject(id);
			request.setAttribute("subject", subject);
			
			// 화면에 뿌리기
			request.getRequestDispatcher("/WEB-INF/views/user/chkUpdate.jsp").forward(request, response);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/register/select";
			writer.println("<script>");
			writer.println("alert('수강 신청을 먼저 해주세요')");
			writer.println("location.href='" + pageURL + "'");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
