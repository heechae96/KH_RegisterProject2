package subject.controller;

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

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/admin/delete")
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

		int codeNum = Integer.parseInt(request.getParameter("code"));
		SubjectService sService = new SubjectService();
		int result = -1;
		result = sService.deleteSubject(codeNum);
		if (result > 0) {
			// 성공하면 과목 조회 페이지로 이동
			response.sendRedirect("/admin/select");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/admin/select";
			writer.println("<script>");
			writer.println("alert('해당 과목이 존재하지 않아 삭제가 불가능합니다.')");
			writer.println("location.href='" + pageURL + "'");
			writer.println("</script>");
			writer.close();
		}
	}

}
