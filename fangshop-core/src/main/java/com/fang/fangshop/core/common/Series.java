package com.fang.fangshop.core.common;

import java.util.List;

/**
 * 图表数据
 * 
 * @author wangyantao
 *
 */
public class Series {
	private String name;
	private List<Double> data;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Double> getData() {
		return data;
	}

	public void setData(List<Double> data) {
		this.data = data;
	}

	public Series(String name, List<Double> data) {
		super();
		this.name = name;
		this.data = data;
	}
	
}
