package com.fang.fangshop.been;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
    /** t_news.id */
    private Integer id;

    /** t_news.type */
    private String type;

    /** t_news.title */
    private String title;

    /** t_news.title2 */
    private String title2;

    /** t_news.createtime */
    private Date createtime;

    /** t_news.updatetime */
    private Date updatetime;

    /** t_news.readerCount */
    private Integer readercount;

    /** t_news.status */
    private String status;

    /** t_news.catalogID */
    private String catalogid;

    /** t_news.lableID */
    private String lableid;

    /** t_news.createAccount */
    private String createaccount;

    /** t_news.order1 */
    private Integer order1;

    /** t_news.code */
    private String code;

    /** t_news.content */
    private String content;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2 == null ? null : title2.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getReadercount() {
        return readercount;
    }

    public void setReadercount(Integer readercount) {
        this.readercount = readercount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCatalogid() {
        return catalogid;
    }

    public void setCatalogid(String catalogid) {
        this.catalogid = catalogid == null ? null : catalogid.trim();
    }

    public String getLableid() {
        return lableid;
    }

    public void setLableid(String lableid) {
        this.lableid = lableid == null ? null : lableid.trim();
    }

    public String getCreateaccount() {
        return createaccount;
    }

    public void setCreateaccount(String createaccount) {
        this.createaccount = createaccount == null ? null : createaccount.trim();
    }

    public Integer getOrder1() {
        return order1;
    }

    public void setOrder1(Integer order1) {
        this.order1 = order1;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}