package com.hikvision.state;

import com.hikvision.domain.DeviceDepotDO;
import com.hikvision.domain.DeviceReceiveDO;

/**
 * Created by xiongyou on 2018/8/16.
 * 领取设备使用中的状态
 *
 * @pdOid 51ccf689-267d-409f-8fa9-536adaa53303 */
public class UsingState extends AbstractState {
    /** @param deviceReceive
     * @pdOid 1735d84b-601f-41cd-a7aa-016b6d2fda0f */
    @Override
    public void handle(DeviceReceiveDO deviceReceive) {
        // TODO: implement
        deviceReceive.setState(new RepairState());

    }

    /** @pdOid e85854ae-4d3f-4957-93ba-e124297892f9 */
    @Override
    public int getState() {
        // TODO: implement
        return 1;
    }

}
