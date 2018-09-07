package com.hikvision.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.domain.DeviceDepotDO;
import com.hikvision.domain.DeviceReceiveDO;
import com.hikvision.domain.RepairDO;
import com.hikvision.domain.UserDO;
import com.hikvision.service.DeviceReceiveService;
import com.hikvision.service.RepairService;
import com.hikvision.service.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 领取设备的接口
 * Created by xiongyou on 2018/8/18.
 */
@Controller
@RequestMapping("/receive")
public class DeviceReceiveController extends SuperController {
    @Autowired
    private DeviceReceiveService deviceReceiveService;

    @Autowired
    private RepairService repairService;
    @RequestMapping("/list")
    public String list(Model model) {

        return "/receive/list";
    }
    @ResponseBody
    @RequestMapping("/repair/{recDeviceId}")
    public String repair(@PathVariable String recDeviceId) {
        long recId=Long.parseLong(recDeviceId);

        JSONObject json = new JSONObject();
        String success1="";
        String error1="";
        UserDO user=(UserDO) request.getSession().getAttribute("user");
        try {
            RepairDO repairDO=new RepairDO();
            repairDO.setCallId(user.getid());
            repairDO.setDeviceRecId(recId);
            repairDO.setRepairTime(new Date());
            deviceReceiveService.changeStatus(0,recId);
            repairService.insert(repairDO);

            success1="报修成功";
            json.put("success" , true);
            json.put("data" , success1);

        } catch (Exception e) {
            e.printStackTrace();
            error1="报修失败";
            json.put("success" , false);
            json.put("data" , error1);
        }

        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/getReceiveList")
    public String getReceiveList() {
        UserDO user=(UserDO) request.getSession().getAttribute("user");
        Page<DeviceReceiveDO> page = getPage();
        deviceReceiveService.selectByPage(page,user.getid());
        return jsonPage(page);
    }


}
