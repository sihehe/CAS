package com.huijun.cas.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huijun.cas.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @program: cas
 * @description: UserDao类
 * @author: Mr.si
 * @create: 2019-06-27 17:20
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
