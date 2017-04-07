package com.fang.fangshop.web.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.fang.fangshop.been.ReportInfo;
import com.fang.fangshop.core.common.Chart;
import com.fang.fangshop.core.common.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fang.fangshop.services.IReportInfoService;
import com.fang.fangshop.web.framework.BaseController;
import com.fang.fangshop.web.framework.JsonResult;

@Controller
@RequestMapping("/manage/report")
public class ReportController extends BaseController{
	@Autowired
	private IReportInfoService reportInfoService;
	@RequestMapping(value="orderSales",method=RequestMethod.GET)
	public String orderSales(){
		return "manage/report/orderSales";
	}
	
	@RequestMapping(value="productSales",method=RequestMethod.GET)
	public String productSales(){
		return "manage/report/productSales";
	}
	
	@RequestMapping(value = "getOrderSalesData", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult getOrderSalesData(@ModelAttribute("reportInfo") ReportInfo reportInfo) {
		try {
			List<ReportInfo> reportInfos = reportInfoService.getOrderSales(reportInfo);

			Chart chart = new Chart();
			List<String> xList = new LinkedList<>();
			List<Series> yList = new LinkedList<>();
			List<Double> data = new LinkedList<>();

			if (reportInfos != null) {
				for (ReportInfo reportInfo2 : reportInfos) {
					xList.add(reportInfo2.getCreatedate());
					data.add(reportInfo2.getSumAmount());
				}
				yList.add(new Series("月销售总额", data));
			}
			chart.setX(xList);
			chart.setY(yList);
			return new JsonResult("success", chart);
		} catch (Exception e) {
			return new JsonResult("fail");
		}
	}
	@RequestMapping(value = "getProductSalesData", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult getProductSalesData(@ModelAttribute("reportInfo") ReportInfo reportInfo) {
		try {
			List<ReportInfo> reportInfos = reportInfoService.getProductSales(reportInfo);

			Chart chart = new Chart();
			List<String> xList = new LinkedList<>();
			List<Series> yList = new LinkedList<>();
			List<Double> data = new LinkedList<>();

			if (reportInfos != null) {
				for (ReportInfo reportInfo2 : reportInfos) {
					if(reportInfo2.getProductName().length()>6){
						xList.add(reportInfo2.getProductName().substring(0, 5) + "...");
					}
					else{
						xList.add(reportInfo2.getProductName());
					}
					data.add((double)reportInfo2.getProductSellCount());
				}
				yList.add(new Series("商品", data));
			}
			chart.setX(xList);
			chart.setY(yList);
			return new JsonResult("success", chart);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult("fail");
		}
	}

}
