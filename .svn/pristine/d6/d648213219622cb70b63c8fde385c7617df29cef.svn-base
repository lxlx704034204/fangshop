package com.fang.fangshop.dao.impl;

import com.fang.fangshop.core.been.OrderLog;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.IOrderLogDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("orderLogDao")
public class OrderLogDaoImpl implements IOrderLogDao {
	@Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public int insert(OrderLog e) {
		return baseDao.insert("manage.orderLog.insert",e);
	}

	@Override
	public int delete(OrderLog e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(OrderLog e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderLog selectOne(OrderLog e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel selectPageList(OrderLog e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderLog> selectList(OrderLog e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderLog selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
