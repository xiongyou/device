package com.hikvision.domain;

/**
 * Created by xiongyou on 2018/8/16.
 */

import com.hikvision.state.AbstractState;
import org.springframework.stereotype.Component;

import java.util.Date;

/** 设备领取实体对象
 *
 * @pdOid 35ebba64-95f4-41ee-b5bb-fa35b281910a */
@Component
public class DeviceReceiveDO {
    /** 用户领取设备的自动编号
     *
     * @pdOid 2e356a7f-deca-4b32-a43e-0bf341a0b280 */
    private long deviceRecId;
    /** 领取的设备号
     *
     *
     * @pdOid 8a92d6b3-1bd2-42b3-9851-c7ce2cae9608 */
    private int deviceId;
    /** 领取的用户编号
     *
     *
     * @pdOid ceb41810-c98d-4377-8dab-38433871c689 */
    private long userId;
    /** 设备手动编号，用于设备唯一标识，由deviceId+userId+序号构成
     *
     * @pdOid 43d0fab5-0471-424c-a7de-8d836c1652ad */
    private String receiveDeviceNumber;
    /** 领取的时间
     *
     *
     * @pdOid 40698ae0-4924-4f0c-95ae-d222bbef18a4 */
    private Date receiveTime;
    /** 设备状态
     *
     * @pdOid 3a45bf38-7b30-4824-bdad-174213f92abc */
    private int status;
    /** 报废时间
     *
     *
     * @pdOid beb17377-1462-4095-a023-9f0939277eef */
    private Date scrapTime;
    /** @pdOid b33362cf-5485-4df9-b0dc-a613f82dcaf6 */
    private AbstractState state;

    /** @pdRoleInfo migr=no name=AbstractState assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
    public java.util.Collection<AbstractState> abstractState;

    /** @pdOid 66092ad1-45ad-486f-8ff8-17908ae9c07f */
    public AbstractState getState() {
        return state;
    }

    /** @param newState
     * @pdOid 88bd7488-c55c-40b6-935f-3d5243bd1a1e */
    public void setState(AbstractState newState) {
        state = newState;
    }

    public long getDeviceRecId() {
        return deviceRecId;
    }

    public void setDeviceRecId(long deviceRecId) {
        this.deviceRecId = deviceRecId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getReceiveDeviceNumber() {
        return receiveDeviceNumber;
    }

    public void setReceiveDeviceNumber(String receiveDeviceNumber) {
        this.receiveDeviceNumber = receiveDeviceNumber;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getScrapTime() {
        return scrapTime;
    }

    public void setScrapTime(Date scrapTime) {
        this.scrapTime = scrapTime;
    }
}
