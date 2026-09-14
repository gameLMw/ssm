package io.github.gamelmw.spring.tx.service;

public interface UserService {

    /*
     * 用户结账
     * @param username 用户名
     * @param bookId 图书ID
     * @param buyNum 购买数量
     * */
    void checkout(String username, Integer bookId, Integer buyNum);
}
