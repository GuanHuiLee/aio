package com.lgh.aio.mapper;

import com.lgh.aio.entity.UserBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserBean login(UserBean bean);

    int register(UserBean bean);
}
