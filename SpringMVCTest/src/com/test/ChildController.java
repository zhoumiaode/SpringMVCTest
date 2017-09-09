package com.test;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vo.Child;

@Controller
@RequestMapping(value="child")
public class ChildController {
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ModelAndView login(ModelAndView mv,@Valid Child child,HttpSession session){
		if(child.getUsername().equals("123")&&child.getPassword().equalsIgnoreCase("123")){
			session.setAttribute("child", child);
			mv.setViewName("redirect:/book/main");
		}else{
			mv.addObject("message","’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
			mv.setViewName("childlogin");
		}
		return mv;
		
	}
	
	

}
