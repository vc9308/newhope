package com.codingvictor.newhope.common;

import java.util.List;

import com.codingvictor.newhope.entity.LatestProduct;

public class LatestProductPage extends Page {

	private List<LatestProduct> data;
	
	public List<LatestProduct> getData() {
		return data;
	}
	public void setData(List<LatestProduct> data) {
		this.data = data;
	}
}
