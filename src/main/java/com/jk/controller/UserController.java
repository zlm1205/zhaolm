package com.jk.controller;

import com.jk.model.ResultPage;
import com.jk.model.StringUtil;
import com.jk.model.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("toMain")
    public String toMain(){
        return  "userList";
    }

    @RequestMapping("getUserList")
    @ResponseBody
    public ResultPage getUserList(UserBean userBean){
        ResultPage map = userService.getUserList(userBean);
        return map;
    }

    @RequestMapping("toAddUser")
    public String toAddUser(){
        return "addUser";
    }

    @RequestMapping("addUser")
    @ResponseBody
    public Boolean addUser(UserBean userBean){
        try {
            String uuid=StringUtil.getUUId();
            userBean.setId(uuid);
            userService.addUser(userBean);
        } catch (Exception e) {
           return false;
        }
        return true;
    }




    @RequestMapping("toEditUser")
    public String toEdit(UserBean user, ModelMap mm){
        UserBean userBean = userService.queryUserById(user);
        mm.put("uu", userBean);
        return "updateUser";
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public Boolean updateUser(UserBean userBean){
        try {
            userService.updateUser(userBean);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @RequestMapping("delUser")
    @ResponseBody
    public Boolean delUser(UserBean userBean){
        try {
            userService.delUser(userBean);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
