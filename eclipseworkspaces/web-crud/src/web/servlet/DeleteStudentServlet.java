package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypack.dao.IStudentDAO;
import com.mypack.dao.impl.IStudentDAOImpl;
//删除指定学生的id
@WebServlet("/student/delete")
public class DeleteStudentServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private IStudentDAO dao;
	public void init() throws ServletException {
		dao = new IStudentDAOImpl();
	} 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Long id = Long.valueOf(req.getParameter("id"));
			dao.delete(id);
			resp.sendRedirect("/student/list");
	}
}
