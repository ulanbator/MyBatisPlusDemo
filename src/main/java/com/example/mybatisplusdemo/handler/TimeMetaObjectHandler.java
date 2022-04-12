package com.example.mybatisplusdemo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author fangzheng
 * @date 2022/04/12/16/06
 * 实现mybatisplus的自动填充功能
 * 为实体中的createTime和updateTime
 * 字段定义自动填充规则
 */
@Slf4j
@Component
public class TimeMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {//插入时更新两个字段的记录
        log.info("start insert fill ......");
        this.strictInsertFill(metaObject,"createTime", () -> LocalDateTime.now(),LocalDateTime.class);
        this.strictInsertFill(metaObject,"updateTime", () -> LocalDateTime.now(),LocalDateTime.class);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ......");
        this.strictUpdateFill(metaObject,"updateTime",() -> LocalDateTime.now(),LocalDateTime.class);
    }
}
