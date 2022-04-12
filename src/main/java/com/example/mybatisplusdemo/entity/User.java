package com.example.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fangzheng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(value = "t_user")
@TableName("t_user")
public class User {
   // @TableId(type = IdType.ASSIGN_ID)
    @TableId
    private Long uid;

    private String userName;

    private String phoneNumber;

    private int gender;

}
