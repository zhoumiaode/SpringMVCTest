package com.tools;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vo.User;

@Repository("uservalidator")
public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors error) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(error, "username", null,"用户名不能为空");
		ValidationUtils.rejectIfEmpty(error, "password", null,"密码不能为空");
		User user=(User) target;
        /*if(user.getUsername().length()>6){
        	error.rejectValue("username", null, "用户名不能超过6个字符");
        }
        if(user.getPassword()!=null&&!user.getPassword().equals("")&&user.getPassword().length()<6){
        	error.rejectValue("password", null, "密码不能小于6个字符");
        }*/
	}

}
