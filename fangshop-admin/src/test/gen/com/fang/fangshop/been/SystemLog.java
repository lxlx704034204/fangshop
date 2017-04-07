package com.fang.fangshop.been;

import java.io.Serializable;
import java.util.Date;

public class SystemLog implements Serializable {
    /** t_systemlog.id */
    private Integer id;

    /** t_systemlog.title */
    private String title;

    /** t_systemlog.content */
    private String content;

    /** t_systemlog.type */
    private Integer type;

    /** t_systemlog.account */
    private String account;

    /** t_systemlog.loginIP */
    private String loginip;

    /** t_systemlog.logintime */
    private Date logintime;

    /** t_systemlog.loginArea */
    private String loginarea;

    /** t_systemlog.diffAreaLogin */
    private String diffarealogin;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip == null ? null : loginip.trim();
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public String getLoginarea() {
        return loginarea;
    }

    public void setLoginarea(String loginarea) {
        this.loginarea = loginarea == null ? null : loginarea.trim();
    }

    public String getDiffarealogin() {
        return diffarealogin;
    }

    public void setDiffarealogin(String diffarealogin) {
        this.diffarealogin = diffarealogin == null ? null : diffarealogin.trim();
    }
}