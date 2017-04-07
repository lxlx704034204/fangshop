package com.fang.fangshop.core.been;

import com.fang.fangshop.core.common.PageModel;

import java.io.Serializable;

/**
 * 会员等级
 * **/
public class AccountRank extends PageModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String code;

    private String name;

    private Integer minscore;

    private Integer maxscore;

    private String remark;
    //清空实体类
    public void clear(){
    	super.clear();
    	id=null;
    	code=null;
    	name=null;
    	minscore=0;
    	maxscore=0;
    	remark=null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getMinscore() {
        return minscore;
    }

    public void setMinscore(Integer minscore) {
        this.minscore = minscore;
    }

    public Integer getMaxscore() {
        return maxscore;
    }

    public void setMaxscore(Integer maxscore) {
        this.maxscore = maxscore;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public AccountRank() {
		super();
	}

	public AccountRank(Integer id, String code, String name, Integer minscore, Integer maxscore, String remark) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.minscore = minscore;
		this.maxscore = maxscore;
		this.remark = remark;
	}
    
}