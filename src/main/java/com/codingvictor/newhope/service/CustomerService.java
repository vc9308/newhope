package com.codingvictor.newhope.service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.codingvictor.newhope.constant.Global;
import com.codingvictor.newhope.dao.CustomerDao;
import com.codingvictor.newhope.entity.Customer;
import com.codingvictor.security.Encryption;
import com.codingvictor.security.Encryption.Algorithms;
import com.google.gson.JsonObject;
import com.codingvictor.security.Salt;

@Service
public class CustomerService {

	@Resource
	CustomerDao dao;
	
	@Resource
	HttpServletRequest request;
	
	public void insert(Customer customer, String password) throws NoSuchAlgorithmException {
		
		// encrypting
		
		String encryptedPassword = new String();
		String salt = Salt.getSalt(4);
		customer.setSalt(salt);
		
		encryptedPassword = Encryption.generate(password + salt, Algorithms.MD5);
		
		customer.setEncryptedPassword(encryptedPassword);
		
		dao.insert(customer);
	}

	public void selectCustomerByEmailAndPassword(String email, String password) throws Exception {
		
		String salt = dao.selectSaltByEmail(email);
		if (salt == null) {
			throw new Exception("用户名错误");
		}
		String encryptedPassword = Encryption.generate(password + salt, Algorithms.MD5);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("email", email);
		params.put("encryptedPassword", encryptedPassword);
		Customer customer = dao.selectCustomerByEmailAndPassword(params);
		if (customer == null) {
			throw new Exception("密码和用户不匹配");
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("email", customer.getEmail());
		json.addProperty("givenName", customer.getGivenName());
		json.addProperty("familyName", customer.getFamilyName());
		
		request.getSession().setAttribute(Global.Customer_SESSION_KEY, json);
	}
	
}
