package com._520if._shopping.web.action;

import java.util.List;

import com._520if._shopping._dao.IProductDAO;
import com._520if._shopping._dao.IProductDirDAO;
import com._520if._shopping._dao._Impl.ProductDirImpl;
import com._520if._shopping._dao._Impl.ProductImpl;
import com._520if._shopping._domain.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;

public class ProductAction extends ActionSupport{

	
	private static final long serialVersionUID = 1L;
	private IProductDAO dao = new ProductImpl();
	@Getter
	private Product product = new Product();
	
	private IProductDirDAO dirDAO = new ProductDirImpl();
	public String execute() throws Exception {
			List<Product> list = dao.list();
			ActionContext.getContext().put("products", list);
		
		return "list";
	}
	//删除操作
	
	public String delete() {
		if(product.getId()!=null) {
			dao.delete(product.getId());
		}
		
		return SUCCESS;
	}
	
	//进入编辑界面
	public String input() throws Exception {
		//查询出所有的商品分类
		ActionContext.getContext().put("dirs", dirDAO.list());
		//查询需要回显的数据
		if(product.getId()!=null) {
			product = dao.get(product.getId());
		}
		return INPUT;
	}
	//保存或者更新操作
	public String save() throws Exception  {
		if(product.getId()==null) {
			if(product.getDir_id()==-1) {
				product.setDir_id(null);
			}
			dao.save(product);
		}
		else {
			dao.update(product);
		}
		return SUCCESS;
	}
}
