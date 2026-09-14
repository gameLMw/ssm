package io.github.gamelmw.spring.tx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 操作数据库
 * 1.导入包：spring-boot-starter-jdbc,mysql-connector-java
 * 2.配置数据连接信息：spring.datasource.*
 * 3.使用JdbcTemplate操作数据库
 * */

@SpringBootApplication
public class Spring03txApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring03txApplication.class, args);
    }

}
