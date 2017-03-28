package com.codingvictor.newhope.common;

import java.util.List;

import com.codingvictor.newhope.entity.SuccessfulCase;

public class SuccessfulCasePage extends Page {

	private List<SuccessfulCase> data;
	
	public List<SuccessfulCase> getData() {
		return data;
	}
	public void setData(List<SuccessfulCase> data) {
		this.data = data;
	}
}
