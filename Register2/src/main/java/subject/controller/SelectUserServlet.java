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

import common.SubjectUser;
import user.model.service.UserService;
import user.model.service.UserServiceImpl;

/**
 * Servlet implementation class SelectUserServlet
 */
@WebServlet("/admin/selectUser")
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService uService = new UserServiceImpl();
		List<SubjectUser> list = new ArrayList<SubjectUser>();
		list = uService.selectAll();
		request.setAttribute("list", list);
		if (list.isEmpty()) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String pageURL = "/";
			writer.println("<script>");
			writer.println("alert('수강신청을 한 학생이 없습니다.')");
			writer.println("location.href='" + pageURL + "'");
			writer.println("</script>");
			writer.close();
		} else {
			request.getRequestDispatcher("/WEB-INF/views/admin/selectUser.jsp").forward(request, response);
		}
	}

}