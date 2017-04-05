package com.codingvictor.newhope.controller;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.codingvictor.newhope.constant.Global;
import com.codingvictor.newhope.service.AdministratorService;

@Controller
@RequestMapping("/administrator")
@SessionAttributes("administrator")
public class AdministratorController {

	@Resource
	AdministratorService service;
	
	@Resource
	HttpServletRequest request;
	
	//insert
	@RequestMapping("login")
	public String toLoginPage() {
		return "./administrator/login";
	}
	
	@RequestMapping("/doLogin")
	public String doRegister(@RequestParam String email,
			@RequestParam String password, HttpServletRequest request) {
		
		ResourceBundle bundle = ResourceBundle.getBundle("i18n/messages", new Locale(
				(String)request.getSession().getAttribute("lang"), 
				(String)request.getSession().getAttribute("country")));
		
		try {
			request.setAttribute("email", email);
			if (email == null || email.length() == 0) {
				request.setAttribute("error", bundle.getString("email.not.blank"));
				return "/administrator/login";
			}
			if (password == null || password.length() == 0) {
				request.setAttribute("error", bundle.getString("password.not.blank"));
				return "/administrator/login";
			}
			
			if(!service.isAdministrator(email)) {
				request.setAttribute("error", new String(bundle.getString("not.administrator")
						.getBytes("ISO-8859-1"),"utf-8"));
				return "/administrator/login";
			}
			service.validate(email, password);
			return "/administrator/login-complete"; 
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			return "/administrator/login";
		}
	}
	
	@RequestMapping("/home")
	public String toHomePage() {
		if (request.getSession().getAttribute(Global.Administrator_SESSION_KEY) != null)
		    return "/administrator/home";
		else
		    return "redirect:/administrator/login";
	}
	
	@RequestMapping("/doLogout")
    public String doLoginOut(SessionStatus status) {
    	status.setComplete();
    	request.getSession().setAttribute(Global.Administrator_SESSION_KEY, null);
    	return "redirect:/";
	}
	
}



