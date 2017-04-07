package com.fang.fangshop.web.controller;

import com.fang.fangshop.core.been.IndexImg;
import com.fang.fangshop.core.common.PageModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fang.fangshop.services.IIndexImgService;
import com.fang.fangshop.web.framework.BaseController;
import com.fang.fangshop.web.framework.JsonResult;


@Controller
@RequestMapping("/manage/indexImg")
public class IndexImgController extends BaseController {
	@Autowired
	private IIndexImgService indexImgService;
    private static final String page_toList = "manage/indexImg/indexImgList";
	private static final String page_toCreate = "manage/indexImg/indexImgCreate";
	private static final String page_toEdit = "manage/indexImg/indexImgEdit";
    
    @RequestMapping(value = "selectList", method = RequestMethod.GET)
	public String selectList(@ModelAttribute("indexImg") IndexImg indexImg, ModelMap modelMap){
		return page_toList;
	}
    @RequestMapping(value="create",method=RequestMethod.GET)
	public String create(){
		return page_toCreate;
	}
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public String edit(String id,ModelMap modelMap){
		try {
			IndexImg indexImg = indexImgService.selectById(id);
			modelMap.addAttribute("indexImg", indexImg);
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
	public JsonResult search(@ModelAttribute("indexImg") IndexImg indexImg) throws Exception {
		try {
			Thread.sleep(100);
			PageModel pageModel = indexImgService.selectPageList(indexImg);
			return new JsonResult("success", pageModel);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new JsonResult("fail", ex.getMessage());
		}
	}
	@RequestMapping(value="insert",method= RequestMethod.POST)
	@ResponseBody
	public JsonResult insert(@ModelAttribute("indexImg") IndexImg indexImg){
		try {
			if(StringUtils.isBlank(indexImg.getTitle())){
				return new JsonResult("标题不能为空");
			}
			if(StringUtils.isBlank(indexImg.getLink()))
			{
				return new JsonResult("地址不能为空");
			}
			
			indexImgService.insert(indexImg);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult update(@ModelAttribute("indexImg") IndexImg indexImg){
		try {
			if(StringUtils.isBlank(indexImg.getTitle())){
				return new JsonResult("标题不能为空");
			}
			if(StringUtils.isBlank(indexImg.getLink()))
			{
				return new JsonResult("地址不能为空");
			}
			
			indexImgService.update(indexImg);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@ModelAttribute("indexImg") IndexImg indexImg){
		try {
			indexImgService.delete(indexImg);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
}
