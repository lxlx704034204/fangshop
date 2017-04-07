package com.fang.fangshop.core.been;

import com.fang.fangshop.core.common.PageModel;

import java.math.BigDecimal;

/**
 * Created by wangyantao on 2017/4/5.
 */

public class Express extends PageModel {
    /** t_express.id */
    private Integer id;

    /** t_express.code */
    private String code;

    /** t_express.name */
    private String name;

    /** t_express.fee */
    private BigDecimal fee;

    /** t_express.order1 */
    private Integer order1;

    private static final long serialVersionUID = 1L;

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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Integer getOrder1() {
        return order1;
    }

    public void setOrder1(Integer order1) {
        this.order1 = order1;
    }

    @Override
    public String toString() {
        return "Express{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", fee=" + fee +
                ", order1=" + order1 +
                '}';
    }

    public Express(Integer id, String code, String name, BigDecimal fee, Integer order1) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.fee = fee;
        this.order1 = order1;
    }

    public Express() {
    }
}