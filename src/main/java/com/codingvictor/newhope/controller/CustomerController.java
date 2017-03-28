
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
import com.codingvictor.newhope.entity.Customer;
import com.codingvictor.newhope.service.CustomerService;

@Controller
@SessionAttributes("customer")
@RequestMapping("/customer")
public class CustomerController {
    
	@Resource
	CustomerService service;
	
	@Resource
	HttpServletRequest request;
	
	//insert
	@RequestMapping(value="/register")
	public String toRegisterPage() {
		request.setAttribute("COMPANY_TYPE",
				com.codingvictor.newhope.constant.ParamArray.COMPANY_TYPE);
		return "/customer/register";
	}
	
	@RequestMapping(value="/doRegister")
	public String doRegisterPage(@Valid Customer customer, BindingResult result,
			@RequestParam String confirm, @RequestParam String password) {
		
		String lang = (String)request.getSession().getAttribute("lang");
		
		String country = (String)request.getSession().getAttribute("country");
		
		
		ResourceBundle bundle = ResourceBundle.getBundle("i18n/messages", 
				new Locale(lang, country));

		Enumeration<String> requestParams = request.getParameterNames();
		
		while (requestParams.hasMoreElements()) {
			String requestParam = requestParams.nextElement();
			request.setAttribute(requestParam, request.getParameter(requestParam));
		}
		
		if (request.getAttribute("companyType").equals("100"))
			request.setAttribute("ERR_companyType", bundle.getString("countryType.not.null"));
		
		if (request.getAttribute("gender").equals("4"))
			request.setAttribute("ERR_gender", bundle.getString("gender.not.blank"));
		
		if (request.getAttribute("country").equals("300"))
			request.setAttribute("ERR_country", bundle.getString("country.not.null"));
		
		if (request.getAttribute("province").equals("1000"))
			request.setAttribute("ERR_province", bundle.getString("province.not.null"));
		
		if (confirm == null || confirm.equals("")) 
			request.setAttribute("ERR_confirm", bundle.getString("confirm.not.null"));
		else if (!confirm.equals(password))
			request.setAttribute("ERR_confirm", bundle.getString("confirm.not.same"));
				
		try {
			if (result.hasErrors()) {
				List<FieldError> errors = result.getFieldErrors();
				for (FieldError fieldError : errors) 
					request.setAttribute("ERR_" + fieldError.getField(), fieldError.getDefaultMessage());			
				return "/customer/register";
			}
			else {
				service.insert(customer, password);
				return "/customer/register-complete";
			}
		} catch(Exception e) {
			e.printStackTrace();
			return "/customer/register";
		}
	}
	
	@RequestMapping("/login")
	public String toSignInPage() {
		return "/customer/login";
	}
	
	@RequestMapping("/doLogin")
	public String doSign() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			return "/user/login";
		}
		
		return "/customer/login-complete";
	}
	
	@RequestMapping("/doLogout")
    public String doLoginOut(SessionStatus status) {
    	status.setComplete();
    	request.getSession().setAttribute(Global.Customer_SESSION_KEY, null);
    	return "/customer/login";
	}
}


