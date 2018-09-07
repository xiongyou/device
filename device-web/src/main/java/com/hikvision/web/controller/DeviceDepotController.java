package com.hikvision.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.domain.DeviceDepotDO;
import com.hikvision.domain.DeviceReceiveDO;
import com.hikvision.domain.UserDO;
import com.hikvision.service.DeviceDepotService;
import com.hikvision.service.DeviceReceiveService;
import com.hikvision.service.UserService;
import com.hikvision.service.page.Page;
import com.hikvision.service.vo.User;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.commons.lang.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by xiongyou on 2018/8/17.
 */
@Controller
@RequestMapping("/depot")
public class DeviceDepotController extends SuperController {
    @Autowired
    private DeviceDepotService deviceDepotService;

    @Autowired
    private DeviceReceiveService deviceReceiveService;


    @RequestMapping("/list")
    public String list(Model model) {

        return "/depot/list";
    }

    @RequestMapping("/edit")
    public String edit(Model model) {

        String deviceIdStr =request.getParameter("deviceId");

        if (deviceIdStr != null) {
            int deviceId = Integer.parseInt(deviceIdStr);
            DeviceDepotDO deviceDepot = deviceDepotService.selectByPrimaryKey(deviceId);
            model.addAttribute("deviceDepotDo" , deviceDepot);

            model.addAttribute("update" , "update");
        }
        return "/depot/edit";
    }

    @ResponseBody
    @RequestMapping("/editDepot")
    public String editProject(DeviceDepotDO deviceDepotDO) {
        JSONObject json = new JSONObject();
        String success1="";
        String error1="";
        String update = request.getParameter("update");
        UserDO user=(UserDO) request.getSession().getAttribute("user");
        try {
            if(update!=null&&!update.equals("")&&!update.equals("null")){
                deviceDepotDO.setEditTime(new Date());
                deviceDepotService.update(deviceDepotDO);
                success1="修改成功";
            }else{
                deviceDepotDO.setUId(user.getid());
                deviceDepotDO.setAddTime(new Date());
                deviceDepotDO.setEditTime(deviceDepotDO.getAddTime());
                deviceDepotService.insert(deviceDepotDO);
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
    @RequestMapping("/getDepotList")
    public String getDepotList() {

        Page<DeviceDepotDO> page = getPage();
        deviceDepotService.selectByPage(page);
        return jsonPage(page);
    }

    @RequestMapping("/receive")
    public String receive(Model model){
        String deviceIdStr =request.getParameter("deviceId");

        if (deviceIdStr != null) {
            int deviceId = Integer.parseInt(deviceIdStr);
            DeviceDepotDO deviceDepot = deviceDepotService.selectByPrimaryKey(deviceId);
            model.addAttribute("deviceDepotDo" , deviceDepot);
        }
        return "/depot/receive";
    }

    @ResponseBody
    @RequestMapping("/receiveDevice")
    public String receiveDevice(DeviceDepotDO deviceDepotDO) {
        JSONObject json = new JSONObject();
        String success1="";
        String error1="";
        UserDO user=(UserDO) request.getSession().getAttribute("user");
        String receiveAmountStr= request.getParameter("recAmount");
        try {
            DeviceReceiveDO deviceReceiveDO=new DeviceReceiveDO();
            int receiveAmount = Integer.parseInt(receiveAmountStr);
            deviceDepotDO.setAmount(deviceDepotDO.getAmount()-receiveAmount);
            deviceDepotDO.setEditTime(new Date());

            deviceReceiveDO.setUserId(user.getid());
            deviceReceiveDO.setDeviceId(deviceDepotDO.getDId());
            deviceReceiveDO.setStatus(1);
            deviceReceiveDO.setReceiveTime(deviceDepotDO.getEditTime());
            deviceDepotService.update(deviceDepotDO);
            for(int i=0;i<receiveAmount;i++){
                deviceReceiveDO.setReceiveDeviceNumber(deviceReceiveDO.getUserId() + "-" + deviceReceiveDO.getDeviceId() + "-" + System.currentTimeMillis());
                deviceReceiveService.insert(deviceReceiveDO);
            }
            success1="领取成功";

            json.put("success" , true);
            json.put("data" , success1);

        } catch (Exception e) {
            e.printStackTrace();
                error1="领取失败";
            json.put("success" , false);
            json.put("data" , error1);
        }

        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/getDepotListWord")
    public String getDepotListField() {
        String word="%";
        String word1=request.getParameter("word");
        word+=word1+"%";
        Page<DeviceDepotDO> page = getPage();
        deviceDepotService.selectByPageField(page,word);
        return jsonPage(page);
    }

    @ResponseBody
    @RequestMapping("/delDepot/{depotId}")
    public String delDepot(@PathVariable String depotId) {

        deviceDepotService.deleteByPrimaryKey(Integer.parseInt(depotId));
        return Boolean.TRUE.toString();
    }

    @ResponseBody
    @RequestMapping("/{depotId}")
    public DeviceDepotDO getDepot(@PathVariable String depotId) {

        return deviceDepotService.selectByPrimaryKey(Integer.parseInt(depotId));
    }

}
