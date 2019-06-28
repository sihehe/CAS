package com.huijun.cas.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huijun.cas.QuickStart;
import com.huijun.cas.dao.UserMapper;
import com.huijun.cas.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program: cas
 * @description: this is test class
 * @author: Mr.si
 * @create: 2019-06-28 10:15
 **/

@SpringBootTest(classes = QuickStart.class)
@RunWith(SpringRunner.class)
public class TestCAS {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test1(){
        List<User> list = userMapper.selectList(null);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username","张三");
        List<User> list1 = userMapper.selectList(wrapper);
        for (User user : list1) {
            System.out.println(user);
        }
    }
}
