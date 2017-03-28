package com.codingvictor.newhope.common;

import java.util.List;

import com.codingvictor.newhope.entity.Staff;

public class StaffPage extends Page {

	private List<Staff> data;

	public List<Staff> getData() {
		return data;
	}
	public void setData(List<Staff> data) {
		this.data = data;
	}
}
