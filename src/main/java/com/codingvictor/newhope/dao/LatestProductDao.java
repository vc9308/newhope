package com.codingvictor.newhope.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codingvictor.newhope.entity.LatestProduct;

@Repository
public interface LatestProductDao {
	
	int getRowCount();

	void insertLatestProduct(LatestProduct latestProduct);
	
	int getRowCountOfThisContent(Map<String, String> params);
	
	int getRowCountOfThisHeading(Map<String, String> params);

	List<LatestProduct> selectByParams(Map<String, Object> params);

	void updateLatestProduct(LatestProduct latestProduct);

	LatestProduct selectLatestProductById(Map<String, Integer> id);
	
	void deleteAnLatestProduct(Map<String, Integer> id);
}