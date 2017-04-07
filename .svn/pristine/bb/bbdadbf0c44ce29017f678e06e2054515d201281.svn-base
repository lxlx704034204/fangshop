package com.fang.fangshop.dao.impl;

import com.fang.fangshop.been.OrderModel;
import com.fang.fangshop.been.OrdersReport;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.IOrderDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl implements IOrderDao {
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public PageModel selectPageList(OrderModel e) {
		return baseDao.selectPageList("manage.order.selectPageList",
				"manage.order.selectPageCount", e);
	}

	@Override
	public int insert(OrderModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(OrderModel t) {
		return baseDao.update("manage.order.updateById", t);
	}

	@Override
	public int delete(OrderModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderModel selectOne(OrderModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> selectList(OrderModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderModel selectById(String id) {
		return baseDao.selectOne("manage.order.selectById", id);
	}
	@Override
	public OrderModel selectByOrderId(int orderId) {
		return baseDao.selectOne("manage.order.selectByOrderId", orderId);
	}
	@Override
	public OrdersReport getHomeOrders() {
		return baseDao.selectOne("manage.order.selectHomeOrders");
	}
}
