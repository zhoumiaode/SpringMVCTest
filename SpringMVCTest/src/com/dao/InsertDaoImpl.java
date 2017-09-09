package com.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mapper.UserMapper;
import com.vo.Clazz;
import com.vo.Student;
import com.vo.User;

@Repository("insertDaoImpl")
public class InsertDaoImpl implements InsertDao{

	@Autowired
	private UserMapper userMapper;
	
	public void save(User user) {
		// TODO Auto-generated method stub
		userMapper.save(user);
		
	}

	public void delete(String name) {
		// TODO Auto-generated method stub
		userMapper.delete(name);
		
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		userMapper.update(user);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> userlist=userMapper.findAll();
		return userlist;
	}

	public List<String> find() {
		// TODO Auto-generated method stub
		List<String> userlist=userMapper.find();
		return userlist;
	}

	public List<User> findById(int id) {
		// TODO Auto-generated method stub
		List<User> userlist=userMapper.findById(id);
		return userlist;
	}

	public List<User> findByIdName(User user) {
		// TODO Auto-generated method stub
		List<User> userlist=userMapper.findByIdName(user);
		return userlist;
	}

	public List<Student> selectStudent() {
		// TODO Auto-generated method stub
		List<Student> studentlist=userMapper.selectStudent();
		return studentlist;
	}

	public List<Clazz> selectClazz() {
		// TODO Auto-generated method stub
		List<Clazz> clazzlist=userMapper.selectClazz();
		return clazzlist;
	}

	public List<User> selectByIdLike(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<User> userlist=userMapper.selectByIdLike(param);
		return userlist;
	}

	public List<User> selectByChoose(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<User> userlist=userMapper.selectByChoose(param);
		return userlist;
	}

	public void updateIfNecessary(User user) {
		// TODO Auto-generated method stub
		userMapper.updateIfNecessary(user);
	}

	public List<User> selectByList(List<Integer> item) {
		// TODO Auto-generated method stub
		List<User> userlist=userMapper.selectByList(item);
		return userlist;
	}

	public List<User> selectByLike(User user) {
		// TODO Auto-generated method stub
		List<User> userlist=userMapper.selectByLike(user);
		return userlist;
	}

	public List<User> selectProvider(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<User> userlist=userMapper.selectProvider(param);
		return userlist;
	}

	public int insertProvider(User user) {
		// TODO Auto-generated method stub
		int a=userMapper.insertProvider(user);
		return a;
		
	}


	

}
