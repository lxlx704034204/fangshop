package com.fang.fangshop.web.controller;

import com.fang.fangshop.been.AreaModel;
import com.fang.fangshop.services.IAreaService;
import com.fang.fangshop.web.framework.BaseController;
import com.fang.fangshop.web.framework.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/manage/area")
public class AreaController extends BaseController {
    private static final String page_area="manage/area/areaManage";

    @Autowired
    private IAreaService areaService;
    @RequestMapping("/areaTree")
    public String areaTree(){
        return page_area;
    }

    /**
     * 搜索
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public JsonResult search(){
        try {
            List<AreaModel> list = areaService.selectList(null);
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
    public JsonResult insert(@ModelAttribute("area") AreaModel area){
        try {
            boolean isExist = areaService.exists(area.getCode());
            if(isExist){
                areaService.update(area);
            } else {
                areaService.insert(area);
            }
            return new JsonResult("success");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JsonResult("fail", ex.getMessage());
        }
    }
    /**
     * 删除函数
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(HttpServletRequest httpServletRequest) {
        try {
            Integer id = Integer.parseInt(httpServletRequest.getParameter("id"));
            AreaModel areaModel = new AreaModel();
            areaModel.setId(id);
            areaService.delete(areaModel);
            return new JsonResult("success");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new JsonResult("fail");
    }
 }
