package io.github.gamelmw.spring.tx.service.impl;

import io.github.gamelmw.spring.tx.bean.Book;
import io.github.gamelmw.spring.tx.dao.AccountDao;
import io.github.gamelmw.spring.tx.dao.BookDao;
import io.github.gamelmw.spring.tx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BookDao bookDao;

    @Autowired
    AccountDao accountDao;

    @Override
    public void checkout(String username, Integer bookId, Integer buyNum) {
        // 1.查询图书信息
        Book book = bookDao.getBookById(bookId);

        BigDecimal price = book.getPrice();

        // 2.计算扣减额度
        BigDecimal total =new BigDecimal(buyNum).multiply(price);

        // 3.扣减余额
        accountDao.updateBalanceByUsername(username, total);

        // 4.扣减库存
        bookDao.updateBookStock(bookId, buyNum);
    }
}
