package com.example.HelloWorldSpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainContrller {
	public ModelAndView index() {
		return new ModelAndView("index");
	}
}
