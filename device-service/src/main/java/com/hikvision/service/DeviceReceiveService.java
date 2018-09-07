package com.hikvision.service;

import com.hikvision.domain.DeviceDepotDO;
import com.hikvision.domain.DeviceReceiveDO;
import com.hikvision.service.page.Page;

/**
 * Created by xiongyou on 2018/8/18.
 */
public interface DeviceReceiveService {
    /** @pdOid bdf880aa-00aa-4315-a55c-f5c6856550db */
    void insert(DeviceReceiveDO deviceReceiveDO);
    /** @pdOid 8aeb5036-d62d-402c-bb22-97b15100f76f */
    DeviceReceiveDO selectByUserId(long userId);
    /** @pdOid 9f3bd009-44a0-4748-979a-4d09d7477555 */
    DeviceReceiveDO selectByDeviceId(int deviceId);
    /** @pdOid 601003ab-1aa4-4de2-b849-99301d65704e */
    DeviceReceiveDO selectByReceiveDeviceNumber(String receiveDeviceNumber);
    /** @pdOid 118f9abb-3e4a-4397-a7e0-09e4af90badd */
    void update(DeviceReceiveDO deviceReceiveDO);

    DeviceReceiveDO selectByPrimaryKey(long recDeviceId);
    void changeStatus(int status,long recDeviceId);
    Page<DeviceReceiveDO> selectByPage(Page<DeviceReceiveDO> page, long userId);
}
