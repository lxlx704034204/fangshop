//package com.fang.fangshop.web.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import com.fang.fangshop.core.been.AccountRank;
//import com.fang.fangshop.core.common.PageModel;
//import org.apache.bcel.generic.NEW;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import com.fang.fangshop.services.IAccountRankService;
//import com.fang.fangshop.services.impl.AccountRankServiceImpl;
//
//@Controller
//@RequestMapping("/manage/accountRank")
//public class AccountRankController {
//
//	@Autowired
//	private AccountRankServiceImpl accountRankService;
//
//	@RequestMapping(value = "selectList", method = RequestMethod.GET)
//	public String selectList() {
//		return "manage/accountRank/accountRankList";
//	}
//
//	@RequestMapping(value = "loadAccountRanktList", method = RequestMethod.POST)
//	@ResponseBody
//	public PageModel loadAccountRanktList(@ModelAttribute("e") AccountRank e) {
//		PageModel pageModel = new PageModel();
//		pageModel = accountRankService.selectPageList(e);
//		return pageModel;
//	}
//
//	@RequestMapping("addAccountRank")
//	public String addAccountRank(@ModelAttribute("e") AccountRank e, ModelMap modelMap) {
//		modelMap.addAttribute("accountRank", e);
//		return "manage/accountRank/editAccountRank";
//	}
//
//
//	@RequestMapping("save")
//	public String save(@ModelAttribute("e") AccountRank e,HttpSession session){
//		if(session!=null){
//			if(e.getId()!=null&& e.getId().toString()!=""){
//				accountRankService.update(e);
//			}else{
//				accountRankService.insert(e);
//			}
//		}
//		return "manage/accountRank/accountRankList";
//	}
//
//	@RequestMapping("delete")
//	public String delete(@ModelAttribute("e") AccountRank e,HttpSession session) {
//		if(session!=null){
//			if(e.getId()!=null && e.getId().toString()!=""){
//				accountRankService.delete(e);
//			}
//		}
//		return "manage/accountRank/accountRankList";
//	}
//}
