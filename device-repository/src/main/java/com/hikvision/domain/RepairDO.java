package com.hikvision.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by xiongyou on 2018/8/16.
 * 设备维修记录实体
 *
 * @pdOid 95d83253-e4d7-4755-ae2e-a648584ec194
 * */
@Component
public class RepairDO {
    /** 维修记录自动编号
     *
     * @pdOid e48e6634-130e-48fc-81a6-9eb31cc324c2 */
    private long repairId;
    /** 设备编号
     *
     * @pdOid 37816168-dc32-47e8-8497-48f7a9fd890b */
    private long deviceRecId;
    /**
     * 报修人员
     */
    private long callId;

    /** 维修人员
     *
     * @pdOid 86141b05-0279-4e00-88c6-b3b1a98e87f5 */
    private long repairman;
    /** 报修时间
     *
     * @pdOid 70f20671-2ba5-4afa-9173-95227b831884 */
    private Date repairTime;
    /** 完成时间
     *
     *
     * @pdOid d77be2a5-21cb-4f2c-8c72-de0c93702c90 */
    private Date finishTime;

    public long getRepairId() {
        return repairId;
    }

    public void setRepairId(long repairId) {
        this.repairId = repairId;
    }

    public long getDeviceRecId() {
        return deviceRecId;
    }

    public void setDeviceRecId(long deviceRecId) {
        this.deviceRecId = deviceRecId;
    }

    public long getCallId() {
        return callId;
    }

    public void setCallId(long callId) {
        this.callId = callId;
    }

    public long getRepairman() {
        return repairman;
    }

    public void setRepairman(long repairman) {
        this.repairman = repairman;
    }

    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
}