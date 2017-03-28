package com.codingvictor.newhope.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codingvictor.newhope.common.ActivityPage;
import com.codingvictor.newhope.dao.ActivityDao;
import com.codingvictor.newhope.entity.Activity;

@Service
public class ActivityService {
	
	@Resource
	ActivityDao dao;
	
	public void publishActivity(String author, String heading, String content) throws Exception {
		Activity activity = new Activity();
		
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

	    activity.setAuthor(author);
	    activity.setContent(content);
	    activity.setHeading(heading);
	    activity.setPublishedDate(publishedDate);
	    activity.setModifiedDate(modifiedDate);
	    
		dao.insertActivity(activity);
	}
	
	public ActivityPage getActivitiesByPage(short currPage, byte pageSize){
		ActivityPage activityPage = new ActivityPage();
		activityPage.setPageSize(pageSize);
		activityPage.setRowCount(dao.getRowCount());
		activityPage.setCurrPage(currPage);
		int offset = (currPage - 1) * pageSize;
		int size = pageSize;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("offset", offset);
		params.put("size", size);
		
		List<Activity> activities = dao.selectByParams(params);
		activityPage.setData(activities);
		return activityPage;
	}

	public int getRowCount() {
		return dao.getRowCount();
	}

	public void updateActivity(String author, String heading, String content, int id) {
		
	}

	public Activity selectActivityById(int id) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);
		Activity activity = dao.selectActivityById(params);
		return activity;
	}

	public void deleteAnActivity(int id) {
	  Map<String, Integer> params = new HashMap<String, Integer>();
	  dao.deleteAnActivity(params);	
	}
}

/** Test
System.out.println("==========================");
System.out.println("==========================");
System.out.println();
System.out.println();
System.out.println("==========================");
System.out.println("==========================");
*/