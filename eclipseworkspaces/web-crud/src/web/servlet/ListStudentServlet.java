package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypack.dao.IStudentDAO;
import com.mypack.dao.impl.IStudentDAOImpl;
import com.mypack.domain.Student;
@WebServlet("/student/list")
public class ListStudentServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	private IStudentDAO dao;
	public void init() throws ServletException {
		dao = new IStudentDAOImpl();
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	List<Student> list = dao.listAll();
	req.setAttribute("students", list);//把结果数据共享给list.jsp
	req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
	}
}
