package com.hikvision.service;

import com.hikvision.domain.DeviceReceiveDO;
import com.hikvision.domain.RepairDO;
import com.hikvision.service.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiongyou on 2018/8/18.
 */
public interface RepairService {
    /** @param repairDO
     * @pdOid 2484230b-5678-4644-935c-982ff1d9a941 */
    void insert(RepairDO repairDO);
    /** @param repairDO
     * @pdOid bc186832-689c-481c-bdfc-b3908ecc0504 */
    void update(RepairDO repairDO);
    /** @param repairman
     * @pdOid 224e0b27-29f8-492b-b804-1dcd21844e92 */
    Page<RepairDO> selectByRepairman(Page<RepairDO> page,long repairman);

    /** @param callPerson
     * @pdOid 048e89be-da9b-4408-a442-01ddafa69aaf */
    Page<RepairDO> selectByCallPerson(Page<RepairDO> page, long callPerson);

    /**
     * @pdOid 048e89be-da9b-4408-a442-01ddafa69aaf */
    Page<RepairDO> selectUnrepair(Page<RepairDO> page);
}
