package com.jk.service;

import com.jk.model.ResultPage;
import com.jk.model.UserBean;

public interface UserService {


    ResultPage getUserList(UserBean userBean);

    void addUser(UserBean userBean);

    UserBean queryUserById(UserBean user);

    void updateUser(UserBean userBean);

    void delUser(UserBean userBean);
}
