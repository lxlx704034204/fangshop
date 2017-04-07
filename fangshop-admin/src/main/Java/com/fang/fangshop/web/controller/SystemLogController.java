package com.fang.fangshop.web.controller;

import com.fang.fangshop.core.been.SystemLog;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.services.ISystemLogService;
import com.fang.fangshop.web.framework.BaseController;
import com.fang.fangshop.web.framework.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangyantao on 2017/4/6.
 */
@RequestMapping("/manage/systemlog")
@Controller
public class SystemLogController extends BaseController {
    private final static String page_toList = "manage/systemLog/systemLogList";
    @Autowired
    private ISystemLogService systemLogService;
    /**
     * 列表
     *
     * @return
     */
    @RequestMapping("/selectList")
    public String selectList() {
        return page_toList ;
    }
    /**
     * 分页获取用户列表
     *
     * @param systemLog
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public JsonResult search(@ModelAttribute("systemLog") SystemLog systemLog) {
        try {
            PageModel pageModel = systemLogService.selectPageList(systemLog);
            return new JsonResult("success", pageModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JsonResult("fail", ex.getMessage());
        }
    }
}
