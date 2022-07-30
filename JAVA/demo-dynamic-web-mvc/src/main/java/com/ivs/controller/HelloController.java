package com.ivs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ivs.model.Hello;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String hello(Model model) {
		Hello hello = new Hello();
		hello.setSaySomeThing("IVS xin chào!");
		
		model.addAttribute("hello", hello);
		return "hello";
	}
}
