package com._520if._shopping._dao._Impl;

import java.sql.ResultSet;
import java.util.List;

import com._520if._shopping._dao.IEmployeeDAO;
import com._520if._shopping._domain.Employee;
import com._520if._shopping.handler.BeanHandler;
import com._520if._shopping.handler.BeanListHandler;
import com._520if._shopping.handler.IResultSetHandler;
import com._520if._shopping.page.PageResult;
import com._520if._shopping.query.QueryObject;
import com._520if._shopping.util.JdbcTemplate;

public class EmployeeDAOImpl implements IEmployeeDAO {

	public void save(Employee p) {
		JdbcTemplate.update("INSERT INTO t_employee (username,password,headImg,dept,bornDate) values(?,?,?,?,?)",
				p.getUsername(),p.getPassword(),p.getHeadImg(),p.getDept(),p.getBornDate());
	}

	public void update(Employee p) {
		JdbcTemplate.update("UPDATE t_employee set username=?,password=?,headImg=?,dept=?,bornDate=? where id=?",
				p.getUsername(),p.getPassword(),p.getHeadImg(),p.getDept(),p.getBornDate(),p.getId());
	}

	public void delete(Long id) {
		JdbcTemplate.update("delete from t_employee where id = ?", id);
	}

	public Employee get(Long id) {
		return JdbcTemplate.query("select * from t_employee where id = ?", new BeanHandler<>(Employee.class),id);
	}

	public List<Employee> list() {
		return JdbcTemplate.query("select * from t_employee", new BeanListHandler<>(Employee.class));
	}
	public PageResult query(QueryObject qo) {
		//查询结果总数
		String countSql = "SELECT COUNT(*) FROM t_employee" + qo.getQuery();
		Integer totalCount = JdbcTemplate.query(countSql, 
			(ResultSet rs)-> {
				if(rs.next()) {
					return rs.getLong(1);
				}
				return 0L;
			},qo.getParameters().toArray()).intValue();
		if(totalCount == 0) {//如果等于0说明没有符合条件的数据，就没必要查询结果集
			return PageResult.empty(qo.getPageSize());
		}
		System.out.println("countSql"+countSql);
		System.out.println("参数="+qo.getParameters());
		//查询结果集
		String resultSql = "SELECT * FROM t_employee"+qo.getQuery()+"LIMIT ?,?";
		//增加limit的两个占位符参数
		qo.getParameters().add((qo.getCurrentPage() - 1)* qo.getPageSize());//LIMIT第一个?
		qo.getParameters().add(qo.getPageSize());//LIMIT的第二个?
		List<?> listData = JdbcTemplate.query(resultSql, new BeanListHandler<>(Employee.class), qo.getParameters().toArray());
		System.out.println("resultSql" + resultSql);
		System.out.println("参数"+qo.getParameters());
		return new PageResult(qo.getCurrentPage(), qo.getPageSize(), listData, totalCount);
		
		
	}


}
