package web.upload;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/upload")

public class UploadServlet3 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 允许接收的图片类型
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 将处理文件的类给抽取出来，没有用到响应对象，这时候可以throw一个异常对象。
		 * 继承于RuntimeException 这样就可处理，可不处理，也是框架中所推崇的
		 * 然后在工具类中的resp哪里改代码，用LogicException来抛出，然后
		 * 在catch中使用LogicException，继续throw，让调用者来解决
		 * 调用者的catch中也可以用LogicException来用getMaeeage()
		 * 来接收异常，然后通过getRequestDispatcher来把自己定义的错误信息
		 * 拿给用户看，Perfect!!
		 */
		try {
			FileUtil.upload(req); 
		} catch (LogicException e) {
			// TODO Auto-generated catch block
			String err = e.getMessage();
			req.setAttribute("error", err);
			req.getRequestDispatcher("/input.jsp").forward(req, resp);
		}
	}

}
