package com.hikvision.service.impl;

import com.hikvision.domain.DeviceDepotDO;
import com.hikvision.domain.DeviceReceiveDO;
import com.hikvision.mapper.DeviceReceiveMapper;
import com.hikvision.service.DeviceReceiveService;
import com.hikvision.service.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiongyou on 2018/8/18.
 */
@Service
@Transactional
public class DeviceReceiveServiceImpl implements DeviceReceiveService {
    @Autowired
    private DeviceReceiveMapper deviceReceiveMapper;
    /**
     * @param deviceReceiveDO
     * @pdOid bdf880aa-00aa-4315-a55c-f5c6856550db
     */
    @Override
    public void insert(DeviceReceiveDO deviceReceiveDO) {
        deviceReceiveMapper.insert(deviceReceiveDO);
    }

    /**
     * @param userId
     * @pdOid 8aeb5036-d62d-402c-bb22-97b15100f76f
     */
    @Override
    public DeviceReceiveDO selectByUserId(long userId) {
        return deviceReceiveMapper.selectByUserId( userId);
    }

    /**
     * @param deviceId
     * @pdOid 9f3bd009-44a0-4748-979a-4d09d7477555
     */
    @Override
    public DeviceReceiveDO selectByDeviceId(int deviceId) {
        return deviceReceiveMapper.selectByDeviceId(deviceId);
    }

    /**
     * @param receiveDeviceNumber
     * @pdOid 601003ab-1aa4-4de2-b849-99301d65704e
     */
    @Override
    public DeviceReceiveDO selectByReceiveDeviceNumber(String receiveDeviceNumber) {
        return deviceReceiveMapper.selectByReceiveDeviceNumber(receiveDeviceNumber);
    }

    /**
     * @param deviceReceiveDO
     * @pdOid 118f9abb-3e4a-4397-a7e0-09e4af90badd
     */
    @Override
    public void update(DeviceReceiveDO deviceReceiveDO) {
        deviceReceiveMapper.update(deviceReceiveDO);
    }

    @Override
    public DeviceReceiveDO selectByPrimaryKey(long recDeviceId) {
        return deviceReceiveMapper.selectByPrimaryKey(recDeviceId);
    }

    @Override
    public void changeStatus(int status,long recDeviceId) {
        deviceReceiveMapper.changeStatus(status,recDeviceId);
    }

    /**
     * 根据条件分页查找
     *
     * @param page
     * @param userId
     */
    @Override
    public Page<DeviceReceiveDO> selectByPage(Page<DeviceReceiveDO> page, long userId) {
        List<DeviceReceiveDO> deviceReceiveDOs = deviceReceiveMapper.selectByPage(
                page.getLimit() , page.getOffset(),userId);
        page.setTotal(deviceReceiveMapper.selectCount(userId));

        page.setRecords(deviceReceiveDOs);
        return page;
    }
}
