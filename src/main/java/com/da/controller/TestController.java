package com.da.controller;

import com.da.po.User;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.weed.DbContext;
import org.noear.weed.annotation.Db;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Da
 * @description xxx
 * @date 2022-08-07 21:44
 */
@Controller
public class TestController {

    @Db
    private DbContext db;

    @Mapping("/") // 获取所有数据
    public List<User> list() throws SQLException {
        return db.table("user").selectList("*", User.class);
    }

    @Mapping("/add/{name}") // 增加数据
    public long add(String name) throws SQLException {
        User user = new User();
        user.setName(name);
        return db.table("user").setEntity(user).insert();
    }

}
