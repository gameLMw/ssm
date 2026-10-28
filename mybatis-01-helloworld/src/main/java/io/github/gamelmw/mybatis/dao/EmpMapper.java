package io.github.gamelmw.mybatis.dao;

import io.github.gamelmw.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

@Mapper //告诉spring,这是mybatis的操作数据库的接口
public interface EmpMapper {

    Emp getEmpById(Integer id);
}
