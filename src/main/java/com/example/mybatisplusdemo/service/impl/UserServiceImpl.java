package com.example.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplusdemo.entity.User;
import com.example.mybatisplusdemo.mapper.UserMapper;
import com.example.mybatisplusdemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author fangzheng
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User selectAllByName(String userName) {
        return baseMapper.selectAllByName(userName);
    }


}
