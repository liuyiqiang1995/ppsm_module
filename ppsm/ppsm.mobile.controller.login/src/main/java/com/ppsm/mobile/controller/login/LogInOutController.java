package com.ppsm.mobile.controller.login;

import com.ppsm.mobile.core.login.service.ILogInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: LiuYiQiang
 * @Date: 20:53 2018/5/14
 */
@Controller
@RequestMapping("/ppsm")
public class LogInOutController {

    @Autowired
    ILogInOutService logInOutService;

    @RequestMapping(value = "/login",produces="application/json;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public void login(){
        logInOutService.login();
    }

}
