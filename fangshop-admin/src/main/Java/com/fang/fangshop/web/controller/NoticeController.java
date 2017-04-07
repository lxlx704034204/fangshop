package com.fang.fangshop.web.controller;

import com.fang.fangshop.core.been.Notice;
import com.fang.fangshop.core.common.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fang.fangshop.services.INoticeService;
import com.fang.fangshop.web.framework.BaseController;
import com.fang.fangshop.web.framework.JsonResult;

@Controller
@RequestMapping("/manage/notice")
public class NoticeController extends BaseController {
	@Autowired
	private INoticeService noticeService;
    private static final String page_toList = "manage/notice/noticeList";
    
    @RequestMapping(value = "selectList", method = RequestMethod.GET)
	public String selectList(@ModelAttribute("notice") Notice notice) {
		return page_toList;
	}

	/*
	 * 分页查询
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult search(@ModelAttribute("notice") Notice notice) throws Exception {
		try {
			PageModel pageModel = noticeService.selectPageList(notice);
			return new JsonResult("success", pageModel);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new JsonResult("fail", ex.getMessage());
		}
	}
}
