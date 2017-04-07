package com.fang.fangshop.core.been;

public class Attribute {

	private int id;
	
	private String name;//属性名
	
	private int catalogID;//商品类别ID
	
	private int pid;//父类属性ID（上级属性ID）
	
	private int order;//顺序序号（todo:目前还不清楚实际意义）
	
	private AttributeLink linkValue;//属性值

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCatalogID() {
		return catalogID;
	}

	public void setCatalogID(int catalogID) {
		this.catalogID = catalogID;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public AttributeLink getLinkValue() {
		return linkValue;
	}

	public void setLinkValue(AttributeLink linkValue) {
		this.linkValue = linkValue;
	}
	
	
}
