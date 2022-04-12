package com.example.mybatisplusdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplusdemo.entity.User;

/**
 * @author fangzheng
 */
public interface UserService extends IService<User> {
    User selectAllByName(String userName);
}
