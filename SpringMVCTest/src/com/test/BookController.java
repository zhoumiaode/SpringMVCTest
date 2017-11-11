package com.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vo.Book;

@Controller
@RequestMapping(value="book")
public class BookController {
	
	@RequestMapping(value="main")
	public String main(Model model){
		
		List<Book> list=new ArrayList<Book>();
		list.add(new Book("1","1.jpg","1"));
		list.add(new Book("2","2.PNG","2"));
		list.add(new Book("3","4.PNG","3"));
		model.addAttribute("list", list);
		model.addAttribute("message", "ÄãºÃ");
		return "main";
		
	}

}
