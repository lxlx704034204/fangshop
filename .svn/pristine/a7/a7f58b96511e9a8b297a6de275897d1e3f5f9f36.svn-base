package com.fang.fangshop.core.been;

import com.fang.fangshop.core.common.PageModel;

import java.io.Serializable;
import java.util.List;


/**
 * 商品类别
 * @author hmx
 *
 */
public class Catalog extends PageModel implements Serializable{

	private int id;
	private String name;//商品类别名称
	private int pid;//父类名称
	private int order1;//序号
	private String type;
	private String code;//商品类别的代码
	private String showinnav;//是否在导航栏显示（y:是，n:否）
	
	private List<Catalog> children;//子类别
	
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
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getOrder() {
		return order1;
	}
	public void setOrder(int order) {
		this.order1 = order;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getShowinnav() {
		return showinnav;
	}
	public void setShowinnav(String showinnav) {
		this.showinnav = showinnav;
	}
	public Catalog(){
		
	}
	
	public Catalog(int id, String name, int pid, int order1, String type, String code, String showinnav,
			List<Catalog> children) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.order1 = order1;
		this.type = type;
		this.code = code;
		this.showinnav = showinnav;
		this.children = children;
	}
	public List<Catalog> getChildren() {
		return children;
	}
	public void setChildren(List<Catalog> children) {
		this.children = children;
	}
	
	
}
