package com.fang.fangshop.services.impl;

import javax.annotation.Resource;

import com.fang.fangshop.been.OrderModel;
import com.fang.fangshop.been.OrdersReport;
import com.fang.fangshop.core.been.Order;
import com.fang.fangshop.core.been.OrderLog;
import com.fang.fangshop.core.service.ServicesManager;
import org.apache.log4j.DailyRollingFileAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fang.fangshop.dao.IOrderDao;
import com.fang.fangshop.services.IOrderLogService;
import com.fang.fangshop.services.IOrderService;

@Service("orderService")
public class OrderServiceImpl extends ServicesManager<OrderModel, IOrderDao> implements IOrderService {
	@Autowired
	private IOrderLogService orderLogService;
	
	@Resource(name="orderDao")
	@Override
	protected void setDao(IOrderDao dao) {
		this.dao=dao;
	}

	@Override
	public void updateOrderStatus(OrderModel order, OrderLog orderLog) throws Exception {
		if(order == null)
		{
			throw new Exception("订单号不能为空！");
		}
		dao.update(order);
		orderLogService.insert(orderLog);
	}

	@Override
	public OrderModel selectByOrderId(int orderId) {
		return dao.selectByOrderId(orderId);
	}

	@Override
	public OrdersReport getHomeOrders() {
		return dao.getHomeOrders();
	}
}
