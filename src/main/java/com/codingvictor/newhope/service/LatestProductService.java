package com.codingvictor.newhope.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codingvictor.newhope.common.LatestProductPage;
import com.codingvictor.newhope.dao.LatestProductDao;
import com.codingvictor.newhope.entity.LatestProduct;

@Service
public class LatestProductService {

	@Resource
	LatestProductDao dao;
	
	public void publishLatestProduct(String author, String heading, String content) throws Exception {
        LatestProduct latestProduct = new LatestProduct();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("heading", heading);
		if (dao.getRowCountOfThisHeading(params) > 0) {
	    	throw new Exception("标题重复，请修改为其它标题或者修改已有内容");
	    }
		params.put("content", content);
		if (dao.getRowCountOfThisContent(params) > 0) {
			throw new Exception("内容重复，请修修改已有内容");
		}
		
		LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String publishedDate = now.format(formatter);
	    String modifiedDate = publishedDate;

	    latestProduct.setAuthor(author);
	    latestProduct.setContent(content);
	    latestProduct.setHeading(heading);
	    latestProduct.setPublishedDate(publishedDate);
	    latestProduct.setModifiedDate(modifiedDate);
	    
		dao.insertLatestProduct(latestProduct);
	}
	
	public LatestProductPage getLatestProductiesByPage(short currPage, byte pageSize) {
		LatestProductPage latestProductPage = new LatestProductPage();
		
		latestProductPage.setPageSize(pageSize);
		latestProductPage.setRowCount(dao.getRowCount());
		latestProductPage.setCurrPage(currPage);
		int offset = (currPage - 1) * pageSize;
		int size = pageSize;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("offset", offset);
		params.put("size", size);
		
		List<LatestProduct> latestProducties = dao.selectByParams(params);
		latestProductPage.setData(latestProducties);
		return latestProductPage;
	}
	
	public int getRowCount() {
		return dao.getRowCount();
	}

	public void updateLatestProduct(String author, String heading, String content, int id) throws Exception {
        LatestProduct latestProduct = new LatestProduct();
		
		LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String modifiedDate = now.format(formatter);

	    latestProduct.setId(id);
	    latestProduct.setAuthor(author);
	    latestProduct.setContent(content);
	    latestProduct.setHeading(heading);
	    latestProduct.setModifiedDate(modifiedDate);
	    
		dao.updateLatestProduct(latestProduct);
	}

	public LatestProduct selectLatestProductById(int id) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);
		LatestProduct latestProduct = dao.selectLatestProductById(params);
		return latestProduct;
	}

	public void deleteAnLatestProduct(int id) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		dao.deleteAnLatestProduct(params);
	}
}