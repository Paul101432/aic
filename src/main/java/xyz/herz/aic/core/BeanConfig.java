package xyz.herz.aic.core;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

import javax.sql.DataSource;

@Configuration
public class BeanConfig {

    //
    //直接配置 数据库上下文
    //
    @Bean(value = "db1" ,typed = true)
    public DataSource db1(@Inject("${lealone.db1}") HikariDataSource dataSource) {
        return dataSource;
    }
}
