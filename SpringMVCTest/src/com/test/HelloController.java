package com.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.tools.DateEditor;
import com.vo.Person;
import com.vo.User;

@Controller
@RequestMapping(value="/hell")
@Repository("a")
public class HelloController{

	private static List<User> list;
	private static final Log logger=LogFactory.getLog(HelloController.class);

	public HelloController(){
		super();
		list=new ArrayList<User>();
	}
	/*@RequestMapping(value="/{formName}")
	public String index(@PathVariable  String formName,Model model){
		// TODO Auto-generated method stub
		logger.info("handleRequest被调用");
		model.addAttribute("message", "Hello word");
		return formName;
	}*/
	
	/*@RequestMapping(value="/hello2")
	public String hello(RedirectAttributes at,HttpServletRequest request){
		// TODO Auto-generated method stub
		logger.info("handleRequest被调用");
		String message="hello2";
		String username=request.getParameter("username");
		String userpwd=request.getParameter("userpwd");
		System.out.println(username);
		at.addFlashAttribute("message","hello2");
		return "redirect:/hello3.action";
	}
	
	@RequestMapping(value="/hello4")
	public String hello4(HttpServletRequest request,String action){
		// TODO Auto-generated method stub
		logger.info("handleRequest被调用");
		System.out.println(action);
		Map<String,?> map = RequestContextUtils.getInputFlashMap(request); 
		String mes=map.get("message").toString();
		System.out.println(mes);
		return "index";
	}
	@RequestMapping(value="/hello3")
	public String hello3(HttpServletRequest request,RedirectAttributes at){
		// TODO Auto-generated method stub
		logger.info("handleRequest被调用");
		Map<String,?> map = RequestContextUtils.getInputFlashMap(request); 
		String mes=map.get("message").toString();
		System.out.println(mes);
		return "index";
	}
	@ModelAttribute(value="value")
	@RequestMapping(value="/login1")
	public String userModer(@RequestParam("username") String username,@RequestParam("password") String password,Model model){
		
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		model.addAttribute("user",user);
		list.add(user);
		return "a";
	}*/
	@RequestMapping(value="/register")
	public String register(@RequestParam("username") String username,@RequestParam("password") String password){
		
		User user=new User();
		/*user.setUsername(username);
		user.setPassword(password);*/
		System.out.println(username);
		list.add(user);
		return "login";
	}
	@RequestMapping(value="/login")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password,Model model){
		for(User user:list){
			/*if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
				model.addAttribute("user", user);
				return "welcome";
			}*/
		}
		return "error";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class,new DateEditor());
		
	}
	@RequestMapping(value="/registerform",method=RequestMethod.POST)
	public String registerform(@ModelAttribute Person person,Model model){
		logger.info(person);
		model.addAttribute("person", person);
		System.out.println(person.getBirthday());
		return "welcome";
	}
	/*@RequestMapping(value="/registerform1",method=RequestMethod.GET)
	public String registerform1(Model model){
		Person person=new Person();
		logger.info(person);
		model.addAttribute("person", person);
		return "register";
	}*/
}
