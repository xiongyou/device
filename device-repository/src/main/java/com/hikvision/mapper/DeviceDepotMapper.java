package com.hikvision.mapper;

import com.hikvision.domain.DeviceDepotDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiongyou on 2018/8/16.
 * 设备库存的管理DAO接口
 *
 * @pdOid fe26aaa1-b441-4ecf-9d96-0e37b1de3e15 */
public interface DeviceDepotMapper {
    /** @param deviceDepotDO
     * @pdOid bb4a06af-b525-48eb-aedc-b3e9932ac5c2 */
    void insert(DeviceDepotDO deviceDepotDO);
    /** @param dId
     * @pdOid a37747a2-8e0d-4184-a40b-7862d65cbf4e */
    void deleteByPrimaryKey(int dId);
    /** @param dId
     * @pdOid a58af749-fb0a-45d1-92e7-0d2734a4637d */
    DeviceDepotDO selectByPrimaryKey(int dId);
    /** @param deviceId
     * @pdOid 3db74e3a-a5bb-476d-ae2f-df5c1ba7b950 */
    DeviceDepotDO selectByDeviceId(String deviceId);
    /** @param deviceDepotDO
     * @pdOid 5ce29344-366d-4e0d-a182-3c2b5a41dea4 */
    DeviceDepotDO selectByDeviceName(DeviceDepotDO deviceDepotDO);
    /** @param deviceDepotDO
     * @pdOid 272a820b-f23d-4895-89e2-defa5a2f3175 */
    void update(DeviceDepotDO deviceDepotDO);
    /** @pdOid 3fbe22de-9bb2-48bb-8b21-a4a57ca966f7 */
    List<DeviceDepotDO> selectAllDevice();
    /** @param size
     * @param offset
     * @pdOid dfe2b3c7-a020-4f07-859b-d60f61d096dd */
    List<DeviceDepotDO> selectByPage(@Param("size") int size,
                                     @Param("offset") int offset);

    /** @pdOid 497b8387-d730-4088-b884-0adf3d97e3db */
    int selectCount();


    List<DeviceDepotDO> selectByPageField(@Param("size") int size,
                                          @Param("offset") int offset,@Param("field")  String field);

    /**
     * 该字段所有的数量
     * @return
     */
    int selectCountField(@Param("field") String field);

}