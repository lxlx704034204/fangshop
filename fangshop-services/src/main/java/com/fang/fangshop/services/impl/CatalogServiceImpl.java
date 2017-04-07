package com.fang.fangshop.services.impl;

import java.util.List;

import com.fang.fangshop.core.been.Catalog;
import com.fang.fangshop.core.service.ServicesManager;
import com.fang.fangshop.dao.ICatalogDao;
import org.springframework.stereotype.Service;
import com.fang.fangshop.services.ICatalogService;

import javax.annotation.Resource;

@Service("catalogService")
public class CatalogServiceImpl extends ServicesManager<Catalog, ICatalogDao> implements ICatalogService {
	@Resource(name="catalogDao")
	@Override
	protected void setDao(ICatalogDao dao) {
		this.dao=dao;
	}

}
