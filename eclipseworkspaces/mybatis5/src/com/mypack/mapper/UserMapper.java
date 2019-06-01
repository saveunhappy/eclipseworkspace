package com.mypack.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mypack.domain.User;

public interface UserMapper {
	@Insert("insert into t_user (name,salary) values(#{name},#{salary});")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(User u);
	@Update("UPDATE t_user SET name =#{name} ,salary =#{salary} where id = #{id}")
	void update(User u);
	@Delete("delete from t_user where id = #{id}")
	void delete(Long id);
	@Select("select id,name from t_user where id= #{id}")
	User get(Long id);
	@Select("select id,name from t_user")
	List<User> listAll();
}
