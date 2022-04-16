package com.example.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author fangzheng
 * @date 2022/04/16/15/30
 */
@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version
    private Integer version;
}
