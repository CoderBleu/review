package cn.lauy.controller;

import cn.lauy.annotation.Log;
import cn.lauy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.swing.*;

/**
 * @author Lauy
 * @date 2021/2/2
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/query")
    @Log
    public String queryUser(String id) {
        System.out.println("我是SpringBootVersion：" + SpringBootVersion.getVersion() + " / SpringVersion" + SpringVersion.getVersion());

        System.out.println("进入Controller类的queryUser方法");
        int i = 1 / 0;
        String result = userService.queryUser(id);
        return "我是SpringBootVersion：" + SpringVersion.getVersion() + " / " + result;
    }
}
