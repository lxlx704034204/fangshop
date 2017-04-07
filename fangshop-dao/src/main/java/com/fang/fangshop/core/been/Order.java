package com.fang.fangshop.core.been;

import com.fang.fangshop.core.common.PageModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 * @author wangyantao
 *
 */
public class Order extends PageModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** t_order.id */
    private Integer id;

    /** t_order.account */
    private String account;

    /** t_order.payType */
    private Integer paytype;

    /** t_order.carry */
    private Integer carry;

    /** t_order.rebate */
    private BigDecimal rebate;

    /** t_order.createdate */
    private Date createdate;

    /** t_order.status */
    private String status;

    /** t_order.refundStatus */
    private String refundstatus;

    /** t_order.amount */
    private BigDecimal amount;

    /** t_order.fee */
    private BigDecimal fee;

    /** t_order.ptotal */
    private BigDecimal ptotal;

    /** t_order.quantity */
    private Integer quantity;

    /** t_order.paystatus */
    private String paystatus;

    /** t_order.updateAmount */
    private String updateamount;

    /** t_order.expressCode */
    private String expresscode;

    /** t_order.expressName */
    private String expressname;

    /** t_order.otherRequirement */
    private String otherrequirement;

    /** t_order.remark */
    private String remark;

    /** t_order.expressNo */
    private String expressno;

    /** t_order.expressCompanyName */
    private String expresscompanyname;

    /** t_order.lowStocks */
    private String lowstocks;

    /** t_order.confirmSendProductRemark */
    private String confirmsendproductremark;

    /** t_order.closedComment */
    private String closedcomment;

    /** t_order.score */
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public Integer getCarry() {
        return carry;
    }

    public void setCarry(Integer carry) {
        this.carry = carry;
    }

    public BigDecimal getRebate() {
        return rebate;
    }

    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRefundstatus() {
        return refundstatus;
    }

    public void setRefundstatus(String refundstatus) {
        this.refundstatus = refundstatus == null ? null : refundstatus.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getPtotal() {
        return ptotal;
    }

    public void setPtotal(BigDecimal ptotal) {
        this.ptotal = ptotal;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus == null ? null : paystatus.trim();
    }

    public String getUpdateamount() {
        return updateamount;
    }

    public void setUpdateamount(String updateamount) {
        this.updateamount = updateamount == null ? null : updateamount.trim();
    }

    public String getExpresscode() {
        return expresscode;
    }

    public void setExpresscode(String expresscode) {
        this.expresscode = expresscode == null ? null : expresscode.trim();
    }

    public String getExpressname() {
        return expressname;
    }

    public void setExpressname(String expressname) {
        this.expressname = expressname == null ? null : expressname.trim();
    }

    public String getOtherrequirement() {
        return otherrequirement;
    }

    public void setOtherrequirement(String otherrequirement) {
        this.otherrequirement = otherrequirement == null ? null : otherrequirement.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getExpressno() {
        return expressno;
    }

    public void setExpressno(String expressno) {
        this.expressno = expressno == null ? null : expressno.trim();
    }

    public String getExpresscompanyname() {
        return expresscompanyname;
    }

    public void setExpresscompanyname(String expresscompanyname) {
        this.expresscompanyname = expresscompanyname == null ? null : expresscompanyname.trim();
    }

    public String getLowstocks() {
        return lowstocks;
    }

    public void setLowstocks(String lowstocks) {
        this.lowstocks = lowstocks == null ? null : lowstocks.trim();
    }

    public String getConfirmsendproductremark() {
        return confirmsendproductremark;
    }

    public void setConfirmsendproductremark(String confirmsendproductremark) {
        this.confirmsendproductremark = confirmsendproductremark == null ? null : confirmsendproductremark.trim();
    }

    public String getClosedcomment() {
        return closedcomment;
    }

    public void setClosedcomment(String closedcomment) {
        this.closedcomment = closedcomment == null ? null : closedcomment.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}