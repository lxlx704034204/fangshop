package com.fang.fangshop.core.been;

import com.fang.fangshop.core.common.PageModel;

import java.io.Serializable;


public class CommentType extends PageModel implements Serializable{
    /** t_commenttype.id */
    private Integer id;

    /** t_commenttype.name */
    private String name;

    /** t_commenttype.code */
    private String code;

    /** t_commenttype.status */
    private String status;

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
}