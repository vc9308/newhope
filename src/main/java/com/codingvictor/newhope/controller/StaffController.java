package com.codingvictor.newhope.controller;

import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

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
	HttpServletRequest request;
	
	@Resource
	StaffService service;
	
	
	@RequestMapping("/register")
	public String toRegisterPage() {
		return "/staff/register";
	}
	
	@RequestMapping(value="/doRegister")
	public String doRegisterPage(@Valid Staff staff, BindingResult result,
			@RequestParam String confirm, @RequestParam String password) {
		
		ResourceBundle bundle = ResourceBundle.getBundle("i18n/messages", new Locale(
				(String)request.getSession().getAttribute("lang"), 
				(String)request.getSession().getAttribute("country")));

		Enumeration<String> requestParams = request.getParameterNames();
		
		while (requestParams.hasMoreElements()) {
			String requestParam = requestParams.nextElement();
			System.out.println(requestParam);
			System.out.println(request.getParameter(requestParam));
			if (!requestParam.equals("birthdate") || !requestParam.equals("hiredate")) {
			    request.setAttribute(requestParam, request.getParameter(requestParam));
			}
		}
		
		
		if (request.getAttribute("gender").equals("4"))
			request.setAttribute("ERR_gender", bundle.getString("gender.not.blank"));
		
		if (request.getAttribute("country").equals("300"))
			request.setAttribute("ERR_country", bundle.getString("country.not.null"));
		
		if (request.getAttribute("province").equals("1000"))
			request.setAttribute("ERR_province", bundle.getString("province.not.null"));
		
		if (request.getAttribute("job").equals("100"))
			request.setAttribute("ERR_job", bundle.getString("job.not.null"));
		
		if (request.getAttribute("department").equals("100"))
			request.setAttribute("ERR_department", bundle.getString("department.not.null"));

		if (request.getAttribute("birthdate") == null || request.getAttribute("birthdate").equals("")) {
			request.setAttribute("ERR_birthdate", bundle.getString("birthdate.not.blank"));
		}
		
		if (request.getAttribute("hiredate") == null || request.getAttribute("hiredate").equals("")) {
			request.setAttribute("ERR_hiredate", bundle.getString("hiredate.not.blank"));
		}
		
		if (confirm == null || confirm.equals("")) 
			request.setAttribute("ERR_confirm", bundle.getString("confirm.not.null"));
		else if (!confirm.equals(password))
			request.setAttribute("ERR_confirm", bundle.getString("confirm.not.same"));
				
		try {
			if (result.hasErrors()) {
				List<FieldError> errors = result.getFieldErrors();
				for (FieldError fieldError : errors) 
					request.setAttribute("ERR_" + fieldError.getField(), fieldError.getDefaultMessage());			
				return "/staff/register";
			}
			else {
				service.insert(staff, password);
				return "/staff/register-complete";
			}
		} catch(Exception e) {
			e.printStackTrace();
			return "/staff/register";
		}
	}
	
	//select
	@RequestMapping("/login")
	public String toSignInPage() {
		return "/staff/login";
	}
	
	@RequestMapping("/doLogin")
	public String doSign(@RequestParam String email, @RequestParam String password) {
		try {
			service.selectStaffByEmailAndEncryptedPassword(email, password);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			return "/staff/login";
		}
		
		return "/staff/login-complete";
	}
	
	@RequestMapping("/home")
	public String toHomePage() {
		if (request.getSession().getAttribute(Global.Staff_SESSION_KEY) != null)
		    return "/staff/home";
		else
		    return "redirect:/staff/login";
	}
	
	@RequestMapping("/doLogout")
    public String doLoginOut(SessionStatus status) {
    	status.setComplete();
    	request.getSession().setAttribute(Global.Staff_SESSION_KEY, null);
    	return "redirect:/";
	}
}


