package user.controller;

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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/register/delete")
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

		String id = request.getParameter("id");
		UserService uService = new UserServiceImpl();
		int result = -1;
		
		// 회원탈퇴의 경우 
		User user = uService.selectOneById(id);
		int subCode = user.getSubjectCode();
		SubjectService sService = new SubjectServiceImpl();
		Subject subject = sService.selectSubject(subCode);
		if(subject != null) {
			// 수강 신청 한 과목의 수강 신청 인원을 제외해야함
			sService.minusSubject(subject);
			result = uService.deleteUser(id);
		}else {
			// 수강 신청을 안 한 경우 그냥 바로 삭제
			result = uService.deleteUser(id);
		}
		
		if (result > 0) {
			// 세션을 종료하는게 로그아웃쪽에서도 사용되고 있다
			// 내부적으로 세션 반환
			response.sendRedirect("/register/logout");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/register/enroll";
			writer.println("<script>");
			writer.println("alert('회원 탈퇴에 실패하였습니다.')");
			writer.println("location.href='" + pageURL + "'");
			writer.println("</script>");
			writer.close();
		}

	}

}
