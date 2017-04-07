package com.fang.fangshop.services.impl;

import javax.annotation.Resource;

import com.fang.fangshop.core.been.Pay;
import com.fang.fangshop.core.service.ServicesManager;
import org.springframework.stereotype.Service;
import com.fang.fangshop.dao.IPayDao;
import com.fang.fangshop.services.IPayService;

@Service("payService")
public class PayServiceImpl extends ServicesManager<Pay, IPayDao> implements IPayService {

	@Resource(name="payDao")
	@Override
	protected void setDao(IPayDao dao) {
		this.dao = dao;
	}

}
