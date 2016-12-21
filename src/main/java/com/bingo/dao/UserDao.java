package com.bingo.dao;

import com.bingo.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2016/12/13 0013.
 */
public interface UserDao {
    User selectUser(@Param("id") int id);
}
