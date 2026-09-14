package io.github.gamelmw.spring.tx;

import io.github.gamelmw.spring.tx.bean.Book;
import io.github.gamelmw.spring.tx.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;

@SpringBootTest
class Spring03txApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;// 就是QueryRunner

    @Autowired
    BookDao bookDao;

    @Test
    void testDeleteBook() {
        bookDao.deleteBook(4);
    }

    @Test
    void testUpdateBook() {
        bookDao.updateBookStock(4, 2);
    }

    @Test
    void testAddBook() {
        Book book = new Book();
        book.setBookName("西游记");
        book.setPrice(new BigDecimal("19.9"));
        book.setStock(100);
        bookDao.addBook(book);
    }

    @Test
    void testQuery() {
        System.out.println(bookDao.getBookById(1));
    }

    @Test
    void contextLoads() throws SQLException {
        //HikariDataSource:
        //DruidDataSource:
        System.out.println(dataSource.getConnection());
    }

}
