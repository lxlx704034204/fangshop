package com.fang.fangshop.web.controller;

import com.fang.fangshop.core.been.Oss;
import com.fang.fangshop.core.common.PageModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fang.fangshop.services.IOssService;
import com.fang.fangshop.web.framework.BaseController;
import com.fang.fangshop.web.framework.JsonResult;

@Controller
@RequestMapping("/manage/oss")
public class OssController extends BaseController{
	@Autowired
	private IOssService ossService;
	private static final String page_toList = "manage/oss/ossList";
	private static final String page_toCreate = "manage/oss/ossCreate";
	private static final String page_toEdit = "manage/oss/ossEdit";
	
	@RequestMapping(value = "selectList", method = RequestMethod.GET)
	public String selectList(@ModelAttribute("oss") Oss oss) {
		return page_toList;
	}
	@RequestMapping(value="create",method=RequestMethod.GET)
	public String create(){
		return page_toCreate;
	}
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public String edit(String id,ModelMap modelMap){
		try {
			Oss oss = ossService.selectById(id);
			modelMap.addAttribute("oss", oss);
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
	public JsonResult search(@ModelAttribute("oss") Oss oss) throws Exception {
		try {
			PageModel pageModel = ossService.selectPageList(oss);
			return new JsonResult("success", pageModel);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new JsonResult("fail", ex.getMessage());
		}
	}
	@RequestMapping(value="insert",method= RequestMethod.POST)
	@ResponseBody
	public JsonResult insert(@ModelAttribute("oss") Oss oss){
		try {
			if(StringUtils.isBlank(oss.getCode())){
				return new JsonResult("插件存储方式不能为空");
			}
			if(StringUtils.isBlank(oss.getStatus()))
			{
				return new JsonResult("状态不能为空");
			}
			if(StringUtils.isBlank(oss.getOssjsoninfo()))
			{
				return new JsonResult("存储信息不能为空");
			}
		
			ossService.insert(oss);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult update(@ModelAttribute("oss") Oss oss){
		try {
			if(StringUtils.isBlank(oss.getCode())){
				return new JsonResult("插件存储方式不能为空");
			}
			if(StringUtils.isBlank(oss.getStatus()))
			{
				return new JsonResult("状态不能为空");
			}
			if(StringUtils.isBlank(oss.getOssjsoninfo()))
			{
				return new JsonResult("存储信息不能为空");
			}
			ossService.update(oss);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@ModelAttribute("oss") Oss oss){
		try {
			ossService.delete(oss);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
}
