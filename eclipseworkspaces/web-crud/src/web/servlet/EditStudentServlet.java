package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypack.dao.IStudentDAO;
import com.mypack.dao.impl.IStudentDAOImpl;
import com.mypack.domain.Student;
@WebServlet("/student/edit")
public class EditStudentServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private IStudentDAO dao;
	public void init() throws ServletException {
		dao = new IStudentDAOImpl();
	} 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.接收请求参数
		String sid = req.getParameter("id");
		//2.调用业务方法处理请求
		if(hasLength(sid)) {
		Student stu = dao.get(Long.valueOf(sid));
		req.setAttribute("student",stu);//传递给edit.jsp用于回显被编辑的学生
		}
		//3.控制界面跳转
		req.getRequestDispatcher("/WEB-INF/views/student/edit.jsp").forward(req, resp);
	
	}
	private boolean hasLength(String str) {
		return str!=null&&!"".equals(str);
	}
}
