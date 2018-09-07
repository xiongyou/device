package com.hikvision.state;

import com.hikvision.domain.DeviceDepotDO;
import com.hikvision.domain.DeviceReceiveDO;

/**
 * Created by xiongyou on 2018/8/16.
 * 设备被报废的状态
 *
 * @pdOid 7bf79ac1-569d-4afa-935f-1bfcd3e7e83e */
public class ScrapState extends AbstractState {
    /** @param deviceReceive
     * @pdOid 09e12258-aa98-4ce6-ae48-7d4a5b6563e7 */
    @Override
    public void handle(DeviceReceiveDO deviceReceive) {
        // TODO: implement
    }

    /** @pdOid 9bc0095d-e631-4cb9-b153-f7418277302c */
    @Override
    public int getState() {
        // TODO: implement
        return -2;
    }

}