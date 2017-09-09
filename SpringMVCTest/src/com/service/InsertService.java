package com.service;

import java.util.HashMap;
import java.util.List;

import com.vo.Clazz;
import com.vo.Student;
import com.vo.User;

public interface InsertService {
	void save(User user);
	void delete(String name);
	void update(User user);
	List<User> findAll();
	List<String> find();
	List<User> findById(int id);
	List<User> findByIdName(User user);
	List<Student> selectStudent();
	 List<Clazz> selectClazz();
	 List<User> selectByIdLike(HashMap<String, Object> param);
	 List<User> selectByChoose(HashMap<String, Object> param);
	 void updateIfNecessary(User user);
	 List<User> selectByList(List<Integer> item);
	 List<User> selectByLike(User user);
	 List<User> selectProvider(HashMap<String,Object> param);
	 int insertProvider(User user);
}
