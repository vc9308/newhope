package com.codingvictor.newhope.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/successful-cases")
public class SucessfulCaseController {
	@RequestMapping("/more")
	public String toMorePage() {
		return "/successful-cases/more";
	}
}
