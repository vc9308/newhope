package com.codingvictor.newhope.common;

import java.util.List;

import com.codingvictor.newhope.entity.Activity;

public class ActivityPage extends Page {
	
	private List<Activity> data;
	
	public List<Activity> getData() {
		return data;
	}
	public void setData(List<Activity> data) {
		this.data = data;
	}
	
}
