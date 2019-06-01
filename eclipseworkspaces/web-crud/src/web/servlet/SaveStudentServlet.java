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

//保存学生信息
@WebServlet("/student/save")
public class SaveStudentServlet extends HttpServlet {
	private IStudentDAO dao;

	public void init() throws ServletException {
		dao = new IStudentDAOImpl();
	}

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 有中文可能会乱码，所以设置字符编码。
		req.setCharacterEncoding("UTF-8");// 只对post有效
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		Student stu = new Student(name, Integer.valueOf(age));
		String id = req.getParameter("id");
		if (hasLength(id)) {
			dao.update(stu);
		} else {
			dao.save(stu);
		}
		resp.sendRedirect("/student");
	}

	private boolean hasLength(String str) {
		return str != null && !"".equals(str);
	}
}
