package com.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tools.UserValidator;
import com.vo.User;

@RequestMapping(value="/user")
@Controller
public class UserController {
	
	@Autowired
	@Qualifier("uservalidator")
	private UserValidator uservalidator;
	
	
	@RequestMapping(value="/registerform",method=RequestMethod.GET)
	public String registerForm(Model model){
		User user=new User();
		model.addAttribute("user", user);
		return "registerform";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@ModelAttribute User user,Model model,Errors errors){
		model.addAttribute("user", user);
		uservalidator.validate(user, errors);
		if(errors.hasFieldErrors()){
			return "registerform";
		}else{
			return "welcome";
		}
		
	}

}
