package com.hikvision.service;

import com.hikvision.domain.DeviceDepotDO;
import com.hikvision.domain.UserDO;
import com.hikvision.service.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 设备库存的服务层
 * Created by xiongyou on 2018/8/17.
 */
public interface DeviceDepotService {
    /**
     * 存储操作
     *
     * @param deviceDepot
     * @return
     */
    void insert(DeviceDepotDO deviceDepot);

    /**
     * 通过设备的自动编号删除设备
     * @param dId
     * @pdOid a37747a2-8e0d-4184-a40b-7862d65cbf4e */
    void deleteByPrimaryKey(int dId);

    /**
     * 通过设备的自动编号查找设备
     * @param dId
     * @pdOid a58af749-fb0a-45d1-92e7-0d2734a4637d */
    DeviceDepotDO selectByPrimaryKey(int dId);

    /**
     * 通过设备的手动编号查找设备
     * @param deviceId
     * @pdOid 3db74e3a-a5bb-476d-ae2f-df5c1ba7b950 */
    DeviceDepotDO selectByDeviceId(String deviceId);

    /**
     *
     * 通过设备的名称查找设备
     * @param deviceDepotDO
     * @pdOid 5ce29344-366d-4e0d-a182-3c2b5a41dea4 */
    DeviceDepotDO selectByDeviceName(DeviceDepotDO deviceDepotDO);

    /**
     * 修改更新设备
     * @param deviceDepotDO
     * @pdOid 272a820b-f23d-4895-89e2-defa5a2f3175 */
    void update(DeviceDepotDO deviceDepotDO);

    /**
     * 查询所有的设备
     * @pdOid 3fbe22de-9bb2-48bb-8b21-a4a57ca966f7 */
    List<DeviceDepotDO> selectAllDevice();

    /**
     * 分页查找
     * @param page
     * @pdOid dfe2b3c7-a020-4f07-859b-d60f61d096dd */
    Page<DeviceDepotDO> selectByPage(Page<DeviceDepotDO> page);

    /**
     * 根据条件模糊分页查找
     * @param page
     * @param field */
    Page<DeviceDepotDO> selectByPageField(Page<DeviceDepotDO> page, String field);

    /**
     * 查询所有的数量
     * @pdOid 497b8387-d730-4088-b884-0adf3d97e3db */
    int selectCount();
}
