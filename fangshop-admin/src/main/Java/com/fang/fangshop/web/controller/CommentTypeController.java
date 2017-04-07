package com.fang.fangshop.web.controller;

import com.fang.fangshop.core.been.CommentType;
import com.fang.fangshop.core.common.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fang.fangshop.services.ICommentTypeService;
import com.fang.fangshop.web.framework.BaseController;
import com.fang.fangshop.web.framework.JsonResult;
@Controller
@RequestMapping("/manage/commentType")
public class CommentTypeController extends BaseController {
	@Autowired
	private ICommentTypeService commentTypeService;
	
	private static final String page_toList = "manage/commenttype/commentTypeList";
	@RequestMapping(value = "selectList", method = RequestMethod.GET)
	public String selectList(@ModelAttribute("commentType") CommentType commentType) {
		return page_toList;
	}
	/*
	 * 分页查询
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult search(@ModelAttribute("commentType") CommentType commentType) throws Exception {
		try {
			PageModel pageModel = commentTypeService.selectPageList(commentType);
			return new JsonResult("success", pageModel);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new JsonResult("fail", ex.getMessage());
		}
	}
}
