package com.edgegroup.springboot.todoapplication.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	

	@RequestMapping("")
	public String welcomeJsp() {
		return "welcome";
	}
}
