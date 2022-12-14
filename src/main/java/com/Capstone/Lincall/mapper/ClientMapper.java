package com.Capstone.Lincall.mapper;

import com.Capstone.Lincall.domain.User;
import com.Capstone.Lincall.sql.ClientSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface ClientMapper {
    @InsertProvider(type = ClientSqlProvider.class, method = "saveSql")
    int save(User user);

    @SelectProvider(type = ClientSqlProvider.class, method = "findByID")
    User findByID(String id);
}
