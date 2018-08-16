package com.hikvision.service;

import com.hikvision.domain.UserDO;
import com.hikvision.service.page.Page;

import com.hikvision.service.vo.User;
import java.util.List;

/**
 * Created by xiongyou on 2018/8/14.
 */
public interface UserService {
    /**
     * 存储操作
     *
     * @param user
     * @return
     */
    void insert(UserDO user);

    /**
     * 登陆
     */
    UserDO loginUser(UserDO user);


    /**
     * 根据用户昵称和用户名查找账号
     */
    UserDO selectByUserName(UserDO user);

    /**
     * 删除操作
     *
     * @param user
     * @return
     */
    int delete(String userId);

    /**
     * 更新操作
     *
     * @param user
     * @return
     */
    void update(UserDO user);

    /**
     * 按照用户名查找
     *
     * @param userName
     * @return
     */
    User findByName(String userName);

    /**
     * 按照用户名查找
     *
     * @param userName
     * @return
     */
    User findByID(String userID);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 分页查询
     *
     * @param size
     * @param offset
     * @return
     */
    Page<User> findByPage(Page<User> page);

    UserDO selectByUserAccount(String userName);

    void editUser(UserDO user);
}
