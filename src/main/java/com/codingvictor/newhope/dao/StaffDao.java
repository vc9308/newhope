package com.codingvictor.newhope.dao;

import java.util.Map;

import com.codingvictor.newhope.entity.Staff;

public interface StaffDao {

	public void insert(Staff staff);

	public String selectSaltByEmail(String email);

	public Staff selectStaffByEmailAndEncryptedPassword(Map<String, String> params);

	public int getRowCountByEmailAndAdministrator(String email);

	public Staff selectByEmailandPassword(Map<String, String> params);

}
