package com.codingvictor.newhope.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service")
public class ServiceContraller {
	
	@RequestMapping("/{item}")
	public String toEachPage(@PathVariable("item") String item) {
		return "/service/" + item;
	}
}
