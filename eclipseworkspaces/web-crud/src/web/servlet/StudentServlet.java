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
//处理所有的student相关的请求操作
@WebServlet("/student")
public class StudentServlet extends HttpServlet{
	private IStudentDAO dao;
	public void init() throws ServletException {
		dao = new IStudentDAOImpl();
	}
	
	
	private static final long serialVersionUID = 1L;
	//http:localhost/student进入service方法，到底是保存，删除，查询。
	//http:localhost/student?cmd=save//保存操作
	//http:localhost/student?cmd=delete//删除操作
	//http:localhost/student?cmd=edit//编辑操作	
	//http:localhost/student列表操作
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String cmd = req.getParameter("cmd");
		if("save".equals(cmd)) {
			this.saveOrUpdate(req, resp);
		}
		else if("edit".equals(cmd)) {
			this.edit(req, resp);
		}
		else if("delete".equals(cmd)) {
			this.delete(req, resp);
		}
		else {
			this.list(req, resp);
		}
	}
	//列表操作
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> list = dao.listAll();
		req.setAttribute("students", list);//把结果数据共享给list.jsp
		req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
	}
	//编辑操作
	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
	//删除操作
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		dao.delete(id);
		resp.sendRedirect(req.getContextPath()+"/student");
	}
	//新增或者更新操作
	protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
				resp.sendRedirect(req.getContextPath()+"/student");
	}
	private boolean hasLength(String str) {
		return str != null && !"".equals(str);
	}
}
