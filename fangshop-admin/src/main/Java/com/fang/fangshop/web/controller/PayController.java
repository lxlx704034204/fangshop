package com.fang.fangshop.web.controller;

import com.fang.fangshop.core.been.Pay;
import com.fang.fangshop.core.common.PageModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fang.fangshop.services.IPayService;
import com.fang.fangshop.web.framework.BaseController;
import com.fang.fangshop.web.framework.JsonResult;

@Controller
@RequestMapping("/manage/pay")
public class PayController extends BaseController {
	@Autowired
	private IPayService payService;
	
	private static final String page_toList = "manage/pay/payList";
	private static final String page_toCreate = "manage/pay/payCreate";
	private static final String page_toEdit = "manage/pay/payEdit";
	
	@RequestMapping(value = "selectList", method = RequestMethod.GET)
	public String selectList(@ModelAttribute("pay") Pay pay) {
		return page_toList;
	}
	@RequestMapping(value="create",method=RequestMethod.GET)
	public String create(){
		return page_toCreate;
	}
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public String edit(String id,ModelMap modelMap){
		try {
			Pay pay = payService.selectById(id);
			modelMap.addAttribute("pay", pay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page_toEdit;
	}
	
	/*
	 * 分页查询
	 */
	@RequestMapping(value = "/search")
	@ResponseBody
	public JsonResult search(@ModelAttribute("pay") Pay pay) throws Exception {
		try {
			PageModel pageModel = payService.selectPageList(pay);
			return new JsonResult("success", pageModel);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new JsonResult("fail", ex.getMessage());
		}
	}
	@RequestMapping(value="insert",method= RequestMethod.POST)
	@ResponseBody
	public JsonResult insert(@ModelAttribute("pay") Pay pay){
		try {
			if(StringUtils.isBlank(pay.getCode())){
				return new JsonResult("支付方式不能为空");
			}
			if(StringUtils.isBlank(pay.getStatus()))
			{
				return new JsonResult("状态不能为空");
			}
			if(StringUtils.isBlank(pay.getPartner()))
			{
				return new JsonResult("ID不能为空");
			}
			if(StringUtils.isBlank(pay.getKey1())){
				return new JsonResult("商户的私钥不能为空");
			}
			if(StringUtils.isBlank(pay.getOrder1().toString()))
			{
				return new JsonResult("顺序不能为空");
			}
			payService.insert(pay);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult update(@ModelAttribute("pay") Pay pay){
		try {
			if(StringUtils.isBlank(pay.getCode())){
				return new JsonResult("支付方式不能为空");
			}
			if(StringUtils.isBlank(pay.getStatus()))
			{
				return new JsonResult("状态不能为空");
			}
			if(StringUtils.isBlank(pay.getPartner()))
			{
				return new JsonResult("ID不能为空");
			}
			if(StringUtils.isBlank(pay.getKey1())){
				return new JsonResult("商户的私钥不能为空");
			}
			if(StringUtils.isBlank(pay.getOrder1().toString()))
			{
				return new JsonResult("顺序不能为空");
			}
			payService.update(pay);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@ModelAttribute("pay") Pay pay){
		try {
			payService.delete(pay);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
}
