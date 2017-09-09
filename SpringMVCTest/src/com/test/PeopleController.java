package com.test;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tools.UserValidator;
import com.vo.People;
import com.vo.User;

@RequestMapping(value="/people")
@Controller
public class PeopleController {
	private static final Log logger=LogFactory.getLog(PeopleController.class);
		
		@RequestMapping(value="/registerform",method=RequestMethod.GET)
		public String registerForm(Model model){
			People people=new People();
			model.addAttribute("people", people);
			return "registerform2";
		}
		
		@RequestMapping(value="/register",method=RequestMethod.POST)
		public String register(@Valid People people,Errors errors,Model model){
			logger.info(people);
			if(errors.hasFieldErrors()){
				return "registerform2";
			}else{
				model.addAttribute("people", people);
				return "welcome";
			}
		}
}