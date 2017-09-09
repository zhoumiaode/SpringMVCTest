package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test {
	
	@RequestMapping(value="/hello")
	public ModelAndView login(ModelAndView mv){
		mv.setViewName("redirect://index");
		return mv;
		
	}
	@RequestMapping(value="/index")
	public ModelAndView login1(ModelAndView mv){
		mv.addObject("message", "tt");
		mv.setViewName("index");
		return mv;
		
	}
	

}
