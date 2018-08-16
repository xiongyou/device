package com.hikvision.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录
 * Created by xiongyou on 2018/8/14.
 */
@Controller
public class LoginController {

    @RequestMapping("/_login")
    public String login(Model model) {

        return "/login";
    }
}
