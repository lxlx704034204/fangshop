package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.been.OrderPay;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.IOrderPayDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("orderPayDao")
public class OrderPayDaoImpl implements IOrderPayDao {
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public int insert(OrderPay e) {
		return baseDao.insert("manage.orderPay.insert", e);
	}

	@Override
	public int delete(OrderPay e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(OrderPay e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderPay selectOne(OrderPay e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel selectPageList(OrderPay e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderPay> selectList(OrderPay e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderPay selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
