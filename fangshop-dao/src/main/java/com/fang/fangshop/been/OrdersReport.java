package com.fang.fangshop.been;

import java.io.Serializable;

public class OrdersReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nopayCount;
	private int payNoAuditCount;
	private int passCount;
	private int sellerAgreeCount;
	private int sellerConfirmGoodsCount;
	private int sellerRefuseCount;
	private int payCancelCount;
	private int buyerRefuseCount;
	private int lowStocksCount;
	private int noreplyCount;

	public int getNopayCount() {
		return nopayCount;
	}

	public void setNopayCount(int nopayCount) {
		this.nopayCount = nopayCount;
	}

	public int getPayNoAuditCount() {
		return payNoAuditCount;
	}

	public void setPayNoAuditCount(int payNoAuditCount) {
		this.payNoAuditCount = payNoAuditCount;
	}

	public int getPassCount() {
		return passCount;
	}

	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}

	public int getSellerAgreeCount() {
		return sellerAgreeCount;
	}

	public void setSellerAgreeCount(int sellerAgreeCount) {
		this.sellerAgreeCount = sellerAgreeCount;
	}

	public int getSellerConfirmGoodsCount() {
		return sellerConfirmGoodsCount;
	}

	public void setSellerConfirmGoodsCount(int sellerConfirmGoodsCount) {
		this.sellerConfirmGoodsCount = sellerConfirmGoodsCount;
	}

	public int getSellerRefuseCount() {
		return sellerRefuseCount;
	}

	public void setSellerRefuseCount(int sellerRefuseCount) {
		this.sellerRefuseCount = sellerRefuseCount;
	}

	public int getPayCancelCount() {
		return payCancelCount;
	}

	public void setPayCancelCount(int payCancelCount) {
		this.payCancelCount = payCancelCount;
	}

	public int getBuyerRefuseCount() {
		return buyerRefuseCount;
	}

	public void setBuyerRefuseCount(int buyerRefuseCount) {
		this.buyerRefuseCount = buyerRefuseCount;
	}

	public int getLowStocksCount() {
		return lowStocksCount;
	}

	public void setLowStocksCount(int lowStocksCount) {
		this.lowStocksCount = lowStocksCount;
	}

	public int getNoreplyCount() {
		return noreplyCount;
	}

	public void setNoreplyCount(int noreplyCount) {
		this.noreplyCount = noreplyCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public OrdersReport() {
		super();
	}

}
