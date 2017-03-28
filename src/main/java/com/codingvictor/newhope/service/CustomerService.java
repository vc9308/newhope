package com.codingvictor.newhope.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codingvictor.newhope.dao.CustomerDao;
import com.codingvictor.newhope.entity.Customer;
import com.codingvictor.security.Encryption;
import com.codingvictor.security.Encryption.Algorithms;
import com.codingvictor.security.Salt;

@Service
public class CustomerService {

	@Resource
	CustomerDao dao;
	
	public void insert(Customer customer, String password) throws NoSuchAlgorithmException {
		
		// encrypting
		
		String encryptedString = new String();
		String salt = Salt.getSalt(4);
		customer.setSalt(salt);
		
		encryptedString = Encryption.generate(password + salt, Algorithms.MD5);
		
		customer.setPassword(encryptedString);
		
		
		dao.insert(customer);
	}

}
