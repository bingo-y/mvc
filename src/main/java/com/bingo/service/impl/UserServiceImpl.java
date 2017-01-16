package com.bingo.service.impl;

import com.bingo.cache.redis.RedisCache;
import com.bingo.dao.UserDao;
import com.bingo.entity.User;
import com.bingo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/12/13 0013.
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserDao userDao;
    @Autowired
    RedisCache redisCache;

    @Override
    public User selectUser(int id) {
        //先判断缓存中有没有用户数据
        String cache_key = RedisCache.CAHCENAME + ":user:" +id;
        User user = redisCache.getCache(cache_key, User.class);
        if (user == null) {
            //缓存中没有，从数据库获取，并存入缓存
            user = userDao.selectUser(id);
            //有效期60s
            redisCache.putCacheWithExpireTime(cache_key, user, RedisCache.CAHCETIME);
            LOG.info("get user with key : " + cache_key + " from dao:" + user.getName());
        } else {
            LOG.info("get cache with key : " + cache_key + " from dao:" + user.getName());
        }
        return user;
    }
}
