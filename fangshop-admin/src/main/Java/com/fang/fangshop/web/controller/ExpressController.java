package com.fang.fangshop.web.controller;

import com.fang.fangshop.core.been.Express;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.services.IExpressService;
import com.fang.fangshop.web.framework.BaseController;
import com.fang.fangshop.web.framework.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangyantao on 2017/4/5.
 */
@Controller
@RequestMapping("/manage/express")
public class ExpressController extends BaseController {
    @Autowired
    private IExpressService expressService;

    private static final String page_toList = "manage/express/expressList";
    private static final String page_toAdd = "manage/express/addExpress";
    private static final String page_toEdit = "manage/express/editExpress";

    @RequestMapping("/selectList")
    public String selectList(){
        return page_toList;
    }
    @RequestMapping("/toAdd")
    public String toAdd(ModelMap modelMap){
        return page_toAdd;
    }
    @RequestMapping("/toEdit")
    public String toEdit(@ModelAttribute("express") Express express,ModelMap modelMap){
        Express express1 = expressService.selectOne(express);
        modelMap.addAttribute("express",express1);
        return page_toEdit;
    }
    @RequestMapping("/search")
    @ResponseBody
    public JsonResult search(@ModelAttribute("express") Express express){
        try {
            PageModel pageModel = expressService.selectPageList(express);
            return new JsonResult("success", pageModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JsonResult("fail", ex.getMessage());
        }
    }
    @RequestMapping("/insert")
    @ResponseBody
    public JsonResult insert(@ModelAttribute("express") Express express){
        try {
            expressService.insert(express);
            return new JsonResult("success");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JsonResult("fail", ex.getMessage());
        }
    }
    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@ModelAttribute("express") Express express){
        try {
            expressService.update(express);
            return new JsonResult("success");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JsonResult("fail", ex.getMessage());
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@ModelAttribute("express") Express express){
        try {
            expressService.delete(express);
            return new JsonResult("success");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JsonResult("fail", ex.getMessage());
        }
    }
}
