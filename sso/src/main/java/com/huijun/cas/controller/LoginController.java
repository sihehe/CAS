package com.huijun.cas.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huijun.cas.dao.UserMapper;
import com.huijun.cas.model.User;
import com.huijun.cas.service.IUserService;
import com.huijun.cas.service.impl.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @program: cas
 * @description: 登录contriller
 * @author: Mr.si
 * @create: 2019-06-27 18:18
 **/

@Controller
public class LoginController {

    @Autowired
    IUserService userService;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/login")
    public String toLogin() {
        return "login.html";
    }

    @GetMapping("/hello")
    public String admin(Model model) {
        return "hello.html";
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (Exception e) {
//            e.printStackTrace();
            return "/error";
        }
        return "redirect:hello";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        SecurityUtils.getSubject().logout();
        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            cookie = new Cookie(cookie.getName(),"");
            cookie.setMaxAge(0);
            res.addCookie(cookie);
        }
        req.logout();
        return "index.html";
    }

}
