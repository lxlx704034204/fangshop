package com.fang.fangshop.services.impl;
import javax.annotation.Resource;

import com.fang.fangshop.core.been.OrderLog;
import com.fang.fangshop.core.service.ServicesManager;
import org.springframework.stereotype.Service;
import com.fang.fangshop.dao.IOrderLogDao;
import com.fang.fangshop.services.IOrderLogService;

@Service("orderLogService")
public class OrderLogServiceImpl extends ServicesManager<OrderLog, IOrderLogDao> implements IOrderLogService
{
	@Resource(name="orderLogDao")
	@Override
	protected void setDao(IOrderLogDao dao) {
		this.dao=dao;
	}
}
