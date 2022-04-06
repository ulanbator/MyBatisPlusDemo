package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplusdemo.entity.User;
import org.springframework.stereotype.Component;


@Component
public interface UserMapper extends BaseMapper<User> {
}
