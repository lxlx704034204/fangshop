package com.fang.fangshop.services.impl;

import java.util.List;

import javax.annotation.Resource;

import com.fang.fangshop.core.been.OrderShip;
import com.fang.fangshop.core.service.ServicesManager;
import org.springframework.stereotype.Service;
import com.fang.fangshop.dao.IOrderShipDao;
import com.fang.fangshop.services.IOrderShipService;

@Service("orderShipService")
public class OrderShipServiceImpl extends ServicesManager<OrderShip, IOrderShipDao> implements IOrderShipService
{
	@Resource(name="orderShipDao")
	@Override
	protected void setDao(IOrderShipDao dao) {
		this.dao =dao;
	}

	

}
