package com.codingvictor.newhope.common;

import java.util.List;

import com.codingvictor.newhope.entity.Customer;

public class CustomerPage extends Page{
	private List<Customer> data;

	public List<Customer> getData() {
		return data;
	}
	public void setData(List<Customer> data) {
		this.data = data;
	}
}
