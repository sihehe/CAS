package com.huijun.cas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huijun.cas.dao.UserMapper;
import com.huijun.cas.model.User;
import com.huijun.cas.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: cas
 * @description: userservice实现类
 * @author: Mr.si
 * @create: 2019-06-28 15:34
 **/

@Service
public class UserService implements IUserService{

    @Autowired
    UserMapper userMapper;


    @Override
    public User findByAccount(String account) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper = wrapper.eq("account", account);
        User user = userMapper.selectOne(wrapper);
        return user;
    }
}
