package com.example.mybatisplusdemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.entity.Product;
import com.example.mybatisplusdemo.entity.User;
import com.example.mybatisplusdemo.mapper.ProductMapper;
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

    @Resource
    private ProductMapper productMapper;

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


    @Test
    public void concurrentTest(){
        //1、小李
        Product p1 = productMapper.selectById(1L);

        //2、小王
        Product p2 = productMapper.selectById(1L);

        //3、小李将价格加了50元，存入了数据库
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("小李修改结果：" + result1);

        //4、小王将商品减了30元，存入了数据库
        p2.setPrice(p2.getPrice() - 30);
        int result2 = productMapper.updateById(p2);
        System.out.println("小王修改结果：" + result2);
        if(result2 == 0){
            //重试机制
            p2 = productMapper.selectById(1L);
            p2.setPrice(p2.getPrice() - 30);
            result2 = productMapper.updateById(p2);
            System.out.println("小王修改结果：" + result2);
        }

        //最后的结果
        Product p3 = productMapper.selectById(1L);
        System.out.println("最后的结果：" + p3.getPrice());
    }
}
