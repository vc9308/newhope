package com.codingvictor.newhope.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codingvictor.newhope.dao.StaffDao;
import com.codingvictor.newhope.entity.Staff;

@Service
public class AdministratorService {

	@Resource
	StaffDao dao;
	
	public boolean isAdministrator(String email) {
		if (dao.getRowCountByEmailAndAdministrator(email) < 1) {
			return false;
		}
		return true;
	}


	public Staff validate(String email, String password) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("email", "email");
		params.put("password", password);
		Staff staff = dao.selectByEmailandPassword(params);
		return staff;
	}

}
