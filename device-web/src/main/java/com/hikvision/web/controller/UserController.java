package com.hikvision.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.domain.DeviceDepotDO;
import com.hikvision.domain.UserDO;
import com.hikvision.service.UserService;
import com.hikvision.service.page.Page;
import com.hikvision.service.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by xiongyou on 2018/8/14.
 */

@Controller
@RequestMapping("/user")
public class UserController extends SuperController {

    @Resource
    private UserService userService;

    @RequestMapping("/list")
    public String list(Model model) {

        return "/user/list";
    }

    @RequestMapping("/edit")
    public String edit(Model model) {

        String userName = request.getParameter("userName");
        if (userName != null) {
            UserDO user = userService.findByName(userName);
            model.addAttribute("user" , user);
            model.addAttribute("update" , "update");
        }
        return "/user/edit";
    }

    @ResponseBody
    @RequestMapping("/editUser")
    public String editProject(UserDO userDO) {
        JSONObject json = new JSONObject();
        String success1="";
        String error1="";
        String update = request.getParameter("update");
        try {
            if(update!=null&&!update.equals("")&&!update.equals("null")){
                userDO.setModifyTime(new Date());
                userService.update(userDO);
                success1="修改成功";
            }else{
                userDO.setCreateTime(new Date());
                userDO.setModifyTime(userDO.getCreateTime());
                userService.insert(userDO);
                success1="添加成功";
            }
            json.put("success" , true);
            json.put("data" , success1);

        } catch (Exception e) {
            e.printStackTrace();
            if(update!=null&&!update.equals("")&&!update.equals("null")&&update.equals("update")){
                error1="修改失败";
            }else{
                error1="添加失败";
            }
            json.put("success" , false);
            json.put("data" , error1);
        }

        return json.toJSONString();
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
    public String delUser(@PathVariable String userName) {

        userService.delete(userName);
        return Boolean.TRUE.toString();
    }

    @ResponseBody
    @RequestMapping("/{userId}")
    public User getUser(@PathVariable String userId) {

        return userService.findByID(userId);
    }

}

