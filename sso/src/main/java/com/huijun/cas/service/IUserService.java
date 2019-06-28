package com.huijun.cas.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huijun.cas.model.User;

/**
 * @program: cas
 * @description:
 * @author: Mr.si
 * @create: 2019-06-28 15:33
 **/
public interface IUserService{

    User findByAccount(String username);

}
