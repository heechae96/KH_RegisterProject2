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
 * Servlet implementation class UserSelectSubject
 */
@WebServlet("/register/select")
public class UserSelectSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSelectSubject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SubjectService sService = new SubjectService();
		List<Subject> list = new ArrayList<Subject>();
		list = sService.selectAll();
		request.setAttribute("list", list);
		if (list.isEmpty()) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/";
			writer.println("<script>");
			writer.println("alert('개설된 과목이 없습니다. 관리자에게 문의하세요')");
			writer.println("location.href='" + pageURL + "'");
			writer.println("</script>");
			writer.close();
		} else {
			// 수강신청을 이미 완료한 경우에는 확인/정정 페이지로 이동
			UserService uService = new UserService();
			String id = request.getParameter("id");
			User user = uService.selectOneById(id);
			if (user.getSubjectCode() != 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				String pageURL = "/register/chkUpdate?id=" + id;
				writer.println("<script>");
				writer.println("alert('수강신청을 이미 완료했습니다')");
				writer.println("location.href='" + pageURL + "'");
				writer.println("</script>");
				writer.close();
			} else {
				request.getRequestDispatcher("/WEB-INF/views/user/selectSubject.jsp").forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자가 수강신청을 하면 2가지를 변경해야함.
		// 1. 과목의 수강 신청 인원
		// 2. 학생의 과목 코드

		String id = request.getParameter("id");
		int code = Integer.parseInt(request.getParameter("codeNum"));

		SubjectService sService = new SubjectService();
		UserService uService = new UserService();
		Subject subject = sService.selectSubject(code);
		int resultSubject = -1;
		int resultUser = -1;

		int enrollNum = subject.getEnrollNo();
		int maxNum = subject.getMaxNo();

		if (enrollNum < maxNum) {
			resultSubject = sService.plusSubject(code, subject);
			resultUser = uService.plusCodeSubject(code, id);
			if (resultSubject > 0 && resultUser > 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				String pageURL = "/register/chkUpdate?id=" + id;
				writer.println("<script>");
				writer.println("alert('성공적으로 수강신청 되었습니다.')");
				writer.println("location.href='" + pageURL + "'");
				writer.println("</script>");
				writer.close();
			}
//			else if (resultSubject <= 0) {
//				request.setAttribute("title", "수강 신청 실패");
//				request.setAttribute("msg", "과목 테이블 문제 발생");
//				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
//			} else if (resultUser <= 0) {
//				request.setAttribute("title", "수강 신청 실패");
//				request.setAttribute("msg", "유저 테이블 문제 발생");
//				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
//			} else {
//				request.setAttribute("title", "수강 신청 실패");
//				request.setAttribute("msg", "과목, 유저 테이블 모두 문제 발생");
//				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
//			}
		} else {
			// 신청인원이 인원제한에 걸린 경우
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/register/select?id=" + id;
			writer.println("<script>");
			writer.println("alert('해당 과목은 인원초과로 신청 할 수 없습니다.')");
			writer.println("location.href='" + pageURL + "'");
			writer.println("</script>");
			writer.close();
		}

	}

}
