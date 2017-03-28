package com.codingvictor.newhope.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codingvictor.newhope.dao.StaffDao;

@Service
public class StaffService {

	@Resource
	StaffDao dao;
}
