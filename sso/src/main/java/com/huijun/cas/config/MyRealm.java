package com.huijun.cas.config;

import com.huijun.cas.model.User;
import com.huijun.cas.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: cas
 * @description:
 * @author: Mr.si
 * @create: 2019-06-28 15:20
 **/
public class MyRealm extends AuthorizingRealm {

    @Autowired
    IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        User user = userService.findByAccount(username);
        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(user.getRole());
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        User user = userService.findByAccount(upToken.getUsername());
        if(user == null){
            throw new AuthenticationException("该用户不存在");
        }
        if(StringUtils.isEmpty(user.getPassword())){
            throw new AuthenticationException("密码不能为空");
        }
//        查出用户不为null 比对密码是否正确
        if(!user.getPassword().equals(new String(upToken.getPassword()))){
            throw new AuthenticationException("用户名或密码输入不正确");
        }
        return new SimpleAuthenticationInfo(upToken.getPrincipal(),user.getPassword(),user.getAccount());
    }
}
