package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import subject.model.service.SubjectService;
import subject.model.vo.Subject;
import user.model.service.UserService;

/**
 * Servlet implementation class UserSubjectDeleteServlet
 */
@WebServlet("/register/deleteSub")
public class UserDeleteSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDeleteSubjectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 사용자가 수강신청 삭제를 하면 2가지를 변경해야함.
		// 1. 과목의 수강 신청 인원
		// 2. 학생의 과목 코드

		String id = request.getParameter("id");
		int code = Integer.parseInt(request.getParameter("codeNum"));

		// 1.
		// 선택한 과목의 정보를 가져옴
		// 기존 수강신청 인원을 구하기 위함
		SubjectService sService = new SubjectService();
		Subject subject = sService.selectSubject(code);
		int resultSubject = -1;
		resultSubject = sService.minusSubject(code, subject);

		// 2.
		UserService uService = new UserService();
		int resultUser = -1;
		resultUser = uService.minusCodeSubject(id);

		if (resultSubject > 0 && resultUser > 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/register/select?id=" + id;
			writer.println("<script>");
			writer.println("alert('성공적으로 수강신청 내역을 삭제했습니다.')");
			writer.println("location.href='" + pageURL + "'");
			writer.println("</script>");
			writer.close();
		} else if (resultSubject <= 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/";
			writer.println("<script>");
			writer.println("alert('과목 테이블 문제 발생')");
			writer.println("location.href='" + pageURL + "'");
			writer.println("</script>");
			writer.close();
		} else if (resultUser <= 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/";
			writer.println("<script>");
			writer.println("alert('유저 테이블 문제 발생')");
			writer.println("location.href='" + pageURL + "'");
			writer.println("</script>");
			writer.close();
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/register/select";
			writer.println("<script>");
			writer.println("alert('과목, 유저 테이블 문제 발생')");
			writer.println("location.href='" + pageURL + "'");
			writer.println("</script>");
			writer.close();
		}

	}

}
