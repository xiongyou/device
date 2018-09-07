package com.hikvision.service.impl;

import com.hikvision.domain.RepairDO;
import com.hikvision.mapper.RepairMapper;
import com.hikvision.service.RepairService;
import com.hikvision.service.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiongyou on 2018/8/18.
 */
@Service
@Transactional
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairMapper repairMapper;
    /**
     * @param repairDO
     * @pdOid 2484230b-5678-4644-935c-982ff1d9a941
     */
    @Override
    public void insert(RepairDO repairDO) {
        repairMapper.insert(repairDO);
    }

    /**
     * @param repairDO
     * @pdOid bc186832-689c-481c-bdfc-b3908ecc0504
     */
    @Override
    public void update(RepairDO repairDO) {
        repairMapper.update(repairDO);
    }

    /**
     * @param page
     * @param repairman
     * @pdOid 224e0b27-29f8-492b-b804-1dcd21844e92
     */
    @Override
    public Page<RepairDO> selectByRepairman(Page<RepairDO> page, long repairman) {
        List<RepairDO> repairDOs = repairMapper.selectByRepairman(
                page.getLimit() , page.getOffset(),repairman);
        page.setTotal(repairMapper.selectCountByRepairman(repairman));

        page.setRecords(repairDOs);
        return page;
    }

    /**
     * @param page
     * @param callPerson
     * @pdOid 048e89be-da9b-4408-a442-01ddafa69aaf
     */
    @Override
    public Page<RepairDO> selectByCallPerson(Page<RepairDO> page, long callPerson) {
        List<RepairDO> repairDOs = repairMapper.selectByCallPerson(
                page.getLimit() , page.getOffset(),callPerson);
        page.setTotal(repairMapper.selectCountByCallPerson(callPerson));

        page.setRecords(repairDOs);
        return page;
    }

    /**
     * @param page
     * @pdOid 048e89be-da9b-4408-a442-01ddafa69aaf
     */
    @Override
    public Page<RepairDO> selectUnrepair(Page<RepairDO> page) {
        List<RepairDO> repairDOs = repairMapper.selectUnrepair(
                page.getLimit() , page.getOffset());
        page.setTotal(repairMapper.selectCountUnrepair());

        page.setRecords(repairDOs);
        return page;
    }
}
