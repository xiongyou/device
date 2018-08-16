package com.hikvision.web.controller;

import com.hikvision.service.UserService;
import com.hikvision.service.page.Page;
import com.hikvision.service.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by xiongyou on 2018/8/14.
 */

@Controller
@RequestMapping("/perm/user")
public class UserController extends SuperController {

    @Resource
    private UserService userService;

    @RequestMapping("/list")
    public String list(Model model) {

        return "/user/list";
    }

    @RequestMapping("/edit")
    public String edit(Model model) {

        String userId = request.getParameter("userId");
        if (userId != null) {
            User user = userService.findByID(userId);
            model.addAttribute("user" , user);
        }
        return "/user/edit";
    }

    @ResponseBody
    @RequestMapping("/getUserList")
    public String getUserList() {

        Page<User> page = getPage();

        userService.findByPage(page);
        return jsonPage(page);
    }

    @ResponseBody
    @RequestMapping("/delUser/{userId}")
    public String delUser(@PathVariable String userId) {

        userService.delete(userId);
        return Boolean.TRUE.toString();
    }

    @ResponseBody
    @RequestMapping("/{userId}")
    public User getUser(@PathVariable String userId) {

        return userService.findByID(userId);
    }

}

