package com.hikvision.mapper;

import com.hikvision.domain.RepairDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiongyou on 2018/8/18.
 */
public interface RepairMapper {

    /** @param repairDO
     * @pdOid 2484230b-5678-4644-935c-982ff1d9a941 */
    void insert(RepairDO repairDO);
    /** @param repairDO
     * @pdOid bc186832-689c-481c-bdfc-b3908ecc0504 */
    void update(RepairDO repairDO);
    /** @param repairman
     * @pdOid 224e0b27-29f8-492b-b804-1dcd21844e92 */
    List<RepairDO> selectByRepairman(@Param("size") int size,
                                     @Param("offset") int offset,@Param("repairman") long repairman);
    int selectCountByRepairman(@Param("repairman")  long repairman);

    /** @param callPerson
     * @pdOid 048e89be-da9b-4408-a442-01ddafa69aaf */
    List<RepairDO> selectByCallPerson(@Param("size") int size,
                                      @Param("offset") int offset,@Param("callPerson") long callPerson);
    int selectCountByCallPerson(@Param("callPerson") long callPerson);

    /** @pdOid 6a706c4b-4767-4fb5-a2db-34802be0095a */
    List<RepairDO> selectUnrepair(@Param("size") int size,
                                  @Param("offset") int offset);
    int selectCountUnrepair();
}
