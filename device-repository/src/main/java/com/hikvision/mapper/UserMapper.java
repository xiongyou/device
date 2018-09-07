package com.hikvision.mapper;

import com.hikvision.domain.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiongyou on 2018/8/14.
 */
public interface UserMapper {

    void insert(UserDO user);

    int deleteByPrimaryKey(@Param("userId") String userId);

    UserDO selectByPrimaryKey(@Param("userId") String userId);

    UserDO selectByUserName(String userName);

    void update(UserDO user);

    List<UserDO> selectAllUser();

    List<UserDO> selectByPage(@Param("size") int size,
                              @Param("offset") int offset);

    int selectAllCount();

    /**
     * 登陆
     */
    UserDO loginUser(UserDO user);

    UserDO selectByUserAccount(@Param("userName") String userName);

    void editUser(UserDO user);
}
