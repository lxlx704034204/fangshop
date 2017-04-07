package com.fang.fangshop.web.framework;

import com.fang.fangshop.core.common.ManageContainer;
import com.fang.fangshop.core.common.RequestHolder;
import com.fang.fangshop.core.system.been.User;

import javax.servlet.http.HttpSession;

/**
 * 
 * @author wangyantao
 *
 */
public class LoginUserHolder {
	/**
	 * 取得登录用户
	 */
   public static User getLoginUser(){
	   HttpSession httpSession = RequestHolder.getSession();
	   return httpSession==null ? null:(User)httpSession.getAttribute(ManageContainer.manage_session_user_info);
   }
}
