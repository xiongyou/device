package com.hikvision.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * Created by xiongyou on 2018/8/14.
 */
@Controller
public class IndexController extends SuperController {

    @RequestMapping("/index")
    public String index(Model model) {

        return "/index";
    }
}