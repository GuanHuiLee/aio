package com.lgh.aio.controller;

import com.lgh.aio.mapper.UserMapper;
import com.lgh.aio.entity.CodeMsg;
import com.lgh.aio.entity.Result;
import com.lgh.aio.entity.UserBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    UserMapper userMapper;

    /**
     * 登录
     *
     * @param bean 用户名，密码
     * @return 是否登录成功
     */
    @PostMapping(value = "/user/login")
    private Result login(@RequestBody UserBean bean) {
        UserBean userBean = userMapper.login(bean);
        if (userBean != null) {
            if (userBean.getPwd().equals(bean.getPwd()))
                return Result.success(userBean);
            else
                return Result.error(new CodeMsg("密码错误"));
        } else return Result.error(new CodeMsg("密码错误"));
    }

    /**
     * 注册
     *
     * @param userBean 用户名，密码，手机号
     * @return
     */
    @PostMapping(value = "/user/register")
    private Result register(@RequestBody UserBean userBean) {
        if (userBean.getName() == null)
            userBean.setName(userBean.getPhone());

        int code = 0;
        try {
            code = userMapper.register(userBean);

            if (code == 0) {
                return Result.error(new CodeMsg("注册失败"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(new CodeMsg("该用户已存在"));
        }
        System.out.println("code = " + code);

        return Result.success("注册成功");
    }
}
