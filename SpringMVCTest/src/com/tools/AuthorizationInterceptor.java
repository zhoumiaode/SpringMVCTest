package com.tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vo.Child;

public class AuthorizationInterceptor implements HandlerInterceptor {

	private static final String[] IGNORE_URL={"/child/login","/childlogin","/insert"};
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AuthorizationInterceptor afterCompletion");

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AuthorizationInterceptor postHandle");

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AuthorizationInterceptor preHandle");
		boolean flag=false;
		String path=request.getServletPath();
		System.out.println("1"+path);
		for(String s:IGNORE_URL){
			if(path.contains(s)){
				flag=true;
				break;
			}
		}
		if(!flag){
			Child child=(Child) request.getSession().getAttribute("child");
			if(child==null){
				System.out.println("AuthorizationInterceptor拦截请求");
				request.setAttribute("message","请先登录再访问");
				
				request.getRequestDispatcher("/childlogin.jsp").forward(request, response);
			}else{
				System.out.println("AuthorizationInterceptor放行通过");
				flag=true;
			}
			
		}
		return flag;
	}

}
