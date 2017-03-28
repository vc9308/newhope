package com.codingvictor.newhope.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codingvictor.newhope.constant.Global;
import com.codingvictor.newhope.entity.Staff;
import com.codingvictor.newhope.service.AdministratorService;

@Controller
@RequestMapping("/administrator")
@SessionAttributes("administrator")
public class AdministratorController {

	@Resource
	AdministratorService service;
	
	//insert
	@RequestMapping("login")
	public String toLoginPage() {
		return "./administrator/login";
	}
	
	@RequestMapping("/doLogin")
	public String doRegister(@RequestParam String email,
			@RequestParam String password, HttpServletRequest request) {
		try {
			Staff staff = new Staff();
			request.setAttribute("email", email);
			if (email == null || email.length() == 0) {
				request.setAttribute("ERR_email", "请输入邮箱地址");
				return "/administrator/login";
			}
			if (password == null || password.length() == 0) {
				request.setAttribute("ERR_password", "");
				return "/administrator/login";
			}
			
			if(!service.isAdministrator(email)) {
				request.setAttribute("ERR_email", "帐号不是管理员");
				return "/administrator/login";
			}
			else if((staff = service.validate(email, password)) == null) {
				request.setAttribute("ERR_password", "密码错误");
				return "/administrator/login";
			}
			request.getSession().setAttribute(Global.Administrator_SESSION_KEY,
					staff.getFamilyName() + staff.getGivenName());		
			return "/administrator/login-complete"; 
		} catch(Exception e) {
			e.printStackTrace();
			return "/administrator/login";
		}
	}
	
	
}



