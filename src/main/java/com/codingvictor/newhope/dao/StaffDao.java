package com.codingvictor.newhope.dao;

import java.util.Map;

import com.codingvictor.newhope.entity.Staff;

public interface StaffDao {
	
	public int getRowCount();

	public int getRowCountByEmailAndAdministrator(String email);

	public Staff selectByEmailandPassword(Map<String, String> params);

}
