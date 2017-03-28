package com.codingvictor.newhope.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.codingvictor.newhope.constant.Global;
import com.codingvictor.newhope.entity.Staff;
import com.codingvictor.newhope.service.StaffService;

@Controller
@SessionAttributes("staff")
@RequestMapping("/staff")
public class StaffController {
    
	@Resource
	StaffService service;
	
	@Resource
	HttpServletRequest request;
	
	@RequestMapping(value="/register")
	public String toRegisterPage() {
		return "/register";
	}
	
	@RequestMapping(value="/doRegister")
	public String doRegisterPage(@Valid Staff staff, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<FieldError> errors = result.getFieldErrors();
				for (FieldError fieldError : errors) {
					request.setAttribute("ERR_" + fieldError.getField(), fieldError.getDefaultMessage());
					return "/register";
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return "/staff/register";
		}
		return "/register-complete";
	}
	
	@RequestMapping("/login")
	public String toSignInPage() {
		return "/login";
	}
	
	@RequestMapping("/doLogin")
	public String doSign(@RequestParam String email, @RequestParam String password) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			return "/login";
		}
		
		return "/staff/login-complete";
	}
	
	@RequestMapping("/doLogout")
    public String doLoginOut(SessionStatus status) {
    	status.setComplete();
    	request.getSession().setAttribute(Global.Staff_SESSION_KEY, null);
    	return "index";
	}
}


