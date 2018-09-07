package com.hikvision.domain;

/**
 * Created by xiongyou on 2018/8/16.
 */

import org.springframework.stereotype.Component;

import java.util.Date;

/** 设备库存对象
 *
 * @pdOid de9c86bf-7d5d-4045-b994-47947a895897 */
@Component
public class DeviceDepotDO {
    /** 设备自动编号
     *
     *
     * @pdOid fc4a671d-f331-49bf-9944-e9132289e65b */
    private int dId;
    /** 添加入库的管理员编号
     *
     * @pdOid 201e7d02-e4a2-4540-987c-b8e3f5a0b1cb */
    private long uId;
    /** 设备编号
     *
     * @pdOid 19fb739c-8423-4746-b1ba-c2408a8a619f */
    private String deviceId;
    /** 设备名称
     *
     * @pdOid 57875034-a3f5-414c-8c01-1026e6b23f35 */
    private String deviceName;
    /** 设备类型
     *
     * @pdOid 522ca348-9e75-4b06-8250-a6a9a41ea807 */
    private String deviceType;
    /** 设备配置
     *
     * @pdOid cf71b0b7-cf0b-46a4-b979-5e5e34069d32 */
    private String configuration;
    /** 设备状态
     *
     * @pdOid 032bfc0b-1049-479c-95be-4feae891943e */
    private int deviceStatus;
    /** 设备数量
     *
     *
     * @pdOid 3edbde94-f4f3-442a-8b22-a8b3e0293e78 */
    private int amount;
    /** 入库时间
     *
     * @pdOid 2b704954-25c5-4850-b777-f60cf1657a7a */
    private Date addTime;
    /** 修改时间
     *
     * @pdOid 539d64f0-c3e7-4dc8-8389-24b2bb22523b */
    private Date editTime;

    public int getDId() {
        return dId;
    }

    public void setDId(int dId) {
        this.dId = dId;
    }

    public long getUId() {
        return uId;
    }

    public void setUId(long uId) {
        this.uId = uId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public int getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(int deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }
}