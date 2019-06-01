package com._520if._shopping.handler;

import java.sql.ResultSet;
import java.util.List;

//处理结果集，规范处理结果集的方法名称
public interface IResultSetHandler<T> {
	T handle(ResultSet rs) throws Exception;
}
