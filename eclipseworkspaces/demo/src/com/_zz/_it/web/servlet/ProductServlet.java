package com._zz._it.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com._zz._it._dao.IProductDAO;
import com._zz._it._dao.IProductDirDAO;
import com._zz._it._dao._Impl.ProductDirImpl;
import com._zz._it._dao._Impl.ProductImpl;
import com._zz._it._domain.Product;
import com._zz._it.page.PageResult;
import com._zz._it.query.ProductQueryObject;
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
		ProductQueryObject qo = new ProductQueryObject(); 
		this.request3obj(req,qo);
		req.setAttribute("qo", qo);//把查询数据回显在查询表中
		//===============================
		PageResult pageResult = dao.query(qo);
		//把所有的商品分类信息共享给JSP
		req.setAttribute("dirs", dirDAO.list());
		//=============================== 
		req.setAttribute("pageResult", pageResult);
		req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
		
		//req.setCharacterEncoding("UTF-8");//对post有效，必须在第一个参数之前
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
		this.request2Obj(req,p);
		if(p.getId()!=null) {
			dao.update(p);
		}else {
		dao.save(p);
		}
		//3控制界面跳转
		resp.sendRedirect("/product");
	
	}
	
	private void request2Obj(HttpServletRequest req, Product p) {
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
	private void request3obj(HttpServletRequest req, ProductQueryObject qo) {
		String name = req.getParameter("name");
		String minSalePrice = req.getParameter("minSalePrice");
		String maxSalePrice=  req.getParameter("maxSalePrice");
		String dirId = req.getParameter("dirId");
		String keyword = req.getParameter("keyword");
		
		//接收用户传入的currentPage和PageSize
		String currentPage = req.getParameter("currentPage");
		String pageSize = req.getParameter("pageSize");
		
		if(StringUtils.isNotBlank(currentPage)) {
			qo.setCurrentPage(Integer.valueOf(currentPage));
		}
		if(StringUtils.isNotBlank(pageSize)) {
			qo.setPageSize(Integer.valueOf(pageSize));
		}
		
		
		
		
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
	private boolean hasLength(String str) {
		return str!=null&&!"".equals(str.trim());
	}


}
