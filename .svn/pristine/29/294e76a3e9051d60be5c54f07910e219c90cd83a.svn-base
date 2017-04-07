package com.fang.fangshop.services;

import com.fang.fangshop.been.OrderModel;
import com.fang.fangshop.been.OrdersReport;
import com.fang.fangshop.core.been.Order;
import com.fang.fangshop.core.been.OrderLog;
import com.fang.fangshop.core.service.IServices;

public interface IOrderService extends IServices<OrderModel> {
	//修改订单状态并添加日志
	public void updateOrderStatus(OrderModel order, OrderLog orderLog) throws Exception;
	//查询单个订单
	public OrderModel selectByOrderId(int orderId);
	//首页订单统计
	public OrdersReport getHomeOrders();
}
