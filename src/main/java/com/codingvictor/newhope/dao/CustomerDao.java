package com.codingvictor.newhope.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codingvictor.newhope.entity.Customer;

@Repository
public interface CustomerDao {

	void insert(Customer customer);

	String selectSaltByEmail(String email);

	Customer selectCustomerByEmailAndPassword(Map<String, String> encryptedString);

}
