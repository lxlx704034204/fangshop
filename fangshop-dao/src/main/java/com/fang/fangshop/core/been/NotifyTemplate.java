package com.fang.fangshop.core.been;

import com.fang.fangshop.core.cache.RedisCache;
import com.fang.fangshop.core.cache.RedisFieldNotCache;
import com.fang.fangshop.core.cache.RedisQuery;
import com.fang.fangshop.core.common.PageModel;

import java.io.Serializable;

@RedisCache
public class NotifyTemplate extends PageModel implements Serializable {
	@RedisFieldNotCache
	private static final String className = "notifytemplate";
	@RedisFieldNotCache
	private static final String primaryKey = "id";
    /** t_notifytemplate.id */
    private Integer id;

    /** t_notifytemplate.type */
    @RedisQuery
    private String type;

    /** t_notifytemplate.code */
    @RedisQuery
    private String code;

    /** t_notifytemplate.remark */
    private String remark;

    /** t_notifytemplate.name */
    @RedisQuery
    private String name;

    /** t_notifytemplate.template */
    private String template;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template == null ? null : template.trim();
    }

	public NotifyTemplate(Integer id, String type, String code, String remark, String name, String template) {
		super();
		this.id = id;
		this.type = type;
		this.code = code;
		this.remark = remark;
		this.name = name;
		this.template = template;
	}

	public NotifyTemplate() {
		super();
	}
    
}
