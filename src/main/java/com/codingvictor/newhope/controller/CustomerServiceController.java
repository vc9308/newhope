package com.codingvictor.newhope.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer-service")
public class CustomerServiceController {

	@Resource
	HttpServletRequest request;
	
	@RequestMapping("server")
	private String toServerPage() {
		return "/customer-service/server";
	}
	
	@RequestMapping("client")
	private String toClientPage() {
		return "/customer-service/client";
	}
}
