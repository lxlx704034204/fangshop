package com.fang.fangshop.core.been;

import com.fang.fangshop.core.cache.RedisCache;
import com.fang.fangshop.core.cache.RedisFieldNotCache;
import com.fang.fangshop.core.common.PageModel;

import java.io.Serializable;

@RedisCache
public class Oss extends PageModel implements Serializable {
	@RedisFieldNotCache
	private static final String className = "oss";
	@RedisFieldNotCache
	private static final String primaryKey = "id";
	
    /** t_oss.id */
    private Integer id;

    /** t_oss.name */
    private String name;

    /** t_oss.code */
    private String code;

    /** t_oss.status */
    private String status;

    /** t_oss.ossJsonInfo */
    private String ossjsoninfo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOssjsoninfo() {
        return ossjsoninfo;
    }

    public void setOssjsoninfo(String ossjsoninfo) {
        this.ossjsoninfo = ossjsoninfo == null ? null : ossjsoninfo.trim();
    }

	public Oss(Integer id, String name, String code, String status, String ossjsoninfo) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.status = status;
		this.ossjsoninfo = ossjsoninfo;
	}

	public Oss() {
		super();
	}
    
}