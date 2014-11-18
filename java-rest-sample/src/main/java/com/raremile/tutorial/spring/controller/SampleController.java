package com.raremile.tutorial.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SampleController {
static{
	System.out.println("Controller loaded");
}
@RequestMapping(value="/sample",method=RequestMethod.GET)
public String myMethod(Model model){
	System.out.println("My method-url handler"
			+ " invoked!!");
	
	model.addAttribute("message","My First Spring Mvc Project");
	model.addAttribute("message1",null);
	
	return "sample";
}

@RequestMapping(value="/samplePost/{userID}/address",method=RequestMethod.POST)
public String myMethodPost(Model model,@RequestParam String message,
		@PathVariable int userID){
	System.out.println("My method-url handler"
			+ " invoked!!");
	
	model.addAttribute("message",message);
	model.addAttribute("userid",userID);
	
	return "sample";
}

@RequestMapping(value="/sampleJson",method=RequestMethod.GET)
@ResponseBody
public String myMethodJson(Model model){
	System.out.println("My method-url handler"
			+ " invoked!!");
	//user/1/address
	model.addAttribute("message","My First Spring Mvc Project");
	model.addAttribute("message1",null);
	
	return "{\"name\" : \"Raremile\"}";
}


}
