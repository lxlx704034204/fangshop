package com.fang.fangshop.web.controller;

import java.text.SimpleDateFormat;

import com.fang.fangshop.core.been.Advert;
import com.fang.fangshop.core.common.PageModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fang.fangshop.services.IAdvertService;
import com.fang.fangshop.web.framework.BaseController;
import com.fang.fangshop.web.framework.JsonResult;


@Controller
@RequestMapping("/manage/advert")
public class AdvertController extends BaseController {
	@Autowired
	private IAdvertService advertService;
    private static final String page_toList = "manage/advert/advertList";
	private static final String page_toCreate = "manage/advert/advertCreate";
	private static final String page_toEdit = "manage/advert/advertEdit";
    
    @RequestMapping(value = "selectList", method = RequestMethod.GET)
	public String selectList(@ModelAttribute("advert") Advert advert, ModelMap modelMap){
		return page_toList;
	}
    @RequestMapping(value="create",method=RequestMethod.GET)
	public String create(){
		return page_toCreate;
	}
    @InitBinder    //初始化参数绑定， 日期类型的转化，
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public String edit(String id,ModelMap modelMap){
		try {
			Advert advert = advertService.selectById(id);
			modelMap.addAttribute("advert", advert);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page_toEdit;
	}
	/*
	 * 分页查询
	 */
	@ResponseBody
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public JsonResult search(@ModelAttribute("advert") Advert advert) throws Exception {
		try {
			Thread.sleep(500);
			PageModel pageModel = advertService.selectPageList(advert);
			return new JsonResult("success", pageModel);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new JsonResult("fail", ex.getMessage());
		}
	}
	@ResponseBody
	@RequestMapping(value="insert",method= RequestMethod.POST)
	public JsonResult insert(@ModelAttribute("advert") Advert advert){
		try {
			if(StringUtils.isBlank(advert.getTitle())){
				return new JsonResult("标题不能为空");
			}
			advertService.insert(advert);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult update(@ModelAttribute("advert") Advert advert){
		try {
			if(StringUtils.isBlank(advert.getTitle())){
				return new JsonResult("标题不能为空");
			}
			advertService.update(advert);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@ModelAttribute("advert") Advert advert){
		try {
	        advertService.delete(advert);
			return new JsonResult("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult("fail");
	}
}

