package com.codingvictor.newhope.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
	
	@RequestMapping("/contacts")
	public String toContactsPage() { 
        return "/contacts";
	}
}
