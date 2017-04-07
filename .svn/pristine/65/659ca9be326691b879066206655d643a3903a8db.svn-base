package com.fang.fangshop.web.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fang.fangshop.core.common.ManageContainer;
import com.fang.fangshop.core.common.PageModel;
import com.fang.fangshop.core.system.been.Menu;
import com.fang.fangshop.core.system.been.Privilege;
import com.fang.fangshop.core.system.been.Role;
import com.fang.fangshop.core.system.been.User;
import com.fang.fangshop.services.IMenuService;
import com.fang.fangshop.services.IPrivilegeService;
import com.fang.fangshop.services.IRoleService;
import com.fang.fangshop.web.framework.BaseController;
import com.fang.fangshop.web.framework.JsonResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wangyantao on 2017/2/26.
 */
@Controller
@RequestMapping("/manage/role")
public class RoleController extends BaseController {
    private static final String page_toList = "manage/system/role/roleList";
    private static final String page_toAdd = "manage/system/role/addRole";
    private static final String page_toEdit = "manage/system/role/editRole";
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IMenuService menuService;
    @Autowired
    private IPrivilegeService privilegeService;
    /**
     * 列表
     *
     * @return
     */
    @RequestMapping("/selectList")
    public String selectList(ModelMap modelMap) {
        User curuser = (User) session.getAttribute(ManageContainer.manage_session_user_info);
        if(privilegeService.isExistsByMidAndRid(new Privilege(curuser.getRid(),59))){
            modelMap.addAttribute("add",true);
        }
        if(privilegeService.isExistsByMidAndRid(new Privilege(curuser.getRid(),60))){
            modelMap.addAttribute("edit",true);
        }
        if(privilegeService.isExistsByMidAndRid(new Privilege(curuser.getRid(),60))){
            modelMap.addAttribute("delete",true);
        }
        return page_toList ;
    }
    /**
     * 分页获取用户列表
     *
     * @param role
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public JsonResult search(@ModelAttribute("role") Role role) {
        try {
            PageModel pageModel = roleService.selectPageList(role);
            return new JsonResult("success", pageModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JsonResult("fail", ex.getMessage());
        }
    }

    /**
     * 添加
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd(ModelMap modelMap) {
        return page_toAdd;
    }
    /**
     * 编辑
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/toEdit")
    public String toEdit(@ModelAttribute("role") Role role, ModelMap modelMap) {
        Role rl = roleService.selectOne(role);
        modelMap.addAttribute("role",rl);
        return page_toEdit;
    }

    /**
     * 添加函数
     *
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public JsonResult insert(HttpServletRequest httpServletRequest) {
        String roleName = httpServletRequest.getParameter("rolename");
        String roleDesc = httpServletRequest.getParameter("roledesc");
        String status = httpServletRequest.getParameter("status");
        String ids = httpServletRequest.getParameter("ids");
        try {
            Role role = new Role(1,roleName, roleDesc, "", status);
            int id = roleService.insert(role);
            //角色关系表
            if (!StringUtils.isBlank(ids)) {
                String[] strs = ids.split(",");
                for (String roleid : strs) {
                    Privilege privilege = new Privilege(role.getId(),Integer.parseInt(roleid));
                    privilegeService.insert(privilege);
                }
            }
            return new JsonResult("success");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JsonResult("fail", ex.getMessage());
        }
    }

    /**
     * 编辑
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(HttpServletRequest httpServletRequest) {
        try {
            int id = Integer.parseInt(httpServletRequest.getParameter("id"));
            String roleName = httpServletRequest.getParameter("rolename");
            String roleDesc = httpServletRequest.getParameter("roledesc");
            String status = httpServletRequest.getParameter("status");
            String ids = httpServletRequest.getParameter("ids");

            if (StringUtils.isBlank(roleName)) {
                return new JsonResult("角色名称不能为空！");
            }
            Role role = new Role(id,roleName, roleDesc, "", status);
            //更新角色
            int rows = roleService.update(role);
            //删除旧的关系
            privilegeService.deleteByRid(id);
            //角色关系表
            if (!StringUtils.isBlank(ids)) {
                String[] strs = ids.split(",");
                for (String roleid : strs) {
                    Privilege privilege = new Privilege(id,Integer.parseInt(roleid));
                    privilegeService.insert(privilege);
                }
            }
            return new JsonResult("success");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new JsonResult("fail");
    }

    /**
     * 删除函数
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Integer id = Integer.parseInt(httpServletRequest.getParameter("id"));
            Role role = new Role();
            role.setId(id);
            roleService.delete(role);
            privilegeService.deleteByRid(id);
            return new JsonResult("success");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new JsonResult("fail");
    }
}
