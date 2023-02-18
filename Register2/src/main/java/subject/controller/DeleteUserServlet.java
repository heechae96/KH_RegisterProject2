package subject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import subject.model.service.SubjectService;
import subject.model.service.SubjectServiceImpl;
import subject.model.vo.Subject;
import user.model.service.UserService;
import user.model.service.UserServiceImpl;
import user.model.vo.User;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/admin/deleteUser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUserServlet() {
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
		int result = -1;

		// 강제로 회원을 탈퇴시키는 경우
		User user = uService.selectOneById(id);
		int subCode = user.getSubjectCode();
		SubjectService sService = new SubjectServiceImpl();
		Subject subject = sService.selectSubject(subCode);
		if (subject != null) {
			// 수강 신청 한 과목의 수강 신청 인원을 제외해야함
			sService.minusSubject(subject);
			result = uService.deleteUser(id);
		} else {
			// 수강 신청을 안 한 경우 그냥 바로 삭제
			result = uService.deleteUser(id);
		}
		
		if (result > 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/admin/selectUser";
			writer.println("<script>");
			writer.println("alert('해당 이용자를 삭제했습니다.')");
			writer.println("location.href='" + pageURL + "'");
			writer.println("</script>");
			writer.close();
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/admin/selectUser";
			writer.println("<script>");
			writer.println("alert('해당 이용자를 삭제하지 못했습니다.')");
			writer.println("location.href='" + pageURL + "'");
			writer.println("</script>");
			writer.close();
		}
	}

}
