package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.been.Product;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.dao.IProductDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public class ProductDaoImpl implements IProductDao {

	@Override
	public int insert(Product e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Product e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Product e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product selectOne(Product e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel selectPageList(Product e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectList(Product e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
