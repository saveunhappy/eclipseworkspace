package com._520if._shopping.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520if._shopping._dao.IProductDAO;
import com._520if._shopping._dao.IProductDirDAO;
import com._520if._shopping._dao._Impl.ProductDirImpl;
import com._520if._shopping._dao._Impl.ProductImpl;
import com._520if._shopping._domain.Product;
@WebServlet("/product")
public class ProductServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private IProductDAO dao;
	private IProductDirDAO dirDAO;
	@Override
	public void init() throws ServletException {
		dao = new ProductImpl();
		dirDAO = new ProductDirImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//------------------------------------
		//获取登陆之后的session里面的数据
		Object val = req.getSession().getAttribute("USER_IN_SESSION");
		//如果值为空的话，就回退到登陆界面。
		if(val==null) {
			resp.sendRedirect("/login.jsp");
			return;
		}
		//------------------------------------
		
		req.setCharacterEncoding("UTF-8");//对post有效，必须在第一个参数之前
		String cmd = req.getParameter("cmd");
		if("edit".equals(cmd)) {
			this.edit(req, resp);
		}else if("delete".equals(cmd)) {
			this.delete(req, resp);
		}else if("save".equals(cmd)) {
			this.saveOrUpdate(req, resp);
		}else {
			this.list(req, resp);
		}
		
	}
	//显示商品列表
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> list = dao.list();
		req.setAttribute("product", list);
		req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
	}
	//删除指定商品
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		dao.delete(Long.valueOf(id));
		resp.sendRedirect("/product");
	}
	//进入编辑界面
	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if(hasLength(id)) {
			Product p = dao.get(Long.valueOf(id));
			req.setAttribute("product", p);
		}
		//在进入编辑界面之前就显示出所有的商品分类信息
		req.setAttribute("dirs", dirDAO.list());
		req.getRequestDispatcher("/WEB-INF/views/student/edit.jsp").forward(req, resp);;
	
	
	}
	//新增或者更新操作
	protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1接收请求参数，封装成对象
		//2调用业务方法处理请求
		Product p = new Product();
		this.request3Obj(req,p);
		if(p.getId()!=null) {
			dao.update(p);
		}else {
		dao.save(p);
		}
		//3控制界面跳转
		resp.sendRedirect("/product");
	
	}
	
	private void request3Obj(HttpServletRequest req, Product p) {
			String productName = req.getParameter("productName");
			String brand = req.getParameter("brand");
			String supplier = req.getParameter("supplier");
			String salePrice = req.getParameter("salePrice");
			String costPrice = req.getParameter("costPrice");
			String cutoff = req.getParameter("cutoff");
			String dir_id = req.getParameter("dir_id");
			String id = req.getParameter("id");
			if(hasLength(id)) {
				p.setId(Long.valueOf(id));
			}
			p.setProductName(productName);
			p.setBrand(brand);
			p.setSupplier(supplier);
			p.setSalePrice(new BigDecimal(salePrice));
			p.setCostPrice(new BigDecimal(costPrice));
			p.setCutoff(Double.valueOf(cutoff));
			p.setDir_id(Long.valueOf(dir_id));
			
		
		
	}
	private boolean hasLength(String str) {
		return str!=null&&!"".equals(str.trim());
	}


}
