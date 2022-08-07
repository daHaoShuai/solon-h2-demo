package com.da.config;

import com.zaxxer.hikari.HikariDataSource;
import org.h2.tools.Server;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Init;
import org.noear.solon.annotation.Inject;
import org.noear.weed.DbContext;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;


/**
 * @author Da
 * @description xxx
 * @date 2022-08-07 21:30
 */
@Configuration
public class Config {
    @Bean
    public DataSource db1(@Inject("${demo.db1}") HikariDataSource ds) {
        try {
            //初始化表构建和和数据(重要,相当于在这里创建数据库和表)
            byte[] bytes = Files.readAllBytes(Paths.get(Utils.getResource("/db/data.sql").toURI()));
            String str = new String(bytes, StandardCharsets.UTF_8);
            String[] sqlAry = str.split(";");
            DbContext db = new DbContext("", ds);
            for (String s1 : sqlAry) {
                if (s1.length() > 10) {
                    db.exe(s1);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ds;
    }
}
