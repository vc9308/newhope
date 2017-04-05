package com.codingvictor.newhope.service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.codingvictor.newhope.constant.Global;
import com.codingvictor.newhope.dao.StaffDao;
import com.codingvictor.newhope.entity.Staff;
import com.codingvictor.security.Encryption;
import com.codingvictor.security.Salt;
import com.codingvictor.security.Encryption.Algorithms;
import com.google.gson.JsonObject;

@Service
public class StaffService {

	@Resource
	StaffDao dao;
	
	@Resource
	HttpServletRequest request;

	public void insert(Staff staff, String password) throws NoSuchAlgorithmException {
		
		// encrypting
		
				String encryptedPassword = new String();
				String salt = Salt.getSalt(8);
				staff.setSalt(salt);
				
				encryptedPassword = Encryption.generate(password + salt, Algorithms.SHA_256);
				
				staff.setEncryptedPassword(encryptedPassword);
				
				dao.insert(staff);
	}

	public void selectStaffByEmailAndEncryptedPassword(String email, String password) throws Exception {
		
		String salt = dao.selectSaltByEmail(email);
		if (salt == null) {
			throw new Exception("用户名错误");
		}
		String encryptedPassword = Encryption.generate(password + salt, Algorithms.SHA_256);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("email", email);
		params.put("encryptedPassword", encryptedPassword);
		
		Staff staff = dao.selectStaffByEmailAndEncryptedPassword(params);
		if (staff == null) {
			throw new Exception("密码和用户不匹配");
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("email", staff.getEmail());
		json.addProperty("givenName", staff.getGivenName());
		json.addProperty("familyName", staff.getFamilyName());
		
		request.getSession().setAttribute(Global.Staff_SESSION_KEY, json);
		
	}
}
