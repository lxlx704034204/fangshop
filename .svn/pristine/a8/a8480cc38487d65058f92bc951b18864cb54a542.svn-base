//package com.fang.fangshop.web.controller;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import javax.servlet.http.HttpSession;
//
//import com.fang.fangshop.core.been.Account;
//import com.fang.fangshop.core.common.PageModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import com.fang.fangshop.services.impl.AccountServiceImpl;
//
//@Controller
//@RequestMapping("/manage/account")
//public class AccountController {
//
//	@Autowired
//	private AccountServiceImpl accountService;
//
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//	}
//
//	@RequestMapping(value = "selectList", method = RequestMethod.GET)
//	public String selectList() {
//		return "manage/account/accountList";
//	}
//
//	@RequestMapping(value = "loadRankList", method = RequestMethod.POST)
//	@ResponseBody
//	public PageModel loadAccountList(@ModelAttribute("e") Account e) {
//		PageModel pageModel = new PageModel();
//		pageModel = accountService.selectPageList(e);
//		return pageModel;
//	}
//
//	@RequestMapping(value="lookAccount")
//	public String lookAccount(@ModelAttribute("e")Account e,ModelMap modelMap)
//	{
//		modelMap.addAttribute("account", e);
//		return "manage/account/show";
//	}
//
//	@RequestMapping(value="freezeAccount")
//	public String freezeAccount(@ModelAttribute("e")Account e,ModelMap modelMap){
//		modelMap.addAttribute("account", e);
//		return "manage/account/freeze";
//	}
//
//	@RequestMapping(value="freezeCommit")
//	public String freeze(@ModelAttribute("e") Account e,HttpSession session){
////		if(session!=null)
////		{
////			if(e.getId()!=null&&e.getId().toString()!=""){
////				accountService.updateFreeze(e);
////			}
////		}
//		return "manage/account/accountList";
//	}
//}
