package com.ppsm.mobile.interceptor;

import com.ppsm.mobile.sys.common.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description:
 * @Author: LiuYiQiang
 * @Date: 20:59 2018/5/14
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private final static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * Handler执行之前调用这个方法
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String requestURI=request.getRequestURI();
        String tokenStr=request.getParameter("token");
        String token="";
        if(requestURI.contains("/api/")){
            token=request.getHeader("token");
            if(token==null && tokenStr==null){
                System.out.println("real token:======================is null");
                String str="{'errorCode':801,'message':'缺少token，无法验证','data':null}";
                dealErrorReturn(request,response,str);
                return false;
            }
            if(tokenStr!=null){
                token=tokenStr;
            }
            token= JwtUtil.updateToken(token);
            System.out.println("real token:=============================="+token);
            System.out.println("real ohter:=============================="+request.getHeader("Cookie"));
        }

        response.setHeader("token",token);
      /*  httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT");*/
        return true;
    }

    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * Handler执行完成之后调用这个方法
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    // 检测到没有token，直接返回不验证
    public void dealErrorReturn(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object obj){
        String json = (String)obj;
        PrintWriter writer = null;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html; charset=utf-8");
        try {
            writer = httpServletResponse.getWriter();
            writer.print(json);

        } catch (IOException ex) {
            logger.error("response error",ex);
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
