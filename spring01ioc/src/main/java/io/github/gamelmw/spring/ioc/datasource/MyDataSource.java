package io.github.gamelmw.spring.ioc.datasource;

import lombok.Data;

@Data
//@Component
public class MyDataSource {

    private String url;
    private String username;
    private String password;

}
