package com.codingvictor.newhope.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class footerController {
	@RequestMapping("/team")
	public String toTeamPage() {
		return "/team";
	}
	
	@RequestMapping("/sponsor")
	String toSponsorPage() {
		return "/sponsor";
	}
	
	@RequestMapping("/employ")
	String toEmolyeePage() {
		return "/employ";
	}
	
	@RequestMapping("/faqs")
	String toFaqsPage() {
		return "faqs";
	}
	
	@RequestMapping("/privacyPolicy")
	String toPrivacyPolicyPage() {
		return "/privacyPolicy";
	}
	
	@RequestMapping("/itemofuse")
	String toItemofusePage() {
		return "/itemofuse";
	}

}
