package com.fang.fangshop.web.controller;

import com.alibaba.fastjson.JSON;
import com.fang.fangshop.core.common.StringUtil;
import com.fang.fangshop.core.system.been.Menu;
import com.fang.fangshop.web.framework.JsonResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fang.fangshop.services.IMenuService;
import com.fang.fangshop.web.framework.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/manage/menu")
public class MenuController extends BaseController {
    private static final String page_toList = "manage/system/menu/menuList";
    @Autowired
	private IMenuService menuService;

    @RequestMapping("/selectList")
    public String selectList(){
        return  page_toList;
    }
    @RequestMapping("/getAllMenus")
    @ResponseBody
    public JsonResult getAllMenus(HttpServletRequest httpServletRequest){
        int rid = Integer.parseInt(httpServletRequest.getParameter("rid"));
        try {
            List<Menu> list = menuService.selectAll(rid);
            return new JsonResult("success", list);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JsonResult("fail", ex.getMessage());
        }
    }
    /**
     * 添加函数
     *
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public JsonResult insert(@ModelAttribute("menu") Menu menu) {
        try {
            int id = menuService.insert(menu);
            return new JsonResult("success",menu.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JsonResult("fail", ex.getMessage());
        }
    }

    /**
     * 编辑
     * @param menu
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@ModelAttribute("menu") Menu menu) {
        try {
            menuService.updateById(menu);
            return new JsonResult("success");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new JsonResult("fail");
    }

    /**
     * 编辑
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/updateByJson")
    @ResponseBody
    public JsonResult updateByJson(HttpServletRequest httpServletRequest) {
        try {
            String json = httpServletRequest.getParameter("str");
            if(!StringUtils.isBlank(json)){
                List<Menu> list = JSON.parseArray(json,Menu.class);
                for(Menu menu : list){
                    menuService.updateById(menu);
                }
            }
            return new JsonResult("success");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new JsonResult("fail");
    }
    /**
     * 删除
     * @param menu
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@ModelAttribute("menu") Menu menu) {
        try {
            menuService.delete(menu);
            return new JsonResult("success");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new JsonResult("fail");
    }
}
