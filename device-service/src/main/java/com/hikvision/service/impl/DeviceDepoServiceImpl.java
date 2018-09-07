package com.hikvision.service.impl;

import com.hikvision.domain.DeviceDepotDO;
import com.hikvision.mapper.DeviceDepotMapper;
import com.hikvision.service.DeviceDepotService;
import com.hikvision.service.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 设备库存服务层的实现
 * Created by xiongyou on 2018/8/17.
 */
@Service
@Transactional
public class DeviceDepoServiceImpl implements DeviceDepotService {
    @Autowired
    private DeviceDepotMapper deviceDepotMapper;
    /**
     * 存储操作
     *
     * @param deviceDepot
     * @return
     */
    @Override
    public void insert(DeviceDepotDO deviceDepot) {
        deviceDepotMapper.insert(deviceDepot);
    }

    /**
     * 通过设备的自动编号删除设备
     *
     * @param dId
     * @pdOid a37747a2-8e0d-4184-a40b-7862d65cbf4e
     */
    @Override
    public void deleteByPrimaryKey(int dId) {
        deviceDepotMapper.deleteByPrimaryKey(dId);
    }

    /**
     * 通过设备的自动编号查找设备
     *
     * @param dId
     * @pdOid a58af749-fb0a-45d1-92e7-0d2734a4637d
     */
    @Override
    public DeviceDepotDO selectByPrimaryKey(int dId) {
        return deviceDepotMapper.selectByPrimaryKey(dId);
    }

    /**
     * 通过设备的手动编号查找设备
     *
     * @param deviceId
     * @pdOid 3db74e3a-a5bb-476d-ae2f-df5c1ba7b950
     */
    @Override
    public DeviceDepotDO selectByDeviceId(String deviceId) {
        return deviceDepotMapper.selectByDeviceId(deviceId);
    }

    /**
     * 通过设备的名称查找设备
     *
     * @param deviceDepotDO
     * @pdOid 5ce29344-366d-4e0d-a182-3c2b5a41dea4
     */
    @Override
    public DeviceDepotDO selectByDeviceName(DeviceDepotDO deviceDepotDO) {
        return deviceDepotMapper.selectByDeviceName(deviceDepotDO);
    }

    /**
     * 修改更新设备
     *
     * @param deviceDepotDO
     * @pdOid 272a820b-f23d-4895-89e2-defa5a2f3175
     */
    @Override
    public void update(DeviceDepotDO deviceDepotDO) {
        deviceDepotMapper.update(deviceDepotDO);
    }

    /**
     * 查询所有的设备
     *
     * @pdOid 3fbe22de-9bb2-48bb-8b21-a4a57ca966f7
     */
    @Override
    public List<DeviceDepotDO> selectAllDevice() {
        return deviceDepotMapper.selectAllDevice();
    }

    /**
     * 分页查找
     *
     * @param page
     * @pdOid dfe2b3c7-a020-4f07-859b-d60f61d096dd
     */
    @Override
    public Page<DeviceDepotDO> selectByPage(Page<DeviceDepotDO> page) {
        List<DeviceDepotDO> deviceDepotDOs = deviceDepotMapper.selectByPage(
                page.getLimit() , page.getOffset());
        page.setTotal(deviceDepotMapper.selectCount());

        page.setRecords(deviceDepotDOs);
        return page;
    }

    /**
     * 根据条件模糊分页查找
     *
     * @param page
     * @param field
     */
    @Override
    public Page<DeviceDepotDO> selectByPageField(Page<DeviceDepotDO> page, String field) {
        List<DeviceDepotDO> deviceDepotDOs = deviceDepotMapper.selectByPageField(
                page.getLimit() , page.getOffset(),field);
        page.setTotal(deviceDepotMapper.selectCountField(field));

        page.setRecords(deviceDepotDOs);
        return page;
    }

    /**
     * 查询所有的数量
     *
     * @pdOid 497b8387-d730-4088-b884-0adf3d97e3db
     */
    @Override
    public int selectCount() {
        return deviceDepotMapper.selectCount();
    }
}
