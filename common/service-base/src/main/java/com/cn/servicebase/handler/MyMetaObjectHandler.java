package com.cn.servicebase.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * mybatis-plus插件配置类(自动填充功能)
 *自定义实现类 MyMetaObjectHandler
 * 注解填充字段 @TableField(.. fill = FieldFill.INSERT) 生成器策略部分也可以配置！
 * insertFill() updateFill() 自动填充
 * 注意事项：
 * 填充原理是直接给entity的属性设置值!!!
 * 注解则是指定该属性在对应情况下必有值,如果无值则入库会是null
 * MetaObjectHandler提供的默认方法的策略均为:如果属性有值则不覆盖,如果填充值为null则不填充
 * 字段必须声明TableField注解,属性fill选择对应策略,该声明告知Mybatis-Plus需要预留注入SQL字段
 * 填充处理器MyMetaObjectHandler在 Spring Boot 中需要声明@Component或@Bean注入
 * 要想根据注解FieldFill.xxx和字段名以及字段类型来区分必须使用父类的strictInsertFill或者strictUpdateFill方法
 * 不需要根据任何来区分可以使用父类的fillStrategy方法
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"gmtCreate", Date.class,new Date());
        this.strictInsertFill(metaObject,"gmtModified",Date.class,new Date());
        this.strictInsertFill(metaObject,"isDelete",Integer.class,0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject,"gmtModified",Date.class,new Date());
    }
}
