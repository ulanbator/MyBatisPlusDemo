package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mybatisplusdemo.entity.User;
import org.springframework.stereotype.Component;


/**
 * @author fangzheng
 * @date
 */
@Component
public interface UserMapper extends BaseMapper<User> {
    User selectAllByName(String userName);

    IPage<User> selectPageByAge(IPage<?> page, Integer age);
}
