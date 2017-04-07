package com.fang.fangshop.core.system.been;

import com.fang.fangshop.core.common.PageModel;

/**
 * Created by wangyantao on 2017/3/15.
 */
public class Privilege extends PageModel {
    /**
     * t_privilege.id
     */
    private Integer id;

    /**
     * t_privilege.rid
     */
    private Integer rid;

    /**
     * t_privilege.mid
     */
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

    public Privilege(Integer id, Integer rid, Integer mid) {
        this.id = id;
        this.rid = rid;
        this.mid = mid;
    }
    public Privilege(Integer rid, Integer mid) {
        this.rid = rid;
        this.mid = mid;
    }

    public Privilege(Integer rid) {
        this.rid = rid;
    }

    public Privilege() {
    }
}
