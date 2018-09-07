package com.hikvision.mapper;

import com.hikvision.domain.DeviceReceiveDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiongyou on 2018/8/18.
 * 领取设备的操作
 *
 * @pdOid 05edc28d-312d-498e-9efc-a5ee5c3cf516 */
public interface DeviceReceiveMapper {
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
    /** @param recDeviceId
     * @pdOid 83700b20-4692-4ee5-af72-05920bcdeab4 */
    DeviceReceiveDO selectByPrimaryKey(long recDeviceId);

    void changeStatus(@Param("status")int status,@Param("deviceRecId") long recDeviceId);

    List<DeviceReceiveDO> selectByPage(@Param("size") int size,
                                       @Param("offset") int offset,@Param("userId") long userId);

    int selectCount( long userId);
}