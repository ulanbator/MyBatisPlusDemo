package com.example.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author fangzheng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User {

    @TableId
    private Long uid;

    private String userName;

    private String phoneNumber;

    private int gender;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "is_deleted")
    @TableLogic
    private Boolean deleted;

    private Integer age;


}
