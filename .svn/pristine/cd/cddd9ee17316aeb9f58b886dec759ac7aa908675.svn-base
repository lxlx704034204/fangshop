package com.fang.fangshop.core.been;

import com.fang.fangshop.core.cache.RedisCache;
import com.fang.fangshop.core.cache.RedisFieldNotCache;
import com.fang.fangshop.core.cache.RedisQuery;
import com.fang.fangshop.core.common.PageModel;

import java.io.Serializable;
import java.util.Date;

@RedisCache
public class Email extends PageModel implements Serializable{
	@RedisFieldNotCache
	private static final String className = "email";
	@RedisFieldNotCache
	private static final String primaryKey = "id";
	/** t_email.id */
    private Integer id;

    /** t_email.sign */
    private String sign;

    /** t_email.account */
    @RedisQuery
    private String account;

    /** t_email.type */
    private String type;

    /** t_email.url */
    private String url;

    /** t_email.createdate */
    private Date createdate;

    /** t_email.starttime */
    private String starttime;

    /** t_email.endtime */
    private String endtime;

    /** t_email.newEmail */
    private String newemail;

    /** t_email.status */
    private String status;

    /** t_email.sendStatus */
    @RedisQuery
    private String sendstatus;
    @RedisFieldNotCache
    private String notifytemplatename;// 模板名称

	private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public String getNewemail() {
        return newemail;
    }

    public void setNewemail(String newemail) {
        this.newemail = newemail == null ? null : newemail.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSendstatus() {
        return sendstatus;
    }

    public void setSendstatus(String sendstatus) {
        this.sendstatus = sendstatus == null ? null : sendstatus.trim();
    }
    
    public String getNotifytemplatename() {
		return notifytemplatename;
	}

	public void setNotifytemplatename(String notifytemplatename) {
		this.notifytemplatename = notifytemplatename;
	}

	public Email(Integer id, String sign, String account, String type, String url, Date createdate, String starttime,
			String endtime, String newemail, String status, String sendstatus, String notifytemplatename) {
		super();
		this.id = id;
		this.sign = sign;
		this.account = account;
		this.type = type;
		this.url = url;
		this.createdate = createdate;
		this.starttime = starttime;
		this.endtime = endtime;
		this.newemail = newemail;
		this.status = status;
		this.sendstatus = sendstatus;
		this.notifytemplatename = notifytemplatename;
	}
	
	
}
