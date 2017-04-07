package com.fang.fangshop.services;

import com.fang.fangshop.core.been.OrderLog;
import com.fang.fangshop.core.been.OrderPay;
import com.fang.fangshop.core.service.IServices;

public interface IOrderPayService extends IServices<OrderPay>{
	public void insertToOderPay(OrderPay orderPay, OrderLog orderLog) throws Exception;
}
