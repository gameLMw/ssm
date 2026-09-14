package io.github.gamelmw.spring.tx.dao;

import io.github.gamelmw.spring.tx.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /*
     * 按照id查询图书
     * */
    public Book getBookById(Integer id) {

        //1.查询图书的sql
        String sql = "select * from book where id = ?";

        //2.执行sql
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);

        return book;
    }

    /*
     * 添加图书
     * */
    public void addBook(Book book) {
        String sql = "insert into book (bookName, price, stock) values (?, ?, ?)";
        jdbcTemplate.update(sql, book.getBookName(), book.getPrice(), book.getStock());
    }

    /*
     * 根据id更新图书库存
     * @param id 图书id
     * @param num 减少的数量
     * */
    public void updateBookStock(Integer bookId, Integer num) {
        String sql = "update book set stock = stock - ? where id = ?";
        jdbcTemplate.update(sql, num, bookId);
    }

    /*
     * 根据id删除图书
     * @param id 图书id
     */
    public void deleteBook(Integer id) {
        String sql = "delete from book where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
