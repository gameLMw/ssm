package io.github.gamelmw.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /*
     * 按照username扣减账户余额
     * @param username 用户名
     * @param delta 扣减的金额
     * */
    public void updateBalanceByUsername(String username, BigDecimal delta) {
        String sql = "update account set balance = balance - ? where username = ?";
        jdbcTemplate.update(sql, delta, username);
    }
}
