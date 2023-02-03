package subject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import subject.model.service.SubjectService;
import subject.model.vo.Subject;

/**
 * Servlet implementation class UpdateSubServlet
 */
@WebServlet("/admin/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int code = Integer.parseInt(request.getParameter("code"));	// 쿼리스트링값
		SubjectService sService = new SubjectService();
		Subject subject = null;
		subject = sService.selectSubject(code);
		request.setAttribute("subject", subject);
		System.out.println("테스트: " + subject);
		if (subject == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/admin/select";
			writer.println("<script>");
			writer.println("alert('해당 과목이 존재하지 않아 수정이 불가능합니다.')");
			writer.println("location.href='" + pageURL + "'");
			writer.println("</script>");
			writer.close();
		} else {
			request.getRequestDispatcher("/WEB-INF/views/admin/modify.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int code = Integer.parseInt(request.getParameter("subCode"));	// sql문 조건값
		String subjectName = request.getParameter("subjectName");	
		String name = request.getParameter("name");
		int maxNum = Integer.parseInt(request.getParameter("maxNum"));
		Date start = Date.valueOf(request.getParameter("start"));
		Date end = Date.valueOf(request.getParameter("end"));

		Subject subject = new Subject(code, subjectName, name, maxNum, start, end);
		SubjectService sService = new SubjectService();

		int result = -1;
		result = sService.updateSubject(subject);

		if (result > 0) {
			// 성공하면 과목 조회 페이지로 이동
			response.sendRedirect("/admin/select");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/admin/select";
			writer.println("<script>");
			writer.println("alert('과목 수정에 실패하였습니다.')");
			writer.println("location.href='" + pageURL + "'");
			writer.println("</script>");
			writer.close();
		}

	}

}
