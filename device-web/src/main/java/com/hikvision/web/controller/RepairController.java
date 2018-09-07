package com.hikvision.web.controller;

import com.hikvision.domain.DeviceReceiveDO;
import com.hikvision.domain.RepairDO;
import com.hikvision.domain.UserDO;
import com.hikvision.service.RepairService;
import com.hikvision.service.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by xiongyou on 2018/8/18.
 */
@Controller
@RequestMapping("/repair")
public class RepairController extends SuperController {
    @Autowired
    private RepairService repairService;

    @RequestMapping("/list")
    public String list(Model model) {

        return "/repair/list";
    }

    @ResponseBody
    @RequestMapping("/getList")
    public String getList() {
        UserDO user=(UserDO) request.getSession().getAttribute("user");
        Page<RepairDO> page = getPage();
        repairService.selectUnrepair(page);
        return jsonPage(page);
    }

    @RequestMapping("/callList")
    public String callList(Model model) {

        return "/repair/callList";
    }

    @ResponseBody
    @RequestMapping("/getCallList")
    public String getCallList() {
        UserDO user=(UserDO) request.getSession().getAttribute("user");
        Page<RepairDO> page = getPage();
        repairService.selectByCallPerson(page,user.getid());
        return jsonPage(page);
    }

    @RequestMapping("/repairList")
    public String repairList(Model model) {

        return "/repair/repairList";
    }

    @ResponseBody
    @RequestMapping("/getRepairList")
    public String getRepairList() {
        UserDO user=(UserDO) request.getSession().getAttribute("user");
        Page<RepairDO> page = getPage();
        repairService.selectByRepairman(page,user.getid());
        return jsonPage(page);
    }



    @ResponseBody
    @RequestMapping("/finish/{repairId}")
    public String repair(@PathVariable String repairId) {
        UserDO user=(UserDO) request.getSession().getAttribute("user");
        long repId=Long.parseLong(repairId);
        RepairDO repairDO=new RepairDO();
        repairDO.setRepairId(repId);
        repairDO.setRepairman(user.getid());
        repairDO.setFinishTime(new Date());
        repairService.update(repairDO);
        return Boolean.TRUE.toString();
    }


}
