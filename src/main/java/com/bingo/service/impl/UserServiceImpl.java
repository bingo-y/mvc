package com.bingo.service.impl;

import com.bingo.dao.UserDao;
import com.bingo.entity.User;
import com.bingo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/12/13 0013.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User selectUser(int id) {
        return userDao.selectUser(id);
    }
}
