package com.fang.fangshop.been;

import java.io.Serializable;

public class Privilege implements Serializable {
    /** t_privilege.id */
    private Integer id;

    /** t_privilege.rid */
    private Integer rid;

    /** t_privilege.mid */
    private Integer mid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}