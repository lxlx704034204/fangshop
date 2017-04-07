package com.fang.fangshop.dao.impl;

import com.fang.fangshop.been.ReportInfo;
import com.fang.fangshop.core.dao.BaseDao;
import com.fang.fangshop.dao.IReportInfoDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("reportInfoDao")
public class ReportInfoDaoImpl implements IReportInfoDao {
    @Resource
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public int insert(ReportInfo e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ReportInfo e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ReportInfo e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReportInfo selectOne(ReportInfo e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReportInfo selectPageList(ReportInfo e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReportInfo> selectList(ReportInfo e) {
		return baseDao.selectList("manage.order.selectOrderSales", e);
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReportInfo selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReportInfo> getOrderSales(ReportInfo reportInfo) {
		return baseDao.selectList("manage.order.selectOrderSales", reportInfo);
	}

	@Override
	public List<ReportInfo> getProductSales(ReportInfo reportInfo) {
		return baseDao.selectList("manage.order.selectProductSelleCount", reportInfo);
	}

}
