package com.hikvision.service.impl;

import com.hikvision.domain.UserDO;
import com.hikvision.mapper.UserMapper;
import com.hikvision.service.UserService;
import com.hikvision.service.convert.UserConvert;
import com.hikvision.service.page.Page;
import com.hikvision.service.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiongyou on 2018/8/14.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @see UserService#save (com.hikvision.service.vo.User)
     */
    public void insert(UserDO user) {

        userMapper.insert(user);
    }

    /**
     * @see UserService#delete(String)
     */
    public int delete(String userId) {

        return userMapper.deleteByPrimaryKey(userId);
    }

    /**
     * @see UserService#update (com.hikvision.service.vo.User)
     */
    public void update(UserDO user) {

        userMapper.update(user);
    }

    /**
     * @see UserService#findByName(String)
     */
    public UserDO selectByUserName(UserDO user) {

        return userMapper.selectByUserName(user);
    }

    /**
     * @see UserService#findAll()
     */
    public List<User> findAll() {

        List<UserDO> doList = userMapper.selectAllUser();

        return UserConvert.doList2VOList(doList);
    }

    /**
     * @see UserService#findByID(String)
     */
    public User findByID(String userID) {

        UserDO userDO = userMapper.selectByPrimaryKey(userID);
        return UserConvert.do2VO(userDO);
    }

    /**
     * @see UserService#findByPage(Page)
     */
    public Page<User> findByPage(Page<User> page) {

        List<UserDO> keyWords = userMapper.selectByPage(page.getLimit() ,
                page.getOffset());
        page.setTotal(userMapper.selectAllCount());

        page.setRecords(UserConvert.doList2VOList(keyWords));
        return page;
    }

    public User findByName(String userName) {
        // TODO Auto-generated method stub
        return null;
    }

    public UserDO loginUser(UserDO user) {
        // TODO Auto-generated method stub
        return userMapper.loginUser(user);
    }

    public UserDO selectByUserAccount(String userName) {
        // TODO Auto-generated method stub
        return userMapper.selectByUserAccount(userName);
    }

    public void editUser(UserDO user) {
        // TODO Auto-generated method stub
        userMapper.editUser(user);
    }
}
