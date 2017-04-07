package com.fang.fangshop.web.controller;

import java.util.Date;

import com.fang.fangshop.core.been.News;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.web.framework.LoginUserHolder;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fang.fangshop.services.INewsService;
import com.fang.fangshop.web.framework.BaseController;
import com.fang.fangshop.web.framework.JsonResult;

@Controller
@RequestMapping("/manage/news")
public class NewsController extends BaseController {
	@Autowired
	private INewsService newsService;
    private static final String page_toList = "manage/news/newsList";
	private static final String page_toCreate = "manage/news/newsCreate";
	private static final String page_toEdit = "manage/news/newsEdit";
    
    @RequestMapping(value = "selectList", method = RequestMethod.GET)
	public String selectList(@ModelAttribute("news") News news, ModelMap modelMap){
    	modelMap.addAttribute("news", news);
		return page_toList;
	}
    @RequestMapping(value="create",method=RequestMethod.GET)
	public String create(){
		return page_toCreate;
	}
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public String edit(String id,ModelMap modelMap){
		try {
			News news = newsService.selectById(id);
			modelMap.addAttribute("news", news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page_toEdit;
	}
	/*
	 * 分页查询
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult search(@ModelAttribute("news") News news) throws Exception {
		try {
			Thread.sleep(100);
			PageModel pageModel = newsService.selectPageList(news);
			return new JsonResult("success", pageModel);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new JsonResult("fail", ex.getMessage());
		}
	}
	@RequestMapping(value="insert",method= RequestMethod.POST)
	@ResponseBody
	public JsonResult insert(@ModelAttribute("news") News news){
		try {
			if(StringUtils.isBlank(news.getTitle())){
				return new JsonResult("标题不能为空");
			}
			if(StringUtils.isBlank(news.getContent()))
			{
				return new JsonResult("内容不能为空");
			}
			news.setReadercount(0);
			news.setOrder1(0);
			news.setCreatetime(new Date());
			news.setUpdatetime(new Date());
			news.setCreateaccount(LoginUserHolder.getLoginUser().getUsername());
			newsService.insert(news);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult update(@ModelAttribute("news") News news){
		try {
			if(StringUtils.isBlank(news.getTitle())){
				return new JsonResult("标题不能为空");
			}
			if(StringUtils.isBlank(news.getContent()))
			{
				return new JsonResult("内容不能为空");
			}
			news.setReadercount(0);
			news.setOrder1(0);
			news.setUpdatetime(new Date());
			newsService.update(news);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@ModelAttribute("news") News news){
		try {
		    newsService.delete(news);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
}
