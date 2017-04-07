package com.fang.fangshop.core.common;

import java.util.*;

public class Chart {
	private List<String> X;
	private List<Series> Y;
	public List<String> getX() {
		return X;
	}
	public void setX(List<String> x) {
		X = x;
	}
	public List<Series> getY() {
		return Y;
	}
	public void setY(List<Series> y) {
		Y = y;
	}
}
