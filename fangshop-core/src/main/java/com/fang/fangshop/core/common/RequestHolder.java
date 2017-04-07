package com.fang.fangshop.core.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
/**
 * 需要配置{@link org.springframework.web.context.request.RequestContextListener}
 * @author wangyantao
 *
 */
public class RequestHolder {
   public static HttpServletRequest getRequest(){
	   HttpServletRequest httpServletRequest = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	   return httpServletRequest;
   }
   public static HttpServletResponse getResponse(){
	   HttpServletResponse httpServletResponse = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
	   return httpServletResponse;
   }
   public static HttpSession getSession(){
	   return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession(true);
   }
   public static HttpSession getSession(boolean create){
	   return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession(create);
   }
}

