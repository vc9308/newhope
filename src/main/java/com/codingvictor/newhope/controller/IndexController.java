package com.codingvictor.newhope.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingvictor.newhope.service.ActivityService;
import com.codingvictor.newhope.service.LatestProductService;

@Controller
public class IndexController {

	@Resource
	ActivityService activityService;
	
	@Resource
	LatestProductService latestProductService;
	

	@RequestMapping({"/index", "/"})
	public String toIndexage(HttpServletRequest request) {
        byte pageSize = 8;
		short currPage = 1;
        
		try {
	        request.setAttribute("ActivityItems",
	        		activityService.getActivitiesByPage(currPage, pageSize));
	        request.setAttribute("LatestProductItems",
	        		latestProductService.getLatestProductiesByPage(currPage, pageSize));
	        return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
		}
	}
}