package com._520if._shopping.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com._520if._shopping._dao.IProductDAO;
import com._520if._shopping._dao.IProductDirDAO;
import com._520if._shopping._dao._Impl.ProductDirImpl;
import com._520if._shopping._dao._Impl.ProductImpl;
import com._520if._shopping._domain.Product;
import com._520if._shopping.page.PageResult;
import com._520if._shopping.query.ProductQueryObject;
@WebServlet("/page")
public class PageServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private IProductDAO dao;
	private IProductDirDAO dirDAO;
	public void init() throws ServletException {
		dao = new ProductImpl();
		dirDAO = new ProductDirImpl();
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Integer  currentPage = 1;
		String sCurrentPage = req.getParameter("currentPage");
		if(StringUtils.isNotBlank(sCurrentPage)) {
			currentPage = Integer.valueOf(sCurrentPage);
		}
		
		
		PageResult pageResult = dao.query(currentPage, 5);
		req.setAttribute("pageResult", pageResult);
		
		
		//把所有的商品分类信息共享给JSP
		req.setAttribute("dirs", dirDAO.list());
		req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
	}


}
