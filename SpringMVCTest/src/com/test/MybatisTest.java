package com.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.vo.User;

public class MybatisTest {
	public static void main(String arg[]) throws Exception{
		InputStream inputstream=Resources.getResourceAsStream("config/mybatis-config.xml");
		SqlSessionFactory sqlSessionFactoty=new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession session=sqlSessionFactoty.openSession();
		User user=new User("admin1","ÄÐ",26);
		session.insert("com.mapper.UserMapper.save",user);
		session.commit();
		session.close();
	
		
	}

}
