package com.fang.fangshop.services.impl;

import java.util.List;

import javax.annotation.Resource;

import com.fang.fangshop.been.ReportInfo;
import com.fang.fangshop.core.service.ServicesManager;
import org.springframework.stereotype.Service;
import com.fang.fangshop.dao.IReportInfoDao;
import com.fang.fangshop.services.IReportInfoService;

@Service("reportInfoService")
public class IReportInfoServiceImpl extends ServicesManager<ReportInfo, IReportInfoDao> implements IReportInfoService {
	@Resource(name="reportInfoDao")
	@Override
	protected void setDao(IReportInfoDao dao) {
		this.dao=dao;
	}
	@Override
	public List<ReportInfo> getOrderSales(ReportInfo reportInfo) {
		return dao.getOrderSales(reportInfo);
	}
	@Override
	public List<ReportInfo> getProductSales(ReportInfo reportInfo) {
		return dao.getProductSales(reportInfo);
	}
}
