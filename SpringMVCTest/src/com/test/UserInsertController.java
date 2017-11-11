package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.InsertServiceImpl;
import com.vo.Clazz;
import com.vo.Student;
import com.vo.User;

@Controller
public class UserInsertController {
	
	@Autowired
	@Qualifier("insertServiceImpl")
	private InsertServiceImpl insertServiceImpl;
	
	@RequestMapping(value="insert")
	public String insert(@RequestParam("name")String name,@RequestParam("sex")String sex,
			@RequestParam("age")Integer age,Model model){
		
		/*User user=new User(name,sex,age);
		insertServiceImpl.save(user);*/
		/*String name1="1";
		insertServiceImpl.delete(name1);*/
		/*User user1=new User(50,"sssss","sss",12);
		insertServiceImpl.update(user1);*/
		/*int id=47;
		List<User> userlist=insertServiceImpl.findById(id);*/
		/*List<String> userlist=insertServiceImpl.find();*/
		/*User user2=new User(name,age);
		List<User> userlist=insertServiceImpl.findByIdName(user2);
		model.addAttribute("userlist", userlist);*/
		
		/*List<Student> studentlist=insertServiceImpl.selectStudent();
		model.addAttribute("studentlist", studentlist);*/
		List<Clazz> clazzlist=insertServiceImpl.selectClazz();
		model.addAttribute("clazzlist", clazzlist);
		/*for(Clazz cl:clazzlist){
			System.out.println(cl);
			List<Student> s=cl.getStudents();
			for(Student ss:s){
				System.out.println("aa:"+ss.getAge());
			}
		}*/
		//choose动态sql
		/*HashMap<String,Object> param=new HashMap<String,Object>();
		param.put("tb_id",28);
		param.put("tb_age",12);
		param.put("tb_sex", 12);
		List<User> userlist=insertServiceImpl.selectByChoose(param);
		model.addAttribute("userlist", userlist);*/
		/*set的使用
		User user=new User();
		user.setId(30);
		user.setSex("男");
		insertServiceImpl.updateIfNecessary(user);*/
		/*foreach用法
		List<Integer> item=new ArrayList<Integer>();
		item.add(30);
		item.add(31);
		List<User> userlist=insertServiceImpl.selectByList(item);*/
	/*	bind的使用
		User user=new User();
		user.setId(2);
		List<User> userlist=insertServiceImpl.selectByLike(user);*/
		/*注释进行动态SQL语句*/
		/*HashMap<String,Object> param=new HashMap<String,Object>();
		param.put("tb_age",12);
		param.put("tb_sex", 12);
		List<User> userlist=insertServiceImpl.selectProvider(param);
		model.addAttribute("userlist", userlist);
		User user=new User();
		user.setName(name);
		user.setSex(sex);
		user.setAge(age);
		int a=insertServiceImpl.insertProvider(user);
		if(a==1){
			System.out.println("成功");
			System.out.println(user.getId());
		}*/
		return "success2";
		
	}

}
