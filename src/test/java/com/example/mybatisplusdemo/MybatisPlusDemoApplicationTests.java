package com.example.mybatisplusdemo;

import com.example.mybatisplusdemo.entity.User;
import com.example.mybatisplusdemo.mapper.UserMapper;
import com.example.mybatisplusdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MybatisPlusDemoApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
        /*System.out.println("-------select all data----------");
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);*/
        /*System.out.println("------insert data----------");
        User user = new User("wang","18843426103",1);
        int count = userMapper.insert(user);
        if (count > 0 ){
            System.out.println("insert ok!");
        }else {
            System.out.println("insert error!");
        }*/

        //组装查询条件
        /*QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name","k");
        List<User> userList = userMapper.selectList(userQueryWrapper);
        userList.forEach(System.out::println);*/
        System.out.println("------select all datas----------");
        List<User> userList = userService.list();
        userList.forEach(System.out::println);
    }

}