package web.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Demo1 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		try {
			FileItemFactory factory = new DiskFileItemFactory();
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			List<FileItem> items = upload.parseRequest(req);
			for (FileItem item : items) {
				//获取name的属性值
				String fileName = item.getFieldName();
				if(item.isFormField()) {
					//获取文本框里面的参数值
					String value = item.getString("UTF-8");
					
				}else {
					//获取上传文件的名字
					System.out.println(item.getName());
					item.write(new File("C:\\",item.getName()));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
