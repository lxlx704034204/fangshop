package com.fang.fangshop.been;

import java.io.Serializable;
import java.util.Date;

public class OrderLog implements Serializable {
    /** t_orderlog.id */
    private Integer id;

    /** t_orderlog.orderid */
    private String orderid;

    /** t_orderlog.account */
    private String account;

    /** t_orderlog.createdate */
    private Date createdate;

    /** t_orderlog.content */
    private String content;

    /** t_orderlog.accountType */
    private String accounttype;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype == null ? null : accounttype.trim();
    }
}