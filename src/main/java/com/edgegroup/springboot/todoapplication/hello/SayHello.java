package com.edgegroup.springboot.todoapplication.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHello {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello Spring Boot web";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHTML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My first HTML page with SpringBoot</title>");
		sb.append("</head>");
		sb.append("<body>My first HTML page with SpringBoot</body>");
		sb.append("</html>");
		return sb.toString();
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
		}
}
