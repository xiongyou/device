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
    @Override
    public void insert(UserDO user) {

        userMapper.insert(user);
    }

    /**
     * @see UserService#delete(String)
     */
    @Override
    public int delete(String userName) {

        return userMapper.deleteByPrimaryKey(userName);
    }

    /**
     * @see UserService#update (com.hikvision.service.vo.User)
     */
    @Override
    public void update(UserDO user) {

        userMapper.update(user);
    }

    /**
     * @see UserService#findByName(String)
     */
    @Override
    public UserDO selectByUserName(String user) {

        return userMapper.selectByUserName(user);
    }

    /**
     * @see UserService#findAll()
     */
    @Override
    public List<User> findAll() {

        List<UserDO> doList = userMapper.selectAllUser();

        return UserConvert.doList2VOList(doList);
    }

    /**
     * @see UserService#findByID(String)
     */
    @Override
    public User findByID(String userID) {

        UserDO userDO = userMapper.selectByPrimaryKey(userID);
        return UserConvert.do2VO(userDO);
    }

    /**
     * @see UserService#findByPage(Page)
     */
    @Override
    public Page<User> findByPage(Page<User> page) {

        List<UserDO> keyWords = userMapper.selectByPage(page.getLimit() ,
                page.getOffset());
        page.setTotal(userMapper.selectAllCount());

        page.setRecords(UserConvert.doList2VOList(keyWords));
        return page;
    }


    @Override
    public UserDO findByName(String userName) {
        // TODO Auto-generated method stub
        return userMapper.selectByUserName(userName);
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
