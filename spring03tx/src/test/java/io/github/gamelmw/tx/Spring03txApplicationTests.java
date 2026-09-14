package io.github.gamelmw.tx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class Spring03txApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;// 就是QueryRunner

    @Test
    void contextLoads() throws SQLException {
        //HikariDataSource:
        //DruidDataSource:
        System.out.println(dataSource.getConnection());
    }

}
