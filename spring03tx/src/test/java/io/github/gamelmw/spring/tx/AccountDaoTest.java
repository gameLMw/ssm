package io.github.gamelmw.spring.tx;

import io.github.gamelmw.spring.tx.dao.AccountDao;
import io.github.gamelmw.spring.tx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class AccountDaoTest {

    @Autowired
    AccountDao accountDao;

    @Autowired
    UserService userService;

    // 结账
    @Test
    public void testCheckout() {
        userService.checkout("zhangsan", 1, 3);
    }

    @Test
    public void testUpdate() {
        accountDao.updateBalanceByUsername("zhangsan", new BigDecimal("9.9"));

    }
}
