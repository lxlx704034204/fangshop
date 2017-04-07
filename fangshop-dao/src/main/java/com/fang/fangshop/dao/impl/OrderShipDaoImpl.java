package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.been.OrderShip;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.IOrderShipDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("orderShipDao")
public class OrderShipDaoImpl implements IOrderShipDao {
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public int insert(OrderShip e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(OrderShip e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(OrderShip e) {
		return baseDao.update("manage.orderShip.updateById", e);
	}

	@Override
	public OrderShip selectOne(OrderShip e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel selectPageList(OrderShip e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderShip> selectList(OrderShip e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderShip selectById(String id) {
		return (OrderShip)baseDao.selectOne("manage.orderShip.selectById", id);
	}

}
