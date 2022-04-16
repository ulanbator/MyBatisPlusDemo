package com.example.mybatisplusdemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.entity.User;
import com.example.mybatisplusdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fangzheng
 * @date 2022/04/13/10/41
 */
@SpringBootTest
public class InterceptorTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testPagination(){

        Page<User> pageParam = new Page<>(0,2);
        userMapper.selectPage(pageParam, null);
        List<User> userList = pageParam.getRecords();
        System.out.println(userList);

    }
   @Test
    public void testSelectByPage(){
        Page<User> pageParam = new Page<>(0,2);
        userMapper.selectPageByAge(pageParam, 10);
        List<User> userList = pageParam.getRecords();
        userList.forEach(System.out::println);

    }
}
