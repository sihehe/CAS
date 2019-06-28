package com.huijun.cas.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: cas
 * @description: 这是一个user类
 * @author: Mr.si
 * @create: 2019-06-27 17:21
 **/
@Data
@TableName("sys_user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String  username;
    private String account;
    private String  password;
    private String role;

}
