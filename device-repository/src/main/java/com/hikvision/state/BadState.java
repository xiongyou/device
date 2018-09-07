package com.hikvision.state;

import com.hikvision.domain.DeviceDepotDO;
import com.hikvision.domain.DeviceReceiveDO;

/**
 * Created by xiongyou on 2018/8/16.
 * 无法维修好的设备将变为损坏状态，等待报废
 *
 * @pdOid 1edfd031-aa8e-45d7-ae87-6c2a63da761a */
public class BadState extends AbstractState {
    /** @param deviceReceive
     * @pdOid 78911512-25de-4286-b914-65492d61fc4c */
    @Override
    public void handle(DeviceReceiveDO deviceReceive) {
        // TODO: implement
        deviceReceive.setState(new ScrapState());
    }

    /** @pdOid c0713b8a-6526-4ae9-8481-c57ec629abc9 */
    @Override
    public int getState() {
        // TODO: implement
        return -1;
    }

}