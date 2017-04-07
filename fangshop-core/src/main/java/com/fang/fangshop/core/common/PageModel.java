package com.fang.fangshop.core.common;

import com.fang.fangshop.core.cache.RedisFieldNotCache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 分页模型，也是所有实体类的基类
 * @author wangyantao
 *
 */
public class PageModel implements ClearBean {
	@RedisFieldNotCache
	private Integer total;//总数
	@RedisFieldNotCache
	private List list = new ArrayList();//分页集合
	@RedisFieldNotCache
	private Integer pageSize = ManageContainer.PAGE_SIZE;//每页显示的记录条数
	@RedisFieldNotCache
	private Integer offset;//偏移量
	@RedisFieldNotCache
	private Integer pagerSize;//总页数
	@RedisFieldNotCache
	private String message;//返回信息
	@RedisFieldNotCache
	protected String pageUrl;//分页标签需要访问的ACTION地址
	//private String id;
	@RedisFieldNotCache
	private Integer recordsTotal;
	@RedisFieldNotCache
	private int recordsFiltered;
	@RedisFieldNotCache
	private int draw;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List getList() {
		return list==null?new LinkedList():list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getPagerSize() {
		return pagerSize;
	}
	public void setPagerSize(Integer pagerSize) {
		this.pagerSize = pagerSize;
	}
	public Integer getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
	
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}

	public void clear() {
		total = 0; // 总数
		list = null; // 分页集合列表
	}
	
	public String trim(String str){
		if(str==null){
			return null;
		}
		else{
			return str.trim();
		}
	}
	
	public void clearList(List<String> list){
		if(list==null || list.size()==0){
			return;
		}
		list.clear();
		list = null;
	}
	
	public void clearSet(Set<String> set) {
		if(set==null || set.size()==0)
		{
			return;
		}
		set.clear();
		set = null;
	}
	
	public void clearListBean(List<PageModel> list){
		if(list == null || list.size()==0)
		{
			return;
		}
		for(int i = 0; i<list.size();i++)
		{
			ClearBean clearBean = list.get(i);
			clearBean.clear();
			clearBean=null;
		}
		list.clear();
		list = null;
	}
	
	public void clearArray(String[] str){
		if(str==null || str.length==0)
		{
			return;
		}
		for(int i = 0; i< str.length;i++)
		{
			str[i] = null;
		}
		str = null;
	}

	public String toString() {
		return "PageModel [total=" + total + ", list=" + list + ", offset=" + offset + "]";
	}
}
