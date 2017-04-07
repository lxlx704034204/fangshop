package com.fang.fangshop.services.impl;

import java.util.List;

import com.fang.fangshop.core.been.Product;
import com.fang.fangshop.core.service.ServicesManager;
import com.fang.fangshop.dao.IProductDao;
import org.springframework.stereotype.Service;
import com.fang.fangshop.services.IProductService;

import javax.annotation.Resource;

@Service("productService")
public class ProductServiceImpl extends ServicesManager<Product, IProductDao> implements IProductService {
	@Resource(name="productDao")
	@Override
	protected void setDao(IProductDao dao) {
		this.dao = dao;
	}
}
