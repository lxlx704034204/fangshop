package com.fang.fangshop.been;

import java.io.Serializable;

public class Menu implements Serializable {
    /** t_menu.id */
    private Integer id;

    /** t_menu.pid */
    private Integer pid;

    /** t_menu.url */
    private String url;

    /** 111 */
    private String name;

    /** t_menu.orderNum */
    private Integer ordernum;

    /** t_menu.type */
    private String type;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}