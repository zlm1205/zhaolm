package com.jk.mapper;

import com.jk.model.UserBean;

import java.util.List;

public interface UserMapper {
    int getUserCount(UserBean userBean);

    List<UserBean> getUserList(UserBean userBean);

    void addUser(UserBean userBean);

    UserBean queryUserById(UserBean user);

    void updateUser(UserBean userBean);

    void delUser(UserBean userBean);
}
