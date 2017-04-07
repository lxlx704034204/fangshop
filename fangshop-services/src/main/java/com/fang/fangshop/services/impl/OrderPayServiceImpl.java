package com.fang.fangshop.services.impl;

import java.util.List;

import javax.annotation.Resource;

import com.fang.fangshop.core.been.OrderLog;
import com.fang.fangshop.core.been.OrderPay;
import com.fang.fangshop.core.service.ServicesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fang.fangshop.dao.IOrderPayDao;
import com.fang.fangshop.services.IOrderLogService;
import com.fang.fangshop.services.IOrderPayService;

@Service("orderPayService")
public class OrderPayServiceImpl extends ServicesManager<OrderPay,IOrderPayDao> implements IOrderPayService {
    @Autowired
	private IOrderLogService orderLogService;
    
	@Resource(name="orderPayDao")
	@Override
	protected void setDao(IOrderPayDao dao) {
		this.dao = dao;
	}

	@Override
	public void insertToOderPay(OrderPay orderPay, OrderLog orderLog) throws Exception {
		if(orderLog == null || orderPay == null){
			throw new Exception("数据不能为空！");
		}
		dao.insert(orderPay);
		orderLogService.insert(orderLog);
	}
}
