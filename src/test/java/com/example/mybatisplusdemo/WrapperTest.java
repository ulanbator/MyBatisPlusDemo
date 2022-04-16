package com.example.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.mybatisplusdemo.entity.User;
import com.example.mybatisplusdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author fangzheng
 * @date 2022/04/16/15/46
 */
@SpringBootTest
public class WrapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testWrapper(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        userQueryWrapper.like("user_name", "obe").between("age",10,22);
        List<User> userList = userMapper.selectList(userQueryWrapper);
        userList.forEach(System.out::println);

    }

    @Test
    public void test2(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByDesc("age").orderByAsc("uid");
        List<User> userList = userMapper.selectList(userQueryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test3(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.isNotNull("phone_number");
        int result = userMapper.delete(userQueryWrapper);
        System.out.println("----------数据删除的结果的是:" + result);
    }

    @Test
    public void test4(){
        //条件的优先级
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name", "be").and(i -> i.lt("age", 18).or().isNotNull("gender"));//and后面条件优先级最高

        User user = new User();
        user.setAge(100);
        int result = userMapper.update(user, userQueryWrapper);
        System.out.println(result);

    }

    @Test
    public void test5(){
        //查询出所需要的列
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("user_name", "gender", "age");
        List<Map<String,Object>> maps = userMapper.selectMaps(userQueryWrapper);
        maps.forEach(System.out::println);

    }

    @Test
    public void test6(){
        //子查询示例，不推荐使用这种方式，可以通过xml方式定义
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.inSql("uid","select uid from t_user where uid > 1");
        List<User> userList = userMapper.selectList(userQueryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test7(){
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.set("age", 18)
                .set("gender", 0)
                .like("user_name", "be")
                .and(i -> i.lt("age", 18).or().isNotNull("phone_number"));

        User user = new User();
        int result = userMapper.update(user, userUpdateWrapper);
        System.out.println(result);
    }

    @Test
    public void test8(){
        String user_name = null;
        Integer ageBegin = 10;
        Integer ageEnd = 10;

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like(StringUtils.isNotBlank(user_name), "user_name", "be")
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);

        List<User> userList = userMapper.selectList(userQueryWrapper);
        userList.forEach(System.out::println);


    }
}
