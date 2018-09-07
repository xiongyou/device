package com.hikvision.state;

import com.hikvision.domain.DeviceDepotDO;
import com.hikvision.domain.DeviceReceiveDO;

/**
 * Created by xiongyou on 2018/8/16.
 * 报修后，处于维修中的状态
 *
 * @pdOid 965bb65c-63ba-42e1-8f5e-f9d59a264296 */
public class RepairState extends AbstractState {
    /** @param deviceReceive
     * @pdOid 1ee3a295-0c82-4eb4-b7e9-097fb0cbe834 */
    @Override
    public void handle(DeviceReceiveDO deviceReceive) {
        // TODO: implement
        if(deviceReceive.getStatus()==1) {
            deviceReceive.setState(new UsingState());
        }
        else{
            deviceReceive.setState(new BadState());
        }
    }

    /** @pdOid d7ad739c-900a-463f-b496-50a3c2283032 */
    @Override
    public int getState() {
        // TODO: implement
        return 0;
    }

}