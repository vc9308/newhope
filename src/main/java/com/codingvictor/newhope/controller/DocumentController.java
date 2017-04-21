package com.codingvictor.newhope.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocumentController {
    
	@RequestMapping("/documents")
	public String toDocumentPage() {
		return "/documents";
	}
}
