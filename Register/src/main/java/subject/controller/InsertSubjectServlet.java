package subject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import subject.model.service.SubjectService;
import subject.model.vo.Subject;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/admin/insert")
public class InsertSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertSubjectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/admin/addSubject.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String subjectName = request.getParameter("subjectName");
		String name = request.getParameter("name");
		int maxNum = Integer.parseInt(request.getParameter("maxNum"));
		Date start = Date.valueOf(request.getParameter("start"));
		Date end = Date.valueOf(request.getParameter("end"));

		Subject subject = new Subject(subjectName, name, maxNum, start, end);
		SubjectService sService = new SubjectService();

		int result = -1;
		result = sService.insertSubject(subject);

		if (result > 0) {
			// 성공하면 과목 조회 페이지로 이동
			response.sendRedirect("/admin/select");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/admin/insert";
			writer.println("<script>");
			writer.println("alert('과목 등록에 실패하였습니다.')");
			writer.println("location.href='" + pageURL + "'");
			writer.println("</script>");
			writer.close();
		}

	}

}
