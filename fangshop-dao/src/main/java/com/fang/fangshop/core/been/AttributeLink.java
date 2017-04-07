package com.fang.fangshop.core.been;

import com.fang.fangshop.core.common.PageModel;


public class AttributeLink extends PageModel{

	private int id;
	private int attrID;//属性ID
	private int productID;//商品ID
	private String value;//属性值
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAttrID() {
		return attrID;
	}
	public void setAttrID(int attrID) {
		this.attrID = attrID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
