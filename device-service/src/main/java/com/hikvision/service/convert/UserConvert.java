package com.hikvision.service.convert;

import com.hikvision.domain.UserDO;
import com.hikvision.service.vo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户对象转换器
 * Created by xiongyou on 2018/8/14.
 */
public class UserConvert {
    /**
     * DO对象转换VO对象
     *
     * @param userDO
     * @return
     */
    public static User do2VO(UserDO userDO) {

        if (userDO == null) {
            return null;
        }

        User user = new User();

        user.setUserId(userDO.getUserId());
        user.setUserName(userDO.getUserName());
        user.setNickName(userDO.getNickName());
        user.setPassword(userDO.getPassword());
        user.setCreateTime(userDO.getCreateTime());
        user.setModifyTime(userDO.getModifyTime());

        return user;
    }

    /**
     * DO列表转换VO列表
     *
     * @param doList
     * @return
     */
    public static List<User> doList2VOList(List<UserDO> doList) {

        if (doList == null || doList.size() == 0) {
            return null;
        }

        List<User> userList = new ArrayList<User>();

        for (UserDO userDO : doList) {

            userList.add(do2VO(userDO));
        }

        return userList;
    }

    /**
     * VO对象转换DO对象
     *
     * @param user
     * @return
     */
    public static UserDO vo2DO(User user) {

        if (user == null) {
            return null;
        }

        UserDO userDO = new UserDO();

        userDO.setUserId(user.getUserId());
        userDO.setUserName(user.getUserName());
        userDO.setNickName(user.getNickName());
        userDO.setPassword(user.getPassword());
        userDO.setUserType(user.getUserType());
        userDO.setCreateTime(user.getCreateTime());
        userDO.setModifyTime(user.getModifyTime());

        return userDO;
    }
}
