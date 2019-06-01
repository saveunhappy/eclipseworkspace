package com._zz._it._dao;

import java.util.List;

import com._zz._it._domain.Product;
import com._zz._it.page.PageResult;
import com._zz._it.query.ProductQueryObject;

public interface IProductDAO {
	void save(Product obj);
	
	void update(Product obj);
	
	void delete(Long id);
	
	Product get(Long id);
	
	List<Product> list();
	//高级查询
	List<Product> query1(ProductQueryObject qo);
	//分页查询
	PageResult query(Integer currentPage,Integer PageSize);
	
	//高级查询加分页查询
	PageResult query(ProductQueryObject qo);
}

//<package name="asdPkg" extends="struts-default" namespace="/crm1">
//
//<action name="api" class="com._mypack._01.hello.ServletApiAction2">
//<result name="haha">
//	/views/hello/index.jsp
//</result>
//</action>
//</package>
