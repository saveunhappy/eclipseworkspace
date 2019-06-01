package com.mypack.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("hello.......");
		ModelAndView mv = new ModelAndView();
		//璁剧疆瑙嗗浘鍚嶇О
		mv.setViewName("/WEB-INF/views/welcome.jsp");
		//璁剧疆鍏变韩鏁版嵁
		mv.addObject("msg", "hello,SpringMVC");
		return mv;
	}

}