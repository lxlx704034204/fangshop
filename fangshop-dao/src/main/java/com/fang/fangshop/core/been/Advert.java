package com.fang.fangshop.core.been;

import com.fang.fangshop.core.cache.RedisCache;
import com.fang.fangshop.core.cache.RedisFieldNotCache;
import com.fang.fangshop.core.cache.RedisQuery;
import com.fang.fangshop.core.common.PageModel;

import java.io.Serializable;
import java.util.Date;

@RedisCache
public class Advert extends PageModel implements Serializable {
	@RedisFieldNotCache
	private static final String className = "advert";
	@RedisFieldNotCache
	private static final String primaryKey = "id";
	
	/** t_advert.id */
    private Integer id;

    /** t_advert.title */
    @RedisQuery
    private String title;

    /** t_advert.code */
    @RedisQuery
    private String code;

    /** t_advert.remark */
    private String remark;

    /** t_advert.html */
    private String html;

    /** t_advert.startdate */
    private Date startdate;

    /** t_advert.enddate */
    private Date enddate;

    /** t_advert.status */
    private String status;

    /** t_advert.useImagesRandom */
    private String useimagesrandom;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUseimagesrandom() {
        return useimagesrandom;
    }

    public void setUseimagesrandom(String useimagesrandom) {
        this.useimagesrandom = useimagesrandom == null ? null : useimagesrandom.trim();
    }

	public Advert() {
		super();
	}

	public Advert(Integer id, String title, String code, String remark, String html, Date startdate, Date enddate,
			String status, String useimagesrandom) {
		super();
		this.id = id;
		this.title = title;
		this.code = code;
		this.remark = remark;
		this.html = html;
		this.startdate = startdate;
		this.enddate = enddate;
		this.status = status;
		this.useimagesrandom = useimagesrandom;
	}
}
