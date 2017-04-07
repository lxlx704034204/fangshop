package com.fang.fangshop.core.been;

import com.fang.fangshop.core.cache.RedisCache;
import com.fang.fangshop.core.cache.RedisFieldNotCache;
import com.fang.fangshop.core.common.QueryModel;

import java.io.Serializable;

@RedisCache
public class Pay extends QueryModel implements Serializable {
	@RedisFieldNotCache
	private static final String className = "pay";
	@RedisFieldNotCache
	private static final String primaryKey = "id";
    /** t_pay.id */
    private Integer id;

    /** t_pay.name */
    private String name;

    /** t_pay.code */
    private String code;

    /** t_pay.seller */
    private String seller;

    /** t_pay.order1 */
    private Integer order1;

    /** t_pay.status */
    private String status;

    /** t_pay.partner */
    private String partner;

    /** t_pay.key1 */
    private String key1;

    /** t_pay.icon */
    private String icon;

    /** t_pay.picture */
    private String picture;

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

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller == null ? null : seller.trim();
    }

    public Integer getOrder1() {
        return order1;
    }

    public void setOrder1(Integer order1) {
        this.order1 = order1;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner == null ? null : partner.trim();
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1 == null ? null : key1.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

	public Pay(Integer id, String name, String code, String seller, Integer order1, String status, String partner,
			String key1, String icon, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.seller = seller;
		this.order1 = order1;
		this.status = status;
		this.partner = partner;
		this.key1 = key1;
		this.icon = icon;
		this.picture = picture;
	}

	public Pay() {
		super();
	}
    
}