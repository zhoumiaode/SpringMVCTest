package com.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.test.UserProvider;
import com.vo.Clazz;
import com.vo.Student;
import com.vo.User;

public interface UserMapper {

	void save(User user);
	void delete(String name);
	void update(User user);
	List<User> findAll();
	List<String> find();
	@Select("select  * from tb_user where tb_id=#{tb_id}")
	@Results({
			@Result(id=true,column="tb_id",property="id"),
			@Result(column="tb_name",property="name"),
			@Result(column="tb_sex",property="sex"),
			@Result(column="tb_age",property="age"),
	
	})
	List<User> findById(@Param("tb_id") int id);
	List<User> findByIdName(User user);
	List<Student> selectStudent();
	
	/*@Select("select * from clazz")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="code",property="code"),
		@Result(column="id",property="students",
		many=@Many(select="com.mapper.StudentMapper.selectbyId",fetchType=FetchType.LAZY))
		
	})*/
	List<Clazz> selectClazz();
	//if语句的调用
	List<User> selectByIdLike(HashMap<String,Object> param);
	//choose语句的调用
	List<User> selectByChoose(HashMap<String,Object> param);
	//动态更新
	void updateIfNecessary(User user);
	//foreach的用法
	List<User> selectByList(List<Integer> item);
	//bind的用法
	List<User> selectByLike(User user);
	//通过注释进行动态SQL设置
	@SelectProvider(method = "SelectWithSQL", type =UserProvider.class)
	@Results({
		@Result(id=true,column="tb_id",property="id"),
		@Result(column="tb_name",property="name"),
		@Result(column="tb_sex",property="sex"),
		@Result(column="tb_age",property="age"),
	})
	List<User> selectProvider(HashMap<String,Object> param);
	@InsertProvider(method = "InsertWithSQL", type =UserProvider.class)
	@Options(useGeneratedKeys=true,keyProperty="id")
	int insertProvider(User user);
}
