package com.codingvictor.newhope.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingvictor.newhope.entity.LatestProduct;
import com.codingvictor.newhope.service.LatestProductService;

@Controller
@RequestMapping("/latest-products")
public class LatestProductController {
	@Resource
	LatestProductService service;
    
	//select
	@RequestMapping("/more")
	public String toMorePage(HttpServletRequest request) {

        String currPageStr = (String)request.getParameter("page");
        
        short currPage = 1;
        byte pageSize = 50;
        
        try {
        	if (currPageStr != null) {
        		currPage = Short.parseShort(currPageStr);
            } else {
            	currPage = 1;
            }
            request.setAttribute("LatestProductItems",
            		service.getLatestProductiesByPage(currPage, pageSize));
            return ("./latest-products/more");
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}
	}

	//insert
	@RequestMapping("/publish")
	public String toPublishPage() {
		return "latest-products/publish";
	}

	@RequestMapping("/doPublish")
	public String doPublish(@RequestParam String author, 
			@RequestParam String heading, @RequestParam String content, 
			HttpServletRequest request) {
		try {
			service.publishLatestProduct(author, heading, content);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			request.setAttribute("author", author);
			request.setAttribute("heading", heading);
			request.setAttribute("content", content);
			return "./latest-products/publish";
		}

		return "./latest-products/publish-complete";
	}
	
	//update
	@RequestMapping("/all")
	public String toAllPage(HttpServletRequest request) {
        String currPageStr = (String) request.getParameter("page");
        
        short currPage = 1;
        byte pageSize = 50;
        
        try {
        	if (currPageStr != null) {
        		currPage = Short.parseShort(currPageStr);
            } else {
            	currPage = 1;
            }
            request.setAttribute("LatestProductItems",
            		service.getLatestProductiesByPage(currPage, pageSize));
		    return "latest-products/all";
        } catch (Exception e) {
        	e.printStackTrace();
        	return "index";
        }
	}
	
	@RequestMapping("/update")
	public String toUpdatePage(
			HttpServletRequest request) {
		String idStr = (String) request.getParameter("id");
		try {
			int id = Integer.parseInt(idStr);
			LatestProduct product = service.selectLatestProductById(id);
			System.out.println(product.getAuthor());
			request.setAttribute("author", product.getAuthor());
			request.setAttribute("heading", product.getHeading());
			request.setAttribute("content", product.getContent());
			request.setAttribute("id", idStr);
		} catch(Exception e) {
		    e.printStackTrace();
		}
		return "./latest-products/update";
	}
	
	@RequestMapping("/doUpdate")
	public String doUpdate(@RequestParam String author, 
			@RequestParam String heading, @RequestParam String content, 
			@RequestParam int id, HttpServletRequest request) {
		try {
			service.updateLatestProduct(author, heading, content, id);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			request.setAttribute("author", author);
			request.setAttribute("heading", heading);
			request.setAttribute("content", content);
			return "./latest-products/update";
		}
		return "./latest-products/update-complete";
	}
	
	//delete
	@RequestMapping("/doDelete")
	public String doDelete(@RequestParam int id) {
		try {
		    service.deleteAnLatestProduct(id);
		    return "./latest-products/delete-complete";
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}
	}
}

