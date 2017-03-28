package com.codingvictor.newhope.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codingvictor.newhope.entity.SuccessfulCase;

@Repository
public interface SuccessfulCaseDao {

	int getRowCount();

	void insertActivity(SuccessfulCase successfulCase);
	
	int getRowCountOfThisContent(Map<String, String> params);
	
	int getRowCountOfThisHeading(Map<String, String> params);

	List<SuccessfulCase> selectByParams(Map<String, Object> params);
}
