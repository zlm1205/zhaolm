package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.ResultPage;
import com.jk.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public ResultPage getUserList(UserBean userBean) {
        userBean.calculate();
        ResultPage result=new ResultPage();
        int count=userMapper.getUserCount(userBean);
        result.setTotal(count);
        List<UserBean> list=userMapper.getUserList(userBean);
        result.setRows(list);
        return result;

    }

    @Override
    public void addUser(UserBean userBean) {
        userMapper.addUser(userBean);
    }

    @Override
    public UserBean queryUserById(UserBean user) {
        return userMapper.queryUserById(user);
    }

    @Override
    public void updateUser(UserBean userBean) {
        userMapper.updateUser(userBean);
    }

    @Override
    public void delUser(UserBean userBean) {
        userMapper.delUser(userBean);
    }
}

