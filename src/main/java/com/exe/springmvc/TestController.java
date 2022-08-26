package com.exe.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("test.controller")
public class TestController {
	/*
	@RequestMapping(value = "/test/param.action",method = RequestMethod.GET)
	public String processGetRequest() {

		System.out.println("Get방식의 Request이다.");

		return "paramResult";
	}

	@RequestMapping(value = "/test/param.action",method = RequestMethod.POST)
	public String processPostRequest() {

		System.out.println("Post방식의 Request이다.");

		return "paramResult";


	}
	*/
	
	/**get, post방식이 한번에 오도록 하는 코드*/
	@RequestMapping(value = "/test/param.action", 
			method = {RequestMethod.GET,RequestMethod.POST}) 
	public String processRequest(PersonDTO dto, 
			String name, HttpServletRequest request) {
		
		System.out.println("Get/Post방식의 Request이다.");
		
		System.out.println(name);
		System.out.println(request.getParameter("phone"));
		
		System.out.println(dto);
		System.out.println("name : " + dto.getName());
		System.out.println("phone : " + dto.getPhone());
		System.out.println("email : " + dto.getEmail());
		
		return "paramResult";
	}
	
	@RequestMapping(value = "/test/mav.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView mavRequest(PersonDTO dto) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("dto",dto);
		mav.setViewName("paramResult");
		
		return mav;
	}
	
	@RequestMapping(value = "/test/redirect.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String mavRedirectRequest() {
		
		// return "redirect:/"; -> 메인으로 가고 싶을 때
		// return "redirect:/hello.action";와 return "hello";는 다르다.
		// redirect는 action을 찾아간것이고 hello는 .jsp파일을 찾아가는 것임.
		return "redirect:/hello.action";
		//return "hello";
	}
}
