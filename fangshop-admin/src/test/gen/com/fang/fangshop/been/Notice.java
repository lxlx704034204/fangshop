package com.fang.fangshop.been;

import java.io.Serializable;

public class Notice implements Serializable {
    /** t_notice.id */
    private Integer id;

    /** t_notice.title */
    private String title;

    /** t_notice.content */
    private String content;

    /** t_notice.createtime */
    private String createtime;

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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}