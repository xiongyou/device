package com.hikvision.state;

import com.hikvision.domain.DeviceDepotDO;
import com.hikvision.domain.DeviceReceiveDO;

/**
 * Created by xiongyou on 2018/8/16.
 * 设备状态抽象类
 *
 * @pdOid 5bedf8bb-7693-4adb-bf87-17c1e54356f0 */
public abstract class AbstractState {
    /** @pdOid 8a095cc8-fd14-4d44-9d7c-165fb26b8fd4 */
    protected DeviceReceiveDO deviceReceive;
    /** @pdOid 2dabbf2e-a979-451f-89ed-4659e8753373 */
    protected int state;

    /** @param deviceReceive
     * @pdOid 14d4347a-e933-4401-8227-3507792d8eb0 */
    public void handle(DeviceReceiveDO deviceReceive) {
        // TODO: implement
    }

    /** @pdOid 787f0e86-e59d-46ba-b3a8-bd8048655b2f */
    public int getState() {
        // TODO: implement
        return 0;
    }

}