package com.fang.fangshop.been;

import java.io.Serializable;
import java.math.BigDecimal;

public class Express implements Serializable {
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
}