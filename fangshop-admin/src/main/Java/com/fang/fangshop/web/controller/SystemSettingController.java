package com.fang.fangshop.web.controller;

import com.fang.fangshop.core.been.SystemSetting;
import com.fang.fangshop.services.ISystemSettingService;
import com.fang.fangshop.web.framework.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangyantao on 2017/4/6.
 */
@RequestMapping("/manage/systemSetting")
@Controller
public class SystemSettingController extends BaseController {
    private final static String setting = "manage/systemSetting/setting";
    @Autowired
    private ISystemSettingService systemSettingService;
    @RequestMapping("/toEdit")
    public String toEdit(ModelMap modelMap){
        SystemSetting systemSetting = new SystemSetting();
        modelMap.addAttribute("systemSetting",systemSetting);
        return setting;
    }
}