package com.test;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.vo.User;

public class UserProvider {
	public String SelectWithSQL(final Map<String,Object> param){
		return new SQL(){
		   {
			SELECT("*");
			FROM("tb_user");
			if(param.get("tb_id")!=null){
				WHERE("tb_id=#{tb_id}");
			  }
			if(param.get("tb_name")!=null){
				WHERE("tb_name=#{tb_name}");
			  }
			if(param.get("tb_sex")!=null){
				WHERE("tb_sex=#{tb_sex}");
			  }
			if(param.get("tb_age")!=null){
				WHERE("tb_age=#{tb_age}");
			  }
	       }  
		}.toString();
	}
	public String InsertWithSQL(final User user){
		return new SQL(){
		   {
			INSERT_INTO("tb_user");
			if(user.getId()!=null){
				VALUES("tb_id","#{id}");
			  }
			if(user.getName()!=null){
				VALUES("tb_name","#{name}");
			  }
			if(user.getSex()!=null){
				VALUES("tb_sex","#{sex}");
			  }
			if(user.getAge()!=null){
				VALUES("tb_age","#{age}");
			  }
	       }  
		}.toString();
	}
	public String UpdateWithSQL(final User user){
		return new SQL(){
		   {
			UPDATE("tb_user");
			if(user.getId()!=null){
				SET("tb_id=#{id}");
			  }
			if(user.getName()!=null){
				SET("tb_name=#{name}");
			  }
			if(user.getSex()!=null){
				SET("tb_sex=#{sex}");
			  }
			if(user.getAge()!=null){
				SET("tb_age=#{age}");
			  }
			WHERE("tb_id=#{id}");
	       }  
		}.toString();
	}
	public String DeleteWithSQL(final User user){
		return new SQL(){
		   {
			DELETE_FROM("tb_user");
			if(user.getId()!=null){
				WHERE("tb_id=#{id}");
			  }
			if(user.getName()!=null){
				WHERE("tb_name=#{name}");
			  }
			if(user.getSex()!=null){
				WHERE("tb_sex=#{sex}");
			  }
			if(user.getAge()!=null){
				WHERE("tb_age=#{age}");
			  }
			if(user.getId()!=null){
			    WHERE("tb_id=#{id}");
			}
	       }  
		}.toString();
	}
}
