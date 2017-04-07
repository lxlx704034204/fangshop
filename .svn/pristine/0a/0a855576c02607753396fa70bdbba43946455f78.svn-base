package com.fang.fangshop.web.framework;

import com.fang.fangshop.core.common.PageModel;

/**
 * 返回json格式数据
 * @author wangyantao
 *
 */
public class JsonResult {
	private String message;
	private Object rows;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getRows() {
		return rows;
	}
	public void setRows(PageModel rows) {
		this.rows = rows;
	}
	public JsonResult(String message) {
		super();
		this.message = message;
	}
	public JsonResult(String message, Object rows) {
		super();
		this.message = message;
		this.rows = rows;
	}
}
