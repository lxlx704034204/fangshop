package com.fang.fangshop.services.impl;

import javax.annotation.Resource;

import com.fang.fangshop.core.been.Oss;
import com.fang.fangshop.core.service.ServicesManager;
import org.springframework.stereotype.Service;
import com.fang.fangshop.dao.IOssDao;
import com.fang.fangshop.services.IOssService;

@Service("ossService")
public class OssServiceImpl extends ServicesManager<Oss, IOssDao> implements IOssService {

	@Resource(name="ossDao")
	@Override
	protected void setDao(IOssDao dao) {
		this.dao = dao;
	}

}
