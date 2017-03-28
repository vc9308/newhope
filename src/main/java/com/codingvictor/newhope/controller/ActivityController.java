package com.codingvictor.newhope.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingvictor.newhope.entity.Activity;
import com.codingvictor.newhope.service.ActivityService;

@Controller
@RequestMapping("/activities")
public class ActivityController {

	@Resource
	ActivityService service;

	//select
	@RequestMapping("/more")
	public String toMorePage(HttpServletRequest request) {

        String currPageStr = (String)request.getAttribute("page");
        
        short currPage = 1;
        byte pageSize = 50;
        
        try {
        	if (currPageStr != null) {
        		currPage = Short.parseShort(currPageStr);
            } else {
            	currPage = 1;
            }
            request.setAttribute("ActivityItems", service.getActivitiesByPage(currPage, pageSize));
            return ("./activities/more");
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}
		
	}

	//insert
	@RequestMapping("/publish")
	public String toPublishPage() {
		return "activities/publish";
	}

	@RequestMapping("/doPublish")
	public String doPublish(@RequestParam String author, 
			@RequestParam String heading, @RequestParam String content, 
			HttpServletRequest request) {
		try {
			service.publishActivity(author, heading, content);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			request.setAttribute("author", author);
			request.setAttribute("heading", heading);
			request.setAttribute("content", content);
			return "./activities/publish";
		}

		return "./activities/publish-complete";
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
            request.setAttribute("ActivityItems",
            		service.getActivitiesByPage(currPage, pageSize));
		    return "activities/all";
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
			Activity activity = service.selectActivityById(id);
			request.setAttribute("author", activity.getAuthor());
			request.setAttribute("heading", activity.getHeading());
			request.setAttribute("content", activity.getContent());
			request.setAttribute("id", idStr);
		} catch(Exception e) {
		    e.printStackTrace();
		}
		return "activities/update";
	}
	
	@RequestMapping("/doUpdate")
	public String doUpdate(@RequestParam String author, 
			@RequestParam String heading, @RequestParam String content, 
			@RequestParam int id, HttpServletRequest request) {
		try {
			service.updateActivity(author, heading, content, id);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			request.setAttribute("author", author);
			request.setAttribute("heading", heading);
			request.setAttribute("content", content);
			return "./activities/update";
		}
		return "./activities/update-complete";
	}
	
	//delete
	@RequestMapping("/doDelete")
	public String doDelete(@RequestParam int id) {
		try {
			service.deleteAnActivity(id);
			return "/activities/delete-ecomplete";
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}
	}
}