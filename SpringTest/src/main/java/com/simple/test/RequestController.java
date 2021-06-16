package com.simple.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/request")
public class RequestController {

	@RequestMapping("/req_ex01")
	public String req_ex01() {
		
		return "request/req_ex01";
	}
	
}
