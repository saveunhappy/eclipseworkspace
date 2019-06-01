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
import com._520if._shopping.query.ProductQueryObject;
@WebServlet("/product")
public class ProductServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private IProductDAO dao;
	private IProductDirDAO dirDAO;
	public void init() throws ServletException {
		dao = new ProductImpl();
		dirDAO = new ProductDirImpl();
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("UTF-8");
		ProductQueryObject qo = new ProductQueryObject(); 
		this.request2obj(req,qo);
		req.setAttribute("qo", qo);//把查询数据回显在查询表中
		List<Product> list = dao.query(qo);
		//把所有的商品分类信息共享给JSP
		req.setAttribute("dirs", dirDAO.list());
		req.setAttribute("product", list);
		req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
	}
	private void request2obj(HttpServletRequest req, ProductQueryObject qo) {
		String name = req.getParameter("name");
		String minSalePrice = req.getParameter("minSalePrice");
		String maxSalePrice=  req.getParameter("maxSalePrice");
		String dirId = req.getParameter("dirId");
		String keyword = req.getParameter("keyword");
		if(StringUtils.isNotBlank(keyword)) {
			qo.setKeyword(keyword);
		}
		if(StringUtils.isNotBlank(name)) {
			qo.setName(name);
		}
		if(StringUtils.isNotBlank(minSalePrice)) {
			qo.setMinSalePrice(new BigDecimal(minSalePrice));
		}
		if(StringUtils.isNotBlank(maxSalePrice)) {
			qo.setMaxSalePrice(new BigDecimal(maxSalePrice));
		}
		if(StringUtils.isNotBlank(dirId)) {
			qo.setDirId(Long.valueOf(dirId));
		}
	}

}
