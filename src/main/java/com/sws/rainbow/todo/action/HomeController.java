package com.sws.rainbow.todo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String welcomeHandler() {
		return "welcome";
	}
	
}
