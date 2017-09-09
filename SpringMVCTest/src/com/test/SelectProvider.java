package com.test;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class SelectProvider {

	public String Select(final Map<String,Object> param){
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
}
