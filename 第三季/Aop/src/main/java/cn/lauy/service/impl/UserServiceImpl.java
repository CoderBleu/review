package cn.lauy.service.impl;

import cn.lauy.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Lauy
 * @date 2021/2/2
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String queryUser(String id) {
        System.err.println("我进入了业务层的queryUser方法");
        return UUID.randomUUID().toString();
    }
}
