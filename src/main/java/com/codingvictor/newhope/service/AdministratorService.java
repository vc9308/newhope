package com.codingvictor.newhope.service;

import javax.servlet.http.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import com.google.gson.JsonObject;

import org.springframework.stereotype.Service;

import com.codingvictor.newhope.constant.Global;
import com.codingvictor.newhope.dao.StaffDao;
import com.codingvictor.newhope.entity.Staff;
import com.codingvictor.security.Encryption;
import com.codingvictor.security.Encryption.Algorithms;

@Service
public class AdministratorService {

	@Resource
	StaffDao dao;
	
	@Resource
	HttpServletRequest request;
	
	public boolean isAdministrator(String email) {
		if (dao.getRowCountByEmailAndAdministrator(email) < 1) {
			return false;
		}
		return true;
	}


	public void validate(String email, String password) throws Exception {

		ResourceBundle bundle = ResourceBundle.getBundle("i18n/messages", new Locale(
				(String)request.getSession().getAttribute("lang"), 
				(String)request.getSession().getAttribute("country")));
		
		String salt = dao.selectSaltByEmail(email);

		String encryptedPassword = Encryption.generate(password + salt, Algorithms.SHA_256);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("email", email);
		params.put("encryptedPassword", encryptedPassword);
		Staff staff = dao.selectStaffByEmailAndEncryptedPassword(params);
		if (staff == null) {
			throw new Exception(bundle.getString("validate.fail"));
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("email", staff.getEmail());
		json.addProperty("givenName", staff.getGivenName());
		json.addProperty("familyName", staff.getFamilyName());
		
		request.getSession().setAttribute(Global.Administrator_SESSION_KEY, json);
	}

}
