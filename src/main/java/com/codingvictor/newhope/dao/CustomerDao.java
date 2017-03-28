package com.codingvictor.newhope.dao;

import org.springframework.stereotype.Repository;

import com.codingvictor.newhope.entity.Customer;

@Repository
public interface CustomerDao {

	void insert(Customer customer);

}
