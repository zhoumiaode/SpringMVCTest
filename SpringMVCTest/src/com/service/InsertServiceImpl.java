package com.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.InsertDaoImpl;
import com.vo.Clazz;
import com.vo.Student;
import com.vo.User;

@Service("insertServiceImpl")
@Transactional
public class InsertServiceImpl implements InsertService{
	
	@Autowired
	@Qualifier("insertDaoImpl")
	private InsertDaoImpl insertDaoImpl;

	public void save(User user) {
		// TODO Auto-generated method stub
		insertDaoImpl.save(user);
		
	}

	public void delete(String name) {
		// TODO Auto-generated method stub
		insertDaoImpl.delete(name);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		insertDaoImpl.update(user);
		
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> userlist=insertDaoImpl.findAll();
		return userlist;
	}

	public List<String> find() {
		// TODO Auto-generated method stub
		List<String> userlist=insertDaoImpl.find();
		return userlist;
	}

	public List<User> findById(int id) {
		// TODO Auto-generated method stub
		List<User> userlist=insertDaoImpl.findById(id);
		return userlist;
	}

	public List<User> findByIdName(User user) {
		// TODO Auto-generated method stub
		List<User> userlist=insertDaoImpl.findByIdName(user);
		return userlist;
	}

	public List<Student> selectStudent() {
		// TODO Auto-generated method stub
		List<Student> studentlist=insertDaoImpl.selectStudent();
		return studentlist;
	}
	public List<Clazz> selectClazz() {
		// TODO Auto-generated method stub
		List<Clazz> clazzlist=insertDaoImpl.selectClazz();
		return clazzlist;
	}
	public List<User> selectByIdLike(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<User> userlist=insertDaoImpl.selectByIdLike(param);
		return userlist;
	}
	public List<User> selectByChoose(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<User> userlist=insertDaoImpl.selectByChoose(param);
		return userlist;
	}

	public void updateIfNecessary(User user) {
		// TODO Auto-generated method stub
		insertDaoImpl.updateIfNecessary(user);
	}
	public List<User> selectByList(List<Integer> item) {
		// TODO Auto-generated method stub
		List<User> userlist=insertDaoImpl.selectByList(item);
		return userlist;
	}
	public List<User> selectByLike(User user) {
		// TODO Auto-generated method stub
		List<User> userlist=insertDaoImpl.selectByLike(user);
		return userlist;
	}
	public List<User> selectProvider(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		List<User> userlist=insertDaoImpl.selectProvider(param);
		return userlist;
	}
	public int insertProvider(User user) {
		// TODO Auto-generated method stub
		int a=insertDaoImpl.insertProvider(user);
		return a;
		
	}

}
